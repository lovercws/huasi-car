package org.huasi.car.payment.wxpay.service;

import org.huasi.car.payment.wxpay.exception.WXPayException;

import com.tencent.common.Configure;
import com.tencent.common.XMLParser;
import com.tencent.protocol.accessToken_protocol.AccessTokenReqData;
import com.tencent.protocol.accessToken_protocol.AccessTokenResData;
import com.tencent.protocol.auth_protocol.AuthReqData;
import com.tencent.protocol.auth_protocol.AuthResData;
import com.tencent.protocol.closeorder_protocol.CloseOrderReqData;
import com.tencent.protocol.closeorder_protocol.CloseOrderResData;
import com.tencent.protocol.downloadbill_protocol.DownloadBillReqData;
import com.tencent.protocol.pay_protocol.ScanPayReqData;
import com.tencent.protocol.pay_query_protocol.ScanPayQueryReqData;
import com.tencent.protocol.pay_query_protocol.ScanPayQueryResData;
import com.tencent.protocol.paycall_protocol.PayCallReqData;
import com.tencent.protocol.paycall_protocol.PayCallResData;
import com.tencent.protocol.refreshToken_protocol.RefreshTokenReqData;
import com.tencent.protocol.refreshToken_protocol.RefreshTokenResData;
import com.tencent.protocol.refund_protocol.RefundReqData;
import com.tencent.protocol.refund_protocol.RefundResData;
import com.tencent.protocol.refund_query_protocol.RefundQueryReqData;
import com.tencent.protocol.refund_query_protocol.RefundQueryResData;
import com.tencent.protocol.reverse_protocol.ReverseReqData;
import com.tencent.protocol.unifiedorder_protocol.UnifiedorderReqData;
import com.tencent.protocol.unifiedorder_protocol.UnifiedorderResData;
import com.tencent.protocol.userinfo_protocol.UserInfoReqData;
import com.tencent.protocol.userinfo_protocol.UserInfoResData;
import com.tencent.service.AccessTokenService;
import com.tencent.service.AuthService;
import com.tencent.service.CloseOrderService;
import com.tencent.service.DownloadBillService;
import com.tencent.service.PayCallService;
import com.tencent.service.RefreshTokenService;
import com.tencent.service.RefundQueryService;
import com.tencent.service.RefundService;
import com.tencent.service.ReverseService;
import com.tencent.service.ScanPayQueryService;
import com.tencent.service.ScanPayService;
import com.tencent.service.UnifiedorderService;
import com.tencent.service.UserInfoService;

public class WXPayService {

	/**
	 * 统一下单统一下单 ;除被扫支付场景以外，
	 * 商户系统先调用该接口在微信支付服务后台生成预支付交易单，
	 * 返回正确的预支付交易回话标识后再按扫码、JSAPI、APP等不同场景生成交易串调起支付
	 * @param body 商品描述
	 * @param out_trade_no 商户订单号
	 * @param total_fee 总金额
	 * @param attach 附加数据
	 * @param spbill_create_ip 终端IP
	 * @return
	 * @throws WXPayException 
	 */
	public UnifiedorderResData requestUnifiedorder(String body, String out_trade_no, int total_fee,
			String attach, String spbill_create_ip) throws WXPayException {

		UnifiedorderReqData unifiedorderReqData = new UnifiedorderReqData(body, out_trade_no, total_fee, attach,
				spbill_create_ip);
		try {
			return new UnifiedorderService().request(unifiedorderReqData);
		} catch (Exception e) {
			throw new WXPayException("请求统一下单服务出现异常", e);
		}
	}

	
	/**
	 * 请求扫描支付服务
	 * @param authCode 这个是扫码终端设备从用户手机上扫取到的支付授权号，这个号是跟用户用来支付的银行卡绑定的，有效期是1分钟
	 * @param body 要支付的商品的描述信息，用户会在支付成功页面里看到这个信息
	 * @param attach 支付订单里面可以填的附加数据，API会将提交的这个附加数据原样返回
	 * @param outTradeNo 商户系统内部的订单号,32个字符内可包含字母, 确保在商户系统唯一
	 * @param totalFee 订单总金额，单位为“分”，只能整数
	 * @param deviceInfo 商户自己定义的扫码支付终端设备号，方便追溯这笔交易发生在哪台终端设备上
	 * @param spBillCreateIP 订单生成的机器IP
	 * @param timeStart 订单生成时间， 格式为yyyyMMddHHmmss，如2009年12 月25 日9 点10 分10
	 *            	            秒表示为20091225091010。时区为GMT+8 beijing。该时间取自商户服务器
	 * @param timeExpire 订单失效时间，格式同上
	 * @param goodsTag 商品标记，微信平台配置的商品标记，用于优惠券或者满减使用
	 * @throws WXPayException 
	 */
	public String requestScanPayService(String authCode, String body, String attach, String outTradeNo,
			int totalFee, String deviceInfo, String spBillCreateIP, String timeStart, String timeExpire,
			String goodsTag) throws WXPayException{
		// 生成扫描支付实体类
		ScanPayReqData scPayReqData = new ScanPayReqData(authCode, body, attach, outTradeNo, totalFee, deviceInfo,
				spBillCreateIP, timeStart, timeExpire, goodsTag);
		try {
			return new ScanPayService().request(scPayReqData);
		} catch (Exception e) {
			throw new WXPayException("请求支付requestScanPayService服务出现异常", e);
		}
	}

