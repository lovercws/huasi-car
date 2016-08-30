package com.tencent;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.tencent.business.DownloadBillBusiness;
import com.tencent.business.RefundBusiness;
import com.tencent.business.RefundQueryBusiness;
import com.tencent.business.ScanPayBusiness;
import com.tencent.common.Configure;
import com.tencent.protocol.downloadbill_protocol.DownloadBillReqData;
import com.tencent.protocol.pay_protocol.ScanPayReqData;
import com.tencent.protocol.pay_query_protocol.ScanPayQueryReqData;
import com.tencent.protocol.refund_protocol.RefundReqData;
import com.tencent.protocol.refund_query_protocol.RefundQueryReqData;
import com.tencent.protocol.reverse_protocol.ReverseReqData;
import com.tencent.service.DownloadBillService;
import com.tencent.service.RefundQueryService;
import com.tencent.service.RefundService;
import com.tencent.service.ReverseService;
import com.tencent.service.ScanPayQueryService;
import com.tencent.service.ScanPayService;

/**
 * SDK总入口
 */
public class WXPay {

	/**
	 * 初始化SDK依赖的几个关键配置
	 * 
	 * @param key
	 *            签名算法需要用到的秘钥
	 * @param appID
	 *            公众账号ID
	 * @param mchID
	 *            商户ID
	 * @param sdbMchID
	 *            子商户ID，受理模式必填
	 * @param certLocalPath
	 *            HTTP证书在服务器中的路径，用来加载证书用
	 * @param certPassword
	 *            HTTP证书的密码，默认等于MCHID
	 */
	public static void initSDKConfiguration(String key, String appID,
			String mchID, String sdbMchID, String certLocalPath,
			String certPassword) {
		Configure.setKey(key);
		Configure.setAppID(appID);
		Configure.setMchID(mchID);
		Configure.setSubMchID(sdbMchID);
		Configure.setCertLocalPath(certLocalPath);
		Configure.setCertPassword(certPassword);
	}

	/**
	 * 请求支付服务
	 * 
	 * @param scanPayReqData
	 *            这个数据对象里面包含了API要求提交的各种数据字段
	 * @return API返回的数据
	 * @throws Exception
	 */
	public static String requestScanPayService(ScanPayReqData scanPayReqData)
			throws Exception {
		return new ScanPayService().request(scanPayReqData);
	}

	/**
	 * 请求支付查询服务
	 * 
	 * @param scanPayQueryReqData
	 *            这个数据对象里面包含了API要求提交的各种数据字段
	 * @return API返回的XML数据
	 * @throws Exception
	 */
	public static String requestScanPayQueryService(
			ScanPayQueryReqData scanPayQueryReqData) throws Exception {
		return new ScanPayQueryService().request(scanPayQueryReqData);
	}

	/**
	 * 请求退款服务
	 * 
	 * @param refundReqData
	 *            这个数据对象里面包含了API要求提交的各种数据字段
	 * @return API返回的XML数据
	 * @throws Exception
	 */
	public static String requestRefundService(RefundReqData refundReqData)
			throws Exception {
		return new RefundService().request(refundReqData);
	}

	/**
	 * 请求退款查询服务
	 * 
	 * @param refundQueryReqData
	 *            这个数据对象里面包含了API要求提交的各种数据字段
	 * @return API返回的XML数据
	 * @throws Exception
	 */
	public static String requestRefundQueryService(
			RefundQueryReqData refundQueryReqData) throws Exception {
		return new RefundQueryService().request(refundQueryReqData);
	}

	/**
	 * 请求撤销服务
	 * 
	 * @param reverseReqData
	 *            这个数据对象里面包含了API要求提交的各种数据字段
	 * @return API返回的XML数据
	 * @throws Exception
	 */
	public static String requestReverseService(ReverseReqData reverseReqData)
			throws Exception {
		return new ReverseService().request(reverseReqData);
	}

