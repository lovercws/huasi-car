package org.huasi.car.controller.user;

import org.hausi.car.sms.exception.SMSException;
import org.hausi.car.sms.service.JPushSMSService;
import org.huasi.car.common.core.controller.BaseController;
import org.huasi.car.common.core.response.HttpCode;
import org.huasi.car.common.core.response.ResponseEntity;
import org.huasi.car.common.core.utils.PhoneNumberUtil;
import org.huasi.car.user.entity.AppUser;
import org.huasi.car.user.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/app/user")
public class AppUserLoginController extends BaseController {

	@Autowired
	private JPushSMSService smsService;
	
	@Autowired
	private AppUserService userService;

	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public ResponseEntity login(AppUser user) {
		log.debug("用户登录 " + user);
		String userPhone = user.getUserPhone();
		String smsCode = user.getSmsCode();
		// 手机号码 为空检测
		if (userPhone == null || "".equals(userPhone)) {
			log.debug("用户手机号码不能为空");
			return new ResponseEntity(HttpCode.LOGIN_IPHONE_NOT_NULL,userPhone);
		}
		// 手机号码格式检测
		if (!PhoneNumberUtil.validate(userPhone)) {
			log.debug("手机号码格式不正确" + userPhone);
			return new ResponseEntity(HttpCode.LOGIN_IPHONE_NUMBER_FORMAT_ERROR,userPhone);
		}
		// 短信验证码为空检测
		if (smsCode == null || "".equals(smsCode)) {
			log.debug("验证码不能为空" + smsCode);
			return new ResponseEntity(HttpCode.LOGIN_SMS_CODE_NOT_NULL,smsCode);
		}

		ResponseEntity responseBody = null;
		// 验证短信验证码
		try {
			boolean validateMessage = smsService.validateMessage(user.getSmsMsgId(), smsCode);
			if (validateMessage) {
				// 验证当前手机号码是已经注册
				AppUser userExist = userService.getUserByIphone(userPhone);
				// 用户为空 则注册用户
				if (userExist == null) {
					responseBody = register(user);
				}
				// 用户存在 则登录用户
				else {
					responseBody = new ResponseEntity(userExist);
				}
			} else {
				log.debug("验证短信验证码验证失败");
				responseBody = new ResponseEntity(HttpCode.LOGIN_SMS_CODE_WRONG_NUMBER,smsCode);
			}
		} catch (SMSException e) {
			log.debug("验证短信验证码出现异常");
			responseBody = new ResponseEntity(HttpCode.LOGIN_SMS_VALIDATE_ERROR,smsCode);
		}
		return responseBody;
	}

	/**
	 * 注册用户
	 * @param user
	 * @param response
	 */
	@ResponseBody
	@RequestMapping(value = { "/register" }, method = {RequestMethod.POST,RequestMethod.GET})
	public ResponseEntity register(AppUser user) {
		
		user.setUserPassword("123456");
		user.setUserName("测试用户");

		ResponseEntity responseBody = null;
		AppUser addUser = userService.addUser(user);
		if (addUser!=null) {
			responseBody = new ResponseEntity(user);
		} else {
			responseBody = new ResponseEntity(HttpCode.LOGIN_REGISTER_ERROR, user);
		}
		return responseBody;
	}
}
