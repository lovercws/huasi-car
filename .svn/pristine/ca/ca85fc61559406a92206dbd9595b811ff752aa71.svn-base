package org.huasi.car.controller.order;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.huasi.car.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tencent.common.XMLParser;
import com.tencent.protocol.paycall_protocol.PayCallResData;

/**
 * @desc 支付回调
 * @author ganliang
 * @version 2016年8月24日 上午8:29:48
 */
@Controller
@RequestMapping("/mer/paycall")
public class PayCallController {

	private static final Logger log = Logger.getLogger(PayCallController.class);

	private static final String WXPAY_ERROR_MSG = "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[支付出现错误]]></return_msg></xml>";
	private static final String WXPAY_SUCCESS_MSG = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
	
	@Autowired
	private OrderService orderService;

	@ResponseBody
	@RequestMapping(value = { "/wx" }, method = {RequestMethod.POST,RequestMethod.GET})
	public String wxpay(HttpServletRequest request) {
		String response = WXPAY_ERROR_MSG;
		String readline = null;
		StringBuilder xml = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
			while ((readline = in.readLine()) != null) {
				xml.append(readline);
			}
			log.info("微信回调【" + xml + "】");
			PayCallResData payCallResData = (PayCallResData) XMLParser.getResDataFromXml(xml.toString(),PayCallResData.class);
			// 微信回调
			boolean success = orderService.wxAppPayCall(payCallResData.getReturn_code(), payCallResData.getResult_code(),
					payCallResData.getReturn_msg(), payCallResData.getOut_trade_no(),
					payCallResData.getTransaction_id());

			if (payCallResData.getReturn_code().equals("SUCCESS") && payCallResData.getResult_code().equals("SUCCESS")
					&& success) {
				log.info("微信支付成功----->>>>");
				response = WXPAY_SUCCESS_MSG;
			}
		} catch (Exception e) {
			log.error(e);
		}
		return response;
	}
}