	/**
	 * 请求对账单下载服务
	 * 
	 * @param downloadBillReqData
	 *            这个数据对象里面包含了API要求提交的各种数据字段
	 * @return API返回的XML数据
	 * @throws Exception
	 */
	public static String requestDownloadBillService(
			DownloadBillReqData downloadBillReqData) throws Exception {
		return new DownloadBillService().request(downloadBillReqData);
	}

	/**
	 * 直接执行被扫支付业务逻辑（包含最佳实践流程）
	 * 
	 * @param scanPayReqData
	 *            这个数据对象里面包含了API要求提交的各种数据字段
	 * @param resultListener
	 *            商户需要自己监听被扫支付业务逻辑可能触发的各种分支事件，并做好合理的响应处理
	 * @throws Exception
	 */
	public static void doScanPayBusiness(ScanPayReqData scanPayReqData,
			ScanPayBusiness.ResultListener resultListener) throws Exception {
		new ScanPayBusiness().run(scanPayReqData, resultListener);
	}

	/**
	 * 调用退款业务逻辑
	 * 
	 * @param refundReqData
	 *            这个数据对象里面包含了API要求提交的各种数据字段
	 * @param resultListener
	 *            业务逻辑可能走到的结果分支，需要商户处理
	 * @throws Exception
	 */
	public static void doRefundBusiness(RefundReqData refundReqData,
			RefundBusiness.ResultListener resultListener) throws Exception {
		new RefundBusiness().run(refundReqData, resultListener);
	}

	/**
	 * 运行退款查询的业务逻辑
	 * 
	 * @param refundQueryReqData
	 *            这个数据对象里面包含了API要求提交的各种数据字段
	 * @param resultListener
	 *            商户需要自己监听被扫支付业务逻辑可能触发的各种分支事件，并做好合理的响应处理
	 * @throws Exception
	 */
	public static void doRefundQueryBusiness(
			RefundQueryReqData refundQueryReqData,
			RefundQueryBusiness.ResultListener resultListener) throws Exception {
		new RefundQueryBusiness().run(refundQueryReqData, resultListener);
	}

	/**
	 * 请求对账单下载服务
	 * 
	 * @param downloadBillReqData
	 *            这个数据对象里面包含了API要求提交的各种数据字段
	 * @param resultListener
	 *            商户需要自己监听被扫支付业务逻辑可能触发的各种分支事件，并做好合理的响应处理
	 * @return API返回的XML数据
	 * @throws Exception
	 */
	public static void doDownloadBillBusiness(
			DownloadBillReqData downloadBillReqData,
			DownloadBillBusiness.ResultListener resultListener)
			throws Exception {
		new DownloadBillBusiness().run(downloadBillReqData, resultListener);
	}

	/**
	 * @Description 得到支付的验证码
	 * 
	 * @param authCode
	 *            这个是扫码终端设备从用户手机上扫取到的支付授权号，这个号是跟用户用来支付的银行卡绑定的，有效期是1分钟
	 * @param body
	 *            要支付的商品的描述信息，用户会在支付成功页面里看到这个信息
	 * @param attach
	 *            支付订单里面可以填的附加数据，API会将提交的这个附加数据原样返回
	 * @param outTradeNo
	 *            商户系统内部的订单号,32个字符内可包含字母, 确保在商户系统唯一
	 * @param totalFee
	 *            订单总金额，单位为“分”，只能整数
	 * @param deviceInfo
	 *            商户自己定义的扫码支付终端设备号，方便追溯这笔交易发生在哪台终端设备上
	 * @param spBillCreateIP
	 *            订单生成的机器IP
	 * @param timeStart
	 *            订单生成时间， 格式为yyyyMMddHHmmss，如2009年12 月25 日9 点10 分10
	 *            秒表示为20091225091010。时区为GMT+8 beijing。该时间取自商户服务器
	 * @param timeExpire
	 *            订单失效时间，格式同上
	 * @param goodsTag
	 *            商品标记，微信平台配置的商品标记，用于优惠券或者满减使用
	 */
	@SuppressWarnings("deprecation")
	public static String requestScanPay(String authCode, String body,
			String attach, String outTradeNo, int totalFee, String goodsTag) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date startDate = new Date();

