package org.huasi.car.order.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.huasi.car.common.core.enums.OrderStatusEnum;
import org.huasi.car.common.core.enums.PayTypeEnum;
import org.huasi.car.common.core.enums.PayWayEnum;
import org.huasi.car.common.core.enums.PaymentStatusEnum;
import org.huasi.car.common.core.enums.PublicEnum;
import org.huasi.car.common.core.enums.RefundApplyEnum;
import org.huasi.car.common.core.enums.RefundStatusEnum;
import org.huasi.car.common.core.enums.TradeTypeEnum;
import org.huasi.car.common.core.enums.WXTradeStateEnum;
import org.huasi.car.common.core.utils.StringUtil;
import org.huasi.car.merchant.dao.MerchantSrvDao;
import org.huasi.car.merchant.entity.MerService;
import org.huasi.car.order.dao.OrdDetailDao;
import org.huasi.car.order.dao.OrderDao;
import org.huasi.car.order.dao.OrderPaymentRecordDao;
import org.huasi.car.order.dao.OrderRefundRecordDao;
import org.huasi.car.order.entity.Order;
import org.huasi.car.order.entity.OrderDetail;
import org.huasi.car.order.entity.OrderPaymentRecord;
import org.huasi.car.order.entity.OrderRefundRecord;
import org.huasi.car.order.service.OrderService;
import org.huasi.car.payment.alipay.service.AlipayPayService;
import org.huasi.car.payment.wxpay.exception.WXPayException;
import org.huasi.car.payment.wxpay.service.WXPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tencent.protocol.refund_protocol.RefundResData;
import com.tencent.protocol.unifiedorder_protocol.UnifiedorderResData;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private OrderPaymentRecordDao paymentRecordDao;
	
	@Autowired
	private OrderRefundRecordDao refundRecordDao;

	@Autowired
	private OrdDetailDao ordDetailDao;

	@Autowired
	private MerchantSrvDao merchantSrvDao;

	@Autowired(required=false)
	private WXPayService wxPayService;
	
	@Autowired(required=false)
	private AlipayPayService alipayService;

	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT, readOnly = false)
	@Override
	public Order order(Order order,List<OrderDetail> merOrdDetails) {
		// 获取服务详情
		List<Integer> srvIds = new ArrayList<Integer>();
		for (OrderDetail merOrdDetail : merOrdDetails) {
			srvIds.add(merOrdDetail.getSrvId());
		}
		List<MerService> merchantSrvs = merchantSrvDao.getMerServiceBySrvId(srvIds);
		if(merchantSrvs==null||merchantSrvs.size()==0){
			throw new IllegalArgumentException("商铺服务不存在");
		}
		int ordTotalPrice = 0;// 订单总价格
		Date createTime = new Date();// 订单创建日期

		//订单详情
		for (int i = 0; i < merchantSrvs.size(); i++) {
			MerService merService = merchantSrvs.get(i);
			//判断商铺 服务是否过期
			if(!PublicEnum.NORMAL.equals(merService.getSrvStatus())){
				throw new IllegalArgumentException("该服务已经被删除或者禁用");
			}
			OrderDetail merOrdDetail = merOrdDetails.get(i);
			// 总价格
			int price = (int) (merService.getSrvRelPrice() * 100);
			int detailTotalPrice = price * merOrdDetail.getOrdDetailCount();
			
			merOrdDetail.setUserId(order.getUserId());
			merOrdDetail.setSrvName(merService.getSrvName());
			merOrdDetail.setSrvId(merService.getSrvId());
			merOrdDetail.setMerId(merService.getMerId());
			merOrdDetail.setOrdDetailPrice(price);
			merOrdDetail.setOrdDetailTotalPrice(detailTotalPrice);
			merOrdDetail.setCreateTime(createTime);
			
			ordTotalPrice += detailTotalPrice;
		}
		//订单信息
		order.setOutTradeNo(StringUtil.generateOrdrNo());
		order.setOutTradeType(TradeTypeEnum.EXPEND.name());
		order.setOrderAmount(ordTotalPrice);
		order.setOrderStatus(OrderStatusEnum.NOT_PAY.name());// 未支付
		order.setCreateCime(createTime);
		//保存订单信息
		order = orderDao.insert(order);
		// 保存订单详情
		for (OrderDetail merOrdDetail : merOrdDetails) {
			merOrdDetail.setOrdId(order.getOrderId());
			merOrdDetail.setOutTradeNo(order.getOutTradeNo());
		}
		merOrdDetails = ordDetailDao.insert(merOrdDetails);
		return order;
	}
	
	@Override
	public Object appPayment(String orderId, String payWay, String orderIp, String referenceUrl) throws WXPayException {
		String body = "华四车行";
		String attach = "APP后台";
		String desc = "支付测试";
		String prepareId=null;
		String deviceInfo=null;
		Date orderTime=new Date();
		Object responseObj=null;
		// 获取订单详情
		Order order = getOrderById(orderId);
		if(order==null){
			throw new IllegalArgumentException("订单不存在");
		}
		//订单已经支付完毕 无需再次支付
		if(order.getOrderStatus().equals(OrderStatusEnum.PAYMENT_SUCCESS.name())){
			throw new RuntimeException("该订单已经支付完毕");
		}
		//更新订单支付记录（订单付款 生成订单支付记录；将以前关于该订单的支付记录设置为FAIL）
		closeInvalidOrderPaymentRecord(order.getOutTradeNo(),payWay);
		//微信支付 商铺后台服务器向微信服务器发送请求 产生预支付订单
		if(PayWayEnum.WXPAY.name().equalsIgnoreCase(payWay)){
			// 微信下单
			UnifiedorderResData unifiedorderResData = wxPayService.requestUnifiedorder(body, order.getOutTradeNo(), order.getOrderAmount(),
					attach, orderIp);
			prepareId = unifiedorderResData.getPrepay_id();
			deviceInfo = unifiedorderResData.getDevice_info();
			responseObj=unifiedorderResData;
		}
		//支付宝支付  在服务端产生签名 然后将签名返回到客户端 客户端使用签名向支付宝发送app支付请求
		else if(PayWayEnum.ALIPAY.name().equalsIgnoreCase(payWay)){
			String requestPayParameter = alipayService.requestRSAService(body, attach, order.getOutTradeNo(), String.valueOf(order.getOrderAmount()));
			Map<String,String> map=new HashMap<String,String>();
			map.put("requestPayParameter", requestPayParameter);
			responseObj=map;
		}
		//保存订单支付记录
		OrderPaymentRecord paymentRecord=new OrderPaymentRecord();
		paymentRecord.setOrderId(order.getOrderId());
		paymentRecord.setOutTradeNo(order.getOutTradeNo());
		paymentRecord.setOutTradeType(TradeTypeEnum.EXPEND.name());
		paymentRecord.setPayStatus(PaymentStatusEnum.PAYMENTING.name());
		paymentRecord.setPayerUserId(order.getUserId());
		paymentRecord.setPayerPayAmount(order.getOrderAmount());
		paymentRecord.setOrderIp(orderIp);
		paymentRecord.setOrderReferenceUrl(referenceUrl);
		paymentRecord.setOrderAmount(order.getOrderAmount());
		paymentRecord.setOrderPayWay(payWay);
		paymentRecord.setOrderPayType(PayTypeEnum.APP.name());
		paymentRecord.setPayDesc(desc);
		paymentRecord.setOrderTime(orderTime);
		paymentRecord.setBody(body);
		paymentRecord.setAttach(attach);
		paymentRecord.setPrepareId(prepareId);
		paymentRecord.setDeviceInfo(deviceInfo);
		paymentRecordDao.insert(paymentRecord);
		
		//更新订单记录
		order.setOrderTime(orderTime);
		order.setPrepareId(prepareId);
		order.setDeviceInfo(deviceInfo);
		order.setOrderPayType(payWay);
		order.setOrderStatus(PayTypeEnum.APP.name());
		orderDao.update(order);
		return responseObj;
	}
	
	/**
	 * 下单时 将关于该订单的以前订单支付记录(正在支付的订单支付记录)取消
	 * @param outTradeNo
	 * @param payWay 
	 * @throws WXPayException 
	 */
	private void closeInvalidOrderPaymentRecord(String outTradeNo, String payWay) throws WXPayException {
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("outTradeNo", outTradeNo);
		paramMap.put("payStatus", PaymentStatusEnum.PAYMENTING.name());
		OrderPaymentRecord paymentRecord = paymentRecordDao.getByColumn(paramMap);
		//如果正在支付的订单支付记录不存在 则直接返回
		if(paymentRecord==null){
			return;
		}
		//更新订单支付记录
		OrderPaymentRecord record=new OrderPaymentRecord();
		record.setPayId(paymentRecord.getPayId());//根据主键更新
		record.setPayStatus(PaymentStatusEnum.PAYMENT_FAIL.name());
		record.setPayDesc("重复下单，关闭之前订单");
		paymentRecordDao.updateByColumn(record);
		//关闭微信订单（防止微信重复下单）
		if(PayWayEnum.WXPAY.name().equals(payWay)){
			wxPayService.requestCloseOrderService(outTradeNo);
		}
		//关闭支付宝订单
		else if(PayWayEnum.ALIPAY.name().equals(payWay)){
		}
	}

	@Override
	public Order getOrderById(String orderId) {
		return orderDao.getById(orderId);
	}

	@Override
	public boolean cancelOrder(String orderId,String userId) throws WXPayException {
		Order order = orderDao.getById(orderId);
		if (order == null) {
			throw new IllegalArgumentException("订单不存在orderId【"+orderId+"】");
		}
		// 如果订单未支付成功 则可以直接取消
		if (OrderStatusEnum.NOT_PAY.name().equals(order.getOrderStatus())) {
			//TODO
			//改变订单状态、订单支付记录状态
			updateOrderAndPaymentRecordStatus(order.getOutTradeNo(), order.getTransactionId(), OrderStatusEnum.CANCEL.name(), PaymentStatusEnum.PAYMENT_FAIL.name());
		}
		// 用户已经支付成功 则需要退款（并且修改用户订单状态）
		else if (OrderStatusEnum.PAYMENT_SUCCESS.name().equals(order.getOrderStatus())) {
			//TODO 生成订单退款记录
			refundPaymentSuccessOrder(order,userId);
		} 
		//CANCEL FINISH COMMENT
		else {
			throw new IllegalAccessError("该订单不能够取消");
		}
		return false;
	}

	/**
	 * 将支付成功的订单取消 生成退款记录 修改订单状态
	 * @param order 订单
	 * @param userId 订单取消用户id
	 * @throws WXPayException
	 */
	private void refundPaymentSuccessOrder(Order order,String userId) throws WXPayException {
		String outRefundNo = StringUtil.generateOrdrNo();
		// 商户退款单号
		RefundResData refundResData = wxPayService.requestRefundService(order.getTransactionId(),order.getOutTradeNo(), order.getDeviceInfo(), outRefundNo, order.getOrderAmount(), order.getOrderAmount());
		// 退款申请成功
		if (WXTradeStateEnum.SUCCESS.name().equals(refundResData.getReturn_code()) && WXTradeStateEnum.SUCCESS.name().equals(refundResData.getResult_code())) {
			Date endTime=new Date();
			//生成退款申请记录
			OrderRefundRecord refundRecord=new OrderRefundRecord();
			refundRecord.setOrderId(order.getOrderId());
			refundRecord.setOutTradeNo(order.getOutTradeNo());
			refundRecord.setOutRefundNo(outRefundNo);
			refundRecord.setRefundNo(refundResData.getRefund_id());
			refundRecord.setRefundAmount(order.getOrderAmount());
			refundRecord.setRefundStatus(RefundStatusEnum.REFUNDING.name());
			refundRecord.setRefundWay("");
			refundRecord.setRefundRequestTime(endTime);
			refundRecord.setRequestApplyFrom(RefundApplyEnum.USER.name());
			refundRecord.setRequestApplyUserId(Integer.parseInt(userId));
			refundRecord.setRefundReason("用户取消支付成功的订单");
			refundRecord.setRefundDesc("");
			refundRecordDao.insert(refundRecord);
			
			// 更新订单状态
			order.setOrderStatus(OrderStatusEnum.CANCEL.name());
			order.setEndTime(endTime);
			order.setIsRefund("YES");
			order.setSuccessRefundAmount(order.getOrderAmount());
			orderDao.updateByColumn(order);
		} else {
			throw new RuntimeException("微信申请退款出现异常");
		}			
	}

	
	@Override
	public boolean wxAppPayCall(String return_code, String result_code, String result_msg, String out_trade_no,
			String transaction_id) {
		// 处理微信支付回调成功
		if (WXTradeStateEnum.SUCCESS.name().equals(return_code)
				&& WXTradeStateEnum.SUCCESS.name().equals(result_code)) {
			completWXPaySuccessPayCall(out_trade_no, transaction_id);
		}
		// 处理微信支付回调失败
		else {
			completWXPayFailPayCall(out_trade_no, transaction_id);
		}
		return false;
	}

	/**
	 * 处理成功的支付回调
	 * @param out_trade_no 商户订单流水号
	 * @param transaction_id 微信订单号
	 * @return
	 */
	private boolean completWXPaySuccessPayCall(String out_trade_no, String transaction_id) {
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("outTradeNo", out_trade_no);
		Order order = orderDao.getByColumn(paramMap);
		if(order==null){
			throw new IllegalArgumentException("订单不存在,outTradeNo【"+out_trade_no+"】");
		}
		// 订单支付成功(已经通知过)
		if (OrderStatusEnum.PAYMENT_SUCCESS.name().equalsIgnoreCase(order.getOrderStatus())) {
			return true;
		}
		// 订单正在支付状态 更新订单状态 更新订单支付记录状态
		else if (OrderStatusEnum.NOT_PAY.name().equalsIgnoreCase(order.getOrderStatus())) {
			updateOrderAndPaymentRecordStatus(out_trade_no, transaction_id, OrderStatusEnum.PAYMENT_SUCCESS.name(),PaymentStatusEnum.PAYMENT_SUCCESS.name());
		}
		return true;
	}
	
	/**
	 * 处理失败的支付回调
	 * @param out_trade_no 商户订单流水号
	 * @param transaction_id 微信订单号
	 * @return
	 */
	private boolean completWXPayFailPayCall(String out_trade_no, String transaction_id) {
		//取消微信订单
		try {
			wxPayService.requestCloseOrderService(out_trade_no);
		} catch (WXPayException e) {
			e.printStackTrace();
		}
		//更新订单状态 更新订单支付记录状态
		updateOrderAndPaymentRecordStatus(out_trade_no, transaction_id, OrderStatusEnum.NOT_PAY.name(),PaymentStatusEnum.PAYMENT_FAIL.name());
		return true;
	}

	/**
	 * 更新订单状态 更新订单支付记录状态
	 * @param out_trade_no 订单流水号
	 * @param transaction_id 微信订单编号
	 * @param ordStatus 订单状态
	 * @param payStatus 订单支付记录状态
	 */
	public void updateOrderAndPaymentRecordStatus(String out_trade_no, String transaction_id, String ordStatus,String payStatus) {
		Date endTime=new Date();
		// 更新订单状态
		Order order = new Order();
		order.setOutTradeNo(out_trade_no);
		order.setTransactionId(transaction_id);
		order.setOrderStatus(ordStatus);
		order.setEndTime(endTime);
		order.setTransactionId(transaction_id);
		orderDao.updateByColumn(order);
		
		//更新订单支付记录状态
		OrderPaymentRecord paymentRecord=new OrderPaymentRecord();
		paymentRecord.setOutTradeNo(out_trade_no);
		paymentRecord.setPayStatus(payStatus);
		paymentRecord.setCompleteTime(endTime);
		paymentRecord.setPaySuccessTime(endTime);
		paymentRecord.setTransactionId(transaction_id);
		paymentRecordDao.updateByColumn(paymentRecord);
	}

	@Override
	public List<Order> getOrderByUserId(String userId, String orderStatus) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("userId", userId);
		paramMap.put("orderStatus", orderStatus);
		return orderDao.listByColumn(paramMap);
	}

}