	/**
	 * 请求支付查询服务
	 * @param transactionID 是微信系统为每一笔支付交易分配的订单号，通过这个订单号可以标识这笔交易，它由支付订单API支付成功时返回的数据里面获取到。建议优先使用
	 * @param outTradeNo 商户系统内部的订单号,transaction_id 、out_trade_no
	 *                   二选一，如果同时存在优先级：transaction_id>out_trade_no
	 * @return API返回的XML数据
	 * @throws WXPayException 
	 * @throws Exception
	 */
	public ScanPayQueryResData requestScanPayQueryService(String transactionID, String outTradeNo) throws WXPayException{
		// 生成扫描支付查询实体类
		ScanPayQueryReqData scPayQueryReqData = new ScanPayQueryReqData(transactionID, outTradeNo);
		try {
			String request = new ScanPayQueryService().request(scPayQueryReqData);
			//将xml字符串转化为json
			ScanPayQueryResData scanPayQueryResData = (ScanPayQueryResData)XMLParser.getResDataFromXml(request, ScanPayQueryResData.class);
			return scanPayQueryResData;
		} catch (Exception e) {
			throw new WXPayException("请求支付查询requestScanPayQueryService服务出现异常", e);
		} 
	}

	/**
	 * 取消订单
	 * @param out_trade_no 商户订单号
	 * @return
	 * @throws WXPayException 
	 */
	public CloseOrderResData requestCloseOrderService(String out_trade_no) throws WXPayException{
		CloseOrderReqData orderReqData=new CloseOrderReqData(out_trade_no);
		try {
			return new CloseOrderService().request(orderReqData);
		}catch (Exception e) {
			throw new WXPayException("请求关闭订单requestCloseOrderService服务出现异常", e);
		} 
	}
	
	/**
     * 请求撤销服务
     * @param transactionID 是微信系统为每一笔支付交易分配的订单号，通过这个订单号可以标识这笔交易，它由支付订单API支付成功时返回的数据里面获取到。建议优先使用
     * @param outTradeNo 商户系统内部的订单号,transaction_id 、out_trade_no 二选一，如果同时存在优先级：transaction_id>out_trade_no
     * @return API返回的XML数据
	 * @throws WXPayException 
     * @throws Exception
     */
	public String requestReverseService(String transactionID,String outTradeNo) throws WXPayException{
		ReverseReqData reverseReqData=new ReverseReqData(transactionID, outTradeNo);
		try {
			return new ReverseService().request(reverseReqData);
		} catch (Exception e) {
			throw new WXPayException("请求撤销requestReverseService服务出现异常", e);
		}
	}
	