		String timeStart = sdf.format(startDate);

		startDate.setMinutes(startDate.getMinutes() + 6);
		String timeExpire = sdf.format(startDate);

		ScanPayReqData scanPayReqData = new ScanPayReqData(authCode, body,
				attach, outTradeNo, totalFee, Configure.deviceInfo,
				Configure.spBillCreateIP, timeStart, timeExpire, goodsTag);
		try {
			return WXPay.requestScanPayService(scanPayReqData);
		} catch (Exception e) {
			throw new RuntimeException("微信支付出现异常！", e);
		}
	}

	/**
	 * 请求支付查询服务
	 * 
	 * @param transactionID
	 *            是微信系统为每一笔支付交易分配的订单号，通过这个订单号可以标识这笔交易，它由支付订单API支付成功时返回的数据里面获取到。
	 *            建议优先使用
	 * @param outTradeNo
	 *            商户系统内部的订单号,transaction_id 、out_trade_no
	 *            二选一，如果同时存在优先级：transaction_id>out_trade_no
	 * @return API返回的XML数据
	 * @throws Exception
	 */
	public static String requestScanPayQuery(String transactionID,
			String outTradeNo) {
		ScanPayQueryReqData scanPayQueryReqData = new ScanPayQueryReqData(
				transactionID, outTradeNo);
		try {
			return new ScanPayQueryService().request(scanPayQueryReqData);
		} catch (IllegalAccessException e) {
			throw new RuntimeException("请求支付查询服务出现异常", e);
		} catch (InstantiationException e) {
			throw new RuntimeException("请求支付查询服务出现异常", e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("请求支付查询服务出现异常", e);
		} catch (Exception e) {
			throw new RuntimeException("请求支付查询服务出现异常", e);
		}
	}

	/**
	 * 请求退款服务
	 * 
	 * @param transactionID
	 *            是微信系统为每一笔支付交易分配的订单号，通过这个订单号可以标识这笔交易，它由支付订单API支付成功时返回的数据里面获取到。
	 *            建议优先使用
	 * @param outTradeNo
	 *            商户系统内部的订单号,transaction_id 、out_trade_no
	 *            二选一，如果同时存在优先级：transaction_id>out_trade_no
	 * @param deviceInfo
	 *            微信支付分配的终端设备号，与下单一致
	 * @param outRefundNo
	 *            商户系统内部的退款单号，商户系统内部唯一，同一退款单号多次请求只退一笔
	 * @param totalFee
	 *            订单总金额，单位为分
	 * @param refundFee
	 *            退款总金额，单位为分,可以做部分退款
	 * @param opUserID
	 *            操作员帐号, 默认为商户号
	 * @param refundFeeType
	 *            货币类型，符合ISO 4217标准的三位字母代码，默认为CNY（人民币）
	 */
	public static String requestRefund(String outTradeNo, String outRefundNo,
			int totalFee, int refundFee) {
		String transactionID = null;
		RefundReqData refundReqData = new RefundReqData(transactionID,
				outTradeNo, Configure.deviceInfo, outRefundNo, totalFee,
				refundFee, Configure.getMchid(), "CNY");
		try {
			return new RefundService().request(refundReqData);
		} catch (IllegalAccessException e) {
			throw new RuntimeException("请求退款服务出现异常", e);
		} catch (InstantiationException e) {
			throw new RuntimeException("请求退款服务出现异常", e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("请求退款服务出现异常", e);
		} catch (Exception e) {
			throw new RuntimeException("请求退款服务出现异常", e);
		}
	}
}
