package com.alipay.request;

import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;

import com.alipay.config.AlipayConfig;

/**
 * @desc
 * @author ganliang
 * @version 2016年8月26日 上午10:29:18
 */
public class AlipayTradeRSARequest {

	// 公共参数
	private String app_id;// 支付宝分配给开发者的应用ID
	private String method = "alipay.trade.app.pay";// 接口名称
	private String format;// 仅支持JSON
	private String charset;// 请求使用的编码格式，如utf-8,gbk,gb2312等
	private String sign_type;// 商户生成签名字符串所使用的签名算法类型，目前支持RSA
	private String sign;// 商户请求参数的签名串，详见签名
	private String timestamp;// 发送请求的时间，格式"yyyy-MM-dd HH:mm:ss"
	private String version;// 调用的接口版本，固定为：1.0
	private String notify_url;// 支付宝服务器主动通知商户服务器里指定的页面http/https路径。建议商户使用https
	private BizContent biz_content;// 业务请求参数的集合，最大长度不限，除公共参数外所有请求参数都必须放在这个参数中传递，具体参照各产品快速接入文档

	public static class BizContent {
		// 业务参数
		private String body;// 对一笔交易的具体描述信息。如果是多种商品，请将商品描述字符串累加传给body。
		private String subject;// 商品的标题/交易标题/订单标题/订单关键字等。
		private String out_trade_no;// 商户网站唯一订单号
		private String timeout_express;// 该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。
										// 该参数数值不接受小数点， 如 1.5h，可转换为 90m。
		private String total_amount;// 订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]
		private String seller_id;// 收款支付宝用户ID。 如果该值为空，则默认为商户签约账号对应的支付宝用户ID
		private String product_code;// 销售产品码，商家和支付宝签约的产品码

		public BizContent(String body, String subject, String out_trade_no, String timeout_express, String total_amount,
				String seller_id, String product_code) {
			super();
			this.body = body;
			this.subject = subject;
			this.out_trade_no = out_trade_no;
			this.timeout_express = timeout_express;
			this.total_amount = total_amount;
			this.seller_id = seller_id;
			this.product_code = product_code;
		}

		public String getBody() {
			return body;
		}

		public void setBody(String body) {
			this.body = body;
		}

		public String getSubject() {
			return subject;
		}

		public void setSubject(String subject) {
			this.subject = subject;
		}

		public String getOut_trade_no() {
			return out_trade_no;
		}

		public void setOut_trade_no(String out_trade_no) {
			this.out_trade_no = out_trade_no;
		}

		public String getTimeout_express() {
			return timeout_express;
		}

		public void setTimeout_express(String timeout_express) {
			this.timeout_express = timeout_express;
		}

		public String getTotal_amount() {
			return total_amount;
		}

		public void setTotal_amount(String total_amount) {
			this.total_amount = total_amount;
		}

		public String getSeller_id() {
			return seller_id;
		}

		public void setSeller_id(String seller_id) {
			this.seller_id = seller_id;
		}

		public String getProduct_code() {
			return product_code;
		}

		public void setProduct_code(String product_code) {
			this.product_code = product_code;
		}
	}

	public AlipayTradeRSARequest(String body, String subject, String out_trade_no, String total_amount) {
		// 公共参数
		app_id = AlipayConfig.app_id;
		format = AlipayConfig.format;
		charset = AlipayConfig.input_charset;
		sign_type = AlipayConfig.sign_type;

		timestamp = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
		version = AlipayConfig.version;
		notify_url = AlipayConfig.notify_url;

		biz_content = new BizContent(body, subject, out_trade_no, AlipayConfig.it_b_pay, total_amount,
				AlipayConfig.seller_id, AlipayConfig.product_code);

	}

	public String getApp_id() {
		return app_id;
	}

	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getSign_type() {
		return sign_type;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public BizContent getBiz_content() {
		return biz_content;
	}

	public void setBiz_content(BizContent biz_content) {
		this.biz_content = biz_content;
	}
}
