package org.huasi.car.order.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @desc 商铺订单
 * @author ganliang
 * @version 2016年8月10日 下午3:59:25
 */
public class Order implements Serializable {

	private static final long serialVersionUID = 8833758780680357541L;

	// 订单
	private Integer orderId;// 订单id
	private String outTradeNo;// 订单编号（订单流水号）
	private String outTradeType;// 交易类型 充值 消费
	private Integer userId;// 购买服务的用户id
	private Integer orderAmount;// 订单的总价格(以分为单位)
	private String orderFrom;// 订单来源
	private String orderStatus;//订单状态

	private String orderPayType;// 支付方式 APP
	private String orderPayWay;// 支付方式(ALIPAY 支付宝；WXPAY微信；)
	private Date orderTime;// 下单时间
	private String orderIp;// 下单ip
	private String orderReferenceUrl;// 从哪个页面链接过来的(可用于防诈骗)

	private int orderPeriod = 0;// 过期分钟（以分为单位）(0表示永不过期)
	private Date expireTime = null;// 订单过期时间
	private Date createCime;// 订单生成时间
	private Date endTime;// 订单结束时间

	private String isRefund;// 是否退款
	private int successRefundAmount;// 成功退款总金额(以分为单位)
	private String transactionId;// 微信订单号
	private String prepareId;// 预支付id
	private String deviceInfo;// 微信支付分配的终端设备号，与下单一致

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getOutTradeType() {
		return outTradeType;
	}

	public void setOutTradeType(String outTradeType) {
		this.outTradeType = outTradeType;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Integer orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getOrderFrom() {
		return orderFrom;
	}

	public void setOrderFrom(String orderFrom) {
		this.orderFrom = orderFrom;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderPayType() {
		return orderPayType;
	}

	public void setOrderPayType(String orderPayType) {
		this.orderPayType = orderPayType;
	}

	public String getOrderPayWay() {
		return orderPayWay;
	}

	public void setOrderPayWay(String orderPayWay) {
		this.orderPayWay = orderPayWay;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public String getOrderIp() {
		return orderIp;
	}

	public void setOrderIp(String orderIp) {
		this.orderIp = orderIp;
	}

	public String getOrderReferenceUrl() {
		return orderReferenceUrl;
	}

	public void setOrderReferenceUrl(String orderReferenceUrl) {
		this.orderReferenceUrl = orderReferenceUrl;
	}

	public int getOrderPeriod() {
		return orderPeriod;
	}

	public void setOrderPeriod(int orderPeriod) {
		this.orderPeriod = orderPeriod;
	}

	public Date getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

	public Date getCreateCime() {
		return createCime;
	}

	public void setCreateCime(Date createCime) {
		this.createCime = createCime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getIsRefund() {
		return isRefund;
	}

	public void setIsRefund(String isRefund) {
		this.isRefund = isRefund;
	}

	public int getSuccessRefundAmount() {
		return successRefundAmount;
	}

	public void setSuccessRefundAmount(int successRefundAmount) {
		this.successRefundAmount = successRefundAmount;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getPrepareId() {
		return prepareId;
	}

	public void setPrepareId(String prepareId) {
		this.prepareId = prepareId;
	}

	public String getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

}