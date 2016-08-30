package org.huasi.car.payment.alipay.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradeCancelRequest;
import com.alipay.api.request.AlipayTradeCloseRequest;
import com.alipay.api.request.AlipayTradeCreateRequest;
import com.alipay.api.request.AlipayTradeFastpayRefundQueryRequest;
import com.alipay.api.request.AlipayTradeOrderSettleRequest;
import com.alipay.api.request.AlipayTradePayRequest;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.alipay.api.response.AlipayTradeCancelResponse;
import com.alipay.api.response.AlipayTradeCloseResponse;
import com.alipay.api.response.AlipayTradeCreateResponse;
import com.alipay.api.response.AlipayTradeFastpayRefundQueryResponse;
import com.alipay.api.response.AlipayTradeOrderSettleResponse;
import com.alipay.api.response.AlipayTradePayResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.alipay.config.AlipayConfig;
import com.alipay.request.AlipayTradeRSARequest;
import com.alipay.utils.MapConvertUtil;
import com.google.gson.Gson;

/**
 * @desc alipay支付接口 
 * @author ganliang
 * @version 2016年8月24日 下午4:00:54
 */
public class AlipayPayService {

	private static AlipayClient alipayClient=AlipayConfig.instance();
	
	private static final Gson gson=new Gson();
	