	/**
     * 请求退款服务 当交易发生之后一段时间内，由于买家或者卖家的原因需要退款时，卖家可以通过退款接口将支付款退还给买家，微信支付将在收到退款请求并且验证成功之后，按照退款规则将支付款按原路退到买家帐号上
     * @param transactionID 是微信系统为每一笔支付交易分配的订单号，通过这个订单号可以标识这笔交易，它由支付订单API支付成功时返回的数据里面获取到。建议优先使用
     * @param outTradeNo 商户系统内部的订单号,transaction_id 、out_trade_no 二选一，如果同时存在优先级：transaction_id>out_trade_no
     * @param deviceInfo 微信支付分配的终端设备号，与下单一致
     * @param outRefundNo 商户系统内部的退款单号，商户系统内部唯一，同一退款单号多次请求只退一笔
     * @param totalFee 订单总金额，单位为分
     * @param refundFee 退款总金额，单位为分,可以做部分退款
	 * @throws WXPayException 
     */
	public RefundResData requestRefundService(String transactionID,String outTradeNo,String deviceInfo,String outRefundNo,int totalFee,int refundFee) throws WXPayException{
		RefundReqData refundReqData = new RefundReqData(transactionID, outTradeNo, deviceInfo, outRefundNo, totalFee,
				refundFee, Configure.getMchid(), "CNY");
		try {
			String request = new RefundService().request(refundReqData);
			RefundResData refundResData=(RefundResData)XMLParser.getResDataFromXml(request, RefundResData.class); 
			return refundResData;
		} catch (Exception e) {
			throw new WXPayException("请求退款requestRefundService服务出现异常", e);
		}
	}
	
	/**
     * 请求退款查询服务 提交退款申请后，通过调用该接口查询退款状态。退款有一定延时，用零钱支付的退款20分钟内到账，银行卡支付的退款3个工作日后重新查询退款状态
     * @param transactionID 是微信系统为每一笔支付交易分配的订单号，通过这个订单号可以标识这笔交易，它由支付订单API支付成功时返回的数据里面获取到。建议优先使用
     * @param outTradeNo 商户系统内部的订单号,transaction_id 、out_trade_no 二选一，如果同时存在优先级：transaction_id>out_trade_no
     * @param deviceInfo 微信支付分配的终端设备号，与下单一致
     * @param outRefundNo 商户系统内部的退款单号，商户系统内部唯一，同一退款单号多次请求只退一笔
     * @param refundID 来自退款API的成功返回，微信退款单号refund_id、out_refund_no、out_trade_no 、transaction_id 四个参数必填一个，如果同事存在优先级为：refund_id>out_refund_no>transaction_id>out_trade_no
	 * @throws WXPayException 
     */
	public RefundQueryResData requestRefundQueryService(String transactionID,String outTradeNo,String deviceInfo,String outRefundNo,String refundID) throws WXPayException{
		RefundQueryReqData refundQueryReqData=new RefundQueryReqData(transactionID, outTradeNo, deviceInfo, outRefundNo, refundID);
		try {
			String request = new RefundQueryService().request(refundQueryReqData);
			RefundQueryResData refundQueryResData=(RefundQueryResData)XMLParser.getResDataFromXml(request, RefundQueryResData.class); 
			return refundQueryResData;
		} catch (Exception e) {
			throw new WXPayException("请求退款查询requestRefundQueryService服务出现异常", e);
		}
	}
	
	/**
	 * @Title: requestPayCall
	 * @Description: 将回调返回的xml解析成实体对象
	 * @param @param xml
	 * @param @return
	 * @return PayCallResData 返回类型
	 * @throws
	 */
	public PayCallResData requestPayCallResData(String xml) {
		try {
			return new PayCallService().requestPayCallResData(xml);
		} catch (Exception e) {
			throw new RuntimeException("封装微信回调实体出现异常", e);
		}
	}

	/**
	 * @Title: requestPayCallReqData
	 * @Description: 微信支付确定回调返回的数据
	 * @param @param payCallReqData
	 * @param @return
	 * @return String 返回类型
	 * @throws
	 */
	public String requestPayCallReqData(PayCallReqData payCallReqData) {
		try {
			return new PayCallService().requestPayCallReqData(payCallReqData);
		} catch (Exception e) {
			throw new RuntimeException("返回回调出现异常", e);
		}
	}
	
