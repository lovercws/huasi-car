package org.huasi.car.controller.system;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.hausi.car.sms.exception.SMSException;
import org.hausi.car.sms.service.JPushSMSService;
import org.huasi.car.common.core.controller.BaseController;
import org.huasi.car.common.core.response.HttpCode;
import org.huasi.car.common.core.response.ResponseEntity;
import org.huasi.car.common.core.utils.PhoneNumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/system/sms")
public class SmsMessageController extends BaseController {

	@Autowired
	private JPushSMSService smsService;

	/**
	 * 获取短信验证码
	 * @param userPhone 用户手机号码
	 * @param response
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = { "/send" }, method = RequestMethod.POST)
	public ResponseEntity send(String userPhone) {
		log.info("发送短信验证码 " + userPhone);
		ResponseEntity responseBody =null;
		try {
			// 用户手机号码未设置
			if (userPhone == null) {
				log.info("用户手机号码不能为空");
				responseBody=new ResponseEntity(HttpCode.SMS_IPHONE_NOT_NULL,userPhone);
			}
			// 手机号码格式不正确
			else if (!PhoneNumberUtil.validate(userPhone)) {
				log.info("用户手机号码格式不正确");
				responseBody= new ResponseEntity(HttpCode.SMS_IPHONE_NUMBER_FORMAT_ERROR,userPhone);
			} else {
				String msgId = smsService.sendSMS(userPhone);
				Map<String, String> map = new HashMap<String, String>();
				map.put("msgId", msgId);
				responseBody= new ResponseEntity(HttpCode.OK,map);
			}
		} catch (SMSException e) {
			log.error(e);
			responseBody= new ResponseEntity(HttpCode.SMS_SEND_ERROR,e.getLocalizedMessage());
		}
		return responseBody;
	}
}