	/**
	 * 签名服务
	 * (支付宝app付款 需要服务端生成签名；返回到客户端；然后客户端使用服务端的签名向支付宝服务器发送支付请求；支付请求成功；
	 * 支付宝后台服务器会异步发送通知到商户后台；商户后台可以根据通知判断交易成功或者失败)
	 * @param body 商品描述
	 * @param subject 商品的标题/交易标题/订单标题/订单关键字等。
	 * @param out_trade_no 商户网站唯一订单号
	 * @param total_amount 单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]
	 * @return
	 */
	public String requestRSAService(String body, String subject, String out_trade_no, String total_amount){
		try {
			AlipayTradeRSARequest signReqData = new AlipayTradeRSARequest(body, subject, out_trade_no, total_amount);
			Map<String, String> params = MapConvertUtil.objectToMap(signReqData);
			
			//获取待签名的字符串
			String signContent = AlipaySignature.getSignContent(params);
			System.out.println("signContent  "+signContent);
			String sign = AlipaySignature.rsaSign(signContent,AlipayConfig.app_private_key,AlipayConfig.input_charset);
			signContent+="&sign="+sign;
			
			try {
				return URLEncoder.encode(signContent,AlipayConfig.input_charset);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 验证签名
	 * @param content 
	 * @param sign
	 * @return
	 */
	public boolean requestCheckRSAService(String content,String sign){
		try {
			boolean rsaCheckContent = AlipaySignature.rsaCheckContent(content, sign, AlipayConfig.alipay_public_key, AlipayConfig.input_charset);
			System.out.println(rsaCheckContent);
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void requestAppPayService(){
		AlipayTradeAppPayRequest request=new AlipayTradeAppPayRequest();
		try {
			AlipayTradeAppPayResponse payResponse = alipayClient.execute(request);
			String tradeNo = payResponse.getTradeNo();
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 支付宝交易查询
	 * @param out_trade_no
	 * @param trade_no
	 */
	public void requestQueryService(String out_trade_no, String trade_no) {
		AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();// 创建API对应的request类
		Map<String,String> biz_content=new HashMap<String,String>();
		biz_content.put("out_trade_no", out_trade_no);
		biz_content.put("trade_no", trade_no);
		request.setBizContent(gson.toJson(biz_content));
		try {
			AlipayTradeQueryResponse response = alipayClient.execute(request);
			String tradeStatus = response.getTradeStatus();

		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 单 用于交易创建后，用户在一定时间内未进行支付，可调用该接口直接将未付款的交易进行关闭。
	 * @param trade_no
	 * @param out_trade_no
	 * @param operator_id
	 * @throws AlipayApiException
	 */
	public void close(String trade_no, String out_trade_no, String operator_id) throws AlipayApiException {
		AlipayTradeCloseRequest request = new AlipayTradeCloseRequest();
		request.setBizContent("{\"trade_no\":\"2013112611001004680073956707\","
				+ "\"out_trade_no\":\"HZ0120131127001\"," + "\"operator_id\":\"YX01\"" + "}");
		AlipayTradeCloseResponse response = alipayClient.execute(request);
	}

	/**
	 * 退款接口
	 * @throws AlipayApiException 
	 */
	public void refund() throws AlipayApiException {
		AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
		request.setBizContent("{" + "    \"out_trade_no\":\"20150320010101001\","
				+ "    \"trade_no\":\"2014112611001004680073956707\"," + "    \"refund_amount\":200.12,"
				+ "    \"refund_reason\":\"正常退款\"," + "    \"out_request_no\":\"HZ01RF001\","
				+ "    \"operator_id\":\"OP001\"," + "    \"store_id\":\"NJ_S_001\","
				+ "    \"terminal_id\":\"NJ_T_001\"" + "  }");
		AlipayTradeRefundResponse response = alipayClient.execute(request);
	}

	/**
	 * 支付接口
	 * @throws AlipayApiException
	 */
	public void pay() throws AlipayApiException{
		AlipayTradePayRequest request = new AlipayTradePayRequest();
		request.setBizContent("{" +
		"    \"out_trade_no\":\"20150320010101001\"," +
		"    \"scene\":\"bar_code,wave_code\"," +
		"    \"auth_code\":\"28763443825664394\"," +
		"    \"subject\":\"Iphone6 16G\"," +
		"    \"seller_id\":\"2088102146225135\"," +
		"    \"total_amount\":88.88," +
		"    \"discountable_amount\":8.88," +
		"    \"undiscountable_amount\":80.00," +
		"    \"body\":\"Iphone6 16G\"," +
		"      \"goods_detail\":[{" +
		"                \"goods_id\":\"apple-01\"," +
		"        \"alipay_goods_id\":\"20010001\"," +
		"        \"goods_name\":\"ipad\"," +
		"        \"quantity\":1," +
		"        \"price\":2000," +
		"        \"goods_category\":\"34543238\"," +
		"        \"body\":\"特价手机\"," +
		"        \"show_url\":\"http://www.alipay.com/xxx.jpg\"" +
		"        }]," +
		"    \"operator_id\":\"yx_001\"," +
		"    \"store_id\":\"NJ_001\"," +
		"    \"terminal_id\":\"NJ_T_001\"," +
		"    \"alipay_store_id\":\"2016041400077000000003314986\"," +
		"    \"extend_params\":{" +
		"      \"sys_service_provider_id\":\"2088511833207846\"," +
		"      \"hb_fq_num\":\"3\"," +
		"      \"hb_fq_seller_percent\":\"100\"" +
		"    }," +
		"    \"timeout_express\":\"90m\"," +
		"    \"royalty_info\":{" +
		"      \"royalty_type\":\"ROYALTY\"," +
		"        \"royalty_detail_infos\":[{" +
		"                    \"serial_no\":1," +
		"          \"trans_in_type\":\"userId\"," +
		"          \"batch_no\":\"123\"," +
		"          \"out_relation_id\":\"20131124001\"," +
		"          \"trans_out_type\":\"userId\"," +
		"          \"trans_out\":\"2088101126765726\"," +
		"          \"trans_in\":\"2088101126708402\"," +
		"          \"amount\":0.1," +
		"          \"desc\":\"分账测试1\"," +
		"          \"amount_percentage\":\"100\"" +
		"          }]" +
		"    }," +
		"    \"sub_merchant\":{" +
		"      \"merchant_id\":\"19023454\"" +
		"    }" +
		"  }");
		AlipayTradePayResponse response = alipayClient.execute(request);
	}

	/**
	 * 收银员通过收银台或商户后台调用支付宝接口，生成二维码后，展示给用户，由用户扫描二维码完成订单支付。
	 * @throws AlipayApiException 
	 */
	public void precreate() throws AlipayApiException{
		AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
		request.setBizContent("{" +
		"    \"out_trade_no\":\"20150320010101001\"," +
		"    \"seller_id\":\"2088102146225135\"," +
		"    \"total_amount\":88.88," +
		"    \"discountable_amount\":8.88," +
		"    \"undiscountable_amount\":80," +
		"    \"buyer_logon_id\":\"15901825620\"," +
		"    \"subject\":\"Iphone6 16G\"," +
		"    \"body\":\"Iphone6 16G\"," +
		"      \"goods_detail\":[{" +
		"                \"goods_id\":\"apple-01\"," +
		"        \"alipay_goods_id\":\"20010001\"," +
		"        \"goods_name\":\"ipad\"," +
		"        \"quantity\":1," +
		"        \"price\":2000," +
		"        \"goods_category\":\"34543238\"," +
		"        \"body\":\"特价手机\"," +
		"        \"show_url\":\"http://www.alipay.com/xxx.jpg\"" +
		"        }]," +
		"    \"operator_id\":\"yx_001\"," +
		"    \"store_id\":\"NJ_001\"," +
		"    \"terminal_id\":\"NJ_T_001\"," +
		"    \"extend_params\":{" +
		"      \"sys_service_provider_id\":\"2088511833207846\"," +
		"      \"hb_fq_num\":\"3\"," +
		"      \"hb_fq_seller_percent\":\"100\"" +
		"    }," +
		"    \"timeout_express\":\"90m\"," +
		"    \"royalty_info\":{" +
		"      \"royalty_type\":\"ROYALTY\"," +
		"        \"royalty_detail_infos\":[{" +
		"                    \"serial_no\":1," +
		"          \"trans_in_type\":\"userId\"," +
		"          \"batch_no\":\"123\"," +
		"          \"out_relation_id\":\"20131124001\"," +
		"          \"trans_out_type\":\"userId\"," +
		"          \"trans_out\":\"2088101126765726\"," +
		"          \"trans_in\":\"2088101126708402\"," +
		"          \"amount\":0.1," +
		"          \"desc\":\"分账测试1\"," +
		"          \"amount_percentage\":\"100\"" +
		"          }]" +
		"    }," +
		"    \"sub_merchant\":{" +
		"      \"merchant_id\":\"19023454\"" +
		"    }," +
		"    \"alipay_store_id\":\"2016052600077000000015640104\"" +
		"  }");
		AlipayTradePrecreateResponse response = alipayClient.execute(request);
	}
	
	/**
	 * 支付交易返回失败或支付系统超时，调用该接口撤销交易。如果此订单用户支付失败，
	 * 支付宝系统会将此订单关闭；如果用户支付成功，支付宝系统会将此订单资金退还给用户。 
	 * 注意：只有发生支付系统超时或者支付结果未知时可调用撤销，其他正常支付的单如需实现相同功能请调用申请退款API。
	 * 提交支付交易后调用【查询订单API】，没有明确的支付结果再调用【撤销订单API】。
	 * @throws AlipayApiException
	 */
	public void cancel() throws AlipayApiException{
		AlipayTradeCancelRequest request = new AlipayTradeCancelRequest();
		request.setBizContent("{" +
		"    \"out_trade_no\":\"20150320010101001\"," +
		"    \"trade_no\":\"2014112611001004680073956707\"" +
		"  }");
		AlipayTradeCancelResponse response = alipayClient.execute(request);
	}
	
	/**
	 * 商户通过该接口进行交易的创建下单
	 * @throws AlipayApiException
	 */
	public void create() throws AlipayApiException{
		AlipayTradeCreateRequest request = new AlipayTradeCreateRequest();
		request.setBizContent("{" +
		"    \"out_trade_no\":\"20150320010101001\"," +
		"    \"seller_id\":\"2088102146225135\"," +
		"    \"total_amount\":88.88," +
		"    \"discountable_amount\":8.88," +
		"    \"undiscountable_amount\":80.00," +
		"    \"buyer_logon_id\":\"15901825620\"," +
		"    \"subject\":\"Iphone6 16G\"," +
		"    \"body\":\"Iphone6 16G\"," +
		"    \"buyer_id\":\"2088102146225135\"," +
		"      \"goods_detail\":[{" +
		"                \"goods_id\":\"apple-01\"," +
		"        \"alipay_goods_id\":\"20010001\"," +
		"        \"goods_name\":\"ipad\"," +
		"        \"quantity\":1," +
		"        \"price\":2000," +
		"        \"goods_category\":\"34543238\"," +
		"        \"body\":\"特价手机\"," +
		"        \"show_url\":\"http://www.alipay.com/xxx.jpg\"" +
		"        }]," +
		"    \"operator_id\":\"Yx_001\"," +
		"    \"store_id\":\"NJ_001\"," +
		"    \"terminal_id\":\"NJ_T_001\"," +
		"    \"extend_params\":{" +
		"      \"sys_service_provider_id\":\"2088511833207846\"," +
		"      \"hb_fq_num\":\"3\"," +
		"      \"hb_fq_seller_percent\":\"100\"" +
		"    }," +
		"    \"timeout_express\":\"90m\"," +
		"    \"royalty_info\":{" +
		"      \"royalty_type\":\"ROYALTY\"," +
		"        \"royalty_detail_infos\":[{" +
		"                    \"serial_no\":1," +
		"          \"trans_in_type\":\"userId\"," +
		"          \"batch_no\":\"123\"," +
		"          \"out_relation_id\":\"20131124001\"," +
		"          \"trans_out_type\":\"userId\"," +
		"          \"trans_out\":\"2088101126765726\"," +
		"          \"trans_in\":\"2088101126708402\"," +
		"          \"amount\":0.1," +
		"          \"desc\":\"分账测试1\"," +
		"          \"amount_percentage\":\"100\"" +
		"          }]" +
		"    }," +
		"    \"alipay_store_id\":\"2016041400077000000003314986\"," +
		"    \"sub_merchant\":{" +
		"      \"merchant_id\":\"19023454\"" +
		"    }" +
		"  }");
		AlipayTradeCreateResponse response = alipayClient.execute(request);
	}
	
	/**
	 * 商户可使用该接口查询自已通过alipay.trade.refund提交的退款请求是否执行成功。
	 * @throws AlipayApiException 
	 */
	public void refundQuery() throws AlipayApiException{
		AlipayTradeFastpayRefundQueryRequest request = new AlipayTradeFastpayRefundQueryRequest();
		request.setBizContent("{" +
		"    \"trade_no\":\"20150320010101001\"," +
		"    \"out_trade_no\":\"2014112611001004680073956707\"," +
		"    \"out_request_no\":\"2014112611001004680073956707\"" +
		"  }");
		AlipayTradeFastpayRefundQueryResponse response = alipayClient.execute(request);
	}
	
	/**
	 * 用于在线下场景交易支付后，进行结算
	 * @throws AlipayApiException 
	 */
	public void settle() throws AlipayApiException{
		AlipayTradeOrderSettleRequest request = new AlipayTradeOrderSettleRequest();
		request.setBizContent("{" +
		"    \"out_request_no\":\"20160727001\"," +
		"    \"trade_no\":\"2014030411001007850000672009\"," +
		"      \"royalty_parameters\":[{" +
		"                \"trans_out\":\"2088101126765726\"," +
		"        \"trans_in\":\"2088101126708402\"," +
		"        \"amount\":0.1," +
		"        \"amount_percentage\":100," +
		"        \"desc\":\"分账给2088101126708402\"" +
		"        }]," +
		"    \"operator_id\":\"A0001\"" +
		"  }");
		AlipayTradeOrderSettleResponse response = alipayClient.execute(request);
	}
}