	/**
     * 请求对账单下载服务商户可以通过该接口下载历史交易清单。比如掉单、系统错误等导致商户侧和微信侧数据不一致，通过对账单核对后可校正支付状态。 注意：
     * 1、微信侧未成功下单的交易不会出现在对账单中。支付成功后撤销的交易会出现在对账单中，跟原支付单订单号一致，bill_type为REVOKED；
     * 2、微信在次日9点启动生成前一天的对账单，建议商户10点后再获取； 3、对账单中涉及金额的字段单位为“元”。
     * 4、对账单接口只能下载三个月以内的账单。
     * @param deviceInfo 商户自己定义的扫码支付终端设备号，方便追溯这笔交易发生在哪台终端设备上
     * @param billDate 下载对账单的日期，格式：yyyyMMdd 例如：20140603
     * @param billType 账单类型
     *                 ALL，返回当日所有订单信息，默认值
     *				   SUCCESS，返回当日成功支付的订单
     *	               REFUND，返回当日退款订单
     *	               REVOKED，已撤销的订单
	 * @throws WXPayException 
     */
	public String requestDownloadBillService(String deviceInfo,String billDate,String billType) throws WXPayException{
		DownloadBillReqData downloadBillReqData=new DownloadBillReqData(deviceInfo, billDate, billType);
		try {
			return new DownloadBillService().request(downloadBillReqData);
		} catch (Exception e) {
			throw new WXPayException("请求对账单requestDownloadBillService服务出现异常", e);
		}
	}
	
	/**
	 * 通过code获取access_token的接口 
	 * @param code
	 * @return
	 * @throws WXPayException 
	 */
	public AccessTokenResData requestAccessToken(String code) throws WXPayException {
		AccessTokenReqData accessTokenReqData = new AccessTokenReqData(code);
		try {
			return new AccessTokenService().request(accessTokenReqData);
		} catch (Exception e) {
			throw new WXPayException("请求access_token服务出现异常", e);
		}
	}

	/**
	 * 刷新access token
	 * @param refresh_token
	 * @return
	 * @throws WXPayException 
	 */
	public RefreshTokenResData requestRefreshToken(String refresh_token) throws WXPayException {
		RefreshTokenReqData refreshTokenReqData = new RefreshTokenReqData(refresh_token);
		try {
			return new RefreshTokenService().request(refreshTokenReqData);
		} catch (Exception e) {
			throw new WXPayException("请求Refresh_token服务出现异常", e);
		}
	}

	/**
	 * 检验授权凭证（access_token）是否有效
	 * @param access_token
	 * @param openid
	 * @return
	 * @throws WXPayException 
	 */
	public AuthResData requestAuthAccessToken(String access_token, String openid) throws WXPayException {
		AuthReqData authReqData = new AuthReqData(access_token, openid);
		try {
			return new AuthService().request(authReqData);
		} catch (Exception e) {
			throw new WXPayException("请求检验授权凭证服务出现异常", e);
		}
	}
	
	/**
	 * @Title: requestUserInfo
	 * @Description: 
	 *               此接口用于获取用户个人信息。开发者可通过OpenID来获取用户基本信息。特别需要注意的是，如果开发者拥有多个移动应用、网站应用和公众帐号
	 *               ，可通过获取用户基本信息中的unionid来区分用户的唯一性，因为只要是同一个微信开放平台帐号下的移动应用、
	 *               网站应用和公众帐号
	 *               ，用户的unionid是唯一的。换句话说，同一用户，对同一个微信开放平台下的不同应用，unionid是相同的。
	 * @param @param access_token
	 * @param @return
	 * @return UserInfoResData 返回类型
	 * @throws
	 */
	public UserInfoResData requestUserInfo(String access_token,
			String openid) throws WXPayException {
		UserInfoReqData userInfoReqData = new UserInfoReqData(access_token,
				openid);
		try {
			return new UserInfoService().request(userInfoReqData);
		} catch (Exception e) {
			throw new WXPayException("请求微信用户信息服务出现异常", e);
		}
	}
	
}
