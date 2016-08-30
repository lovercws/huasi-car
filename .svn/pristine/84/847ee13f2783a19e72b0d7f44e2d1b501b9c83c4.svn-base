package org.huasi.car.controller.user;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.hausi.car.sms.exception.SMSException;
import org.hausi.car.sms.service.JPushSMSService;
import org.huasi.car.common.core.controller.BaseController;
import org.huasi.car.common.core.response.HttpCode;
import org.huasi.car.common.core.response.ResponseEntity;
import org.huasi.car.common.core.utils.PhoneNumberUtil;
import org.huasi.car.common.core.utils.UploadUtil;
import org.huasi.car.common.core.utils.ValidateUtils;
import org.huasi.car.fdfs.service.FDFSAttachmentService;
import org.huasi.car.system.entity.SysCity;
import org.huasi.car.system.service.SysCityService;
import org.huasi.car.user.entity.AppUser;
import org.huasi.car.user.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @desc 用户基本信息控制类 
 * @author ganliang
 * @version 2016年8月17日 上午9:45:32
 */
@Controller
@RequestMapping("/app/userinfo")
public class AppUserInfoController extends BaseController {

	@Autowired
	private JPushSMSService smsService;

	@Autowired
	private AppUserService userService;

	@Autowired
	private FDFSAttachmentService fdfsService;

	@Autowired
	private SysCityService cityService;

	/**
	 * 根据userId，获取用户信息
	 * @param userId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "/{userId}" }, method = RequestMethod.GET)
	public ResponseEntity getUserByUserId(@PathVariable String userId) {
		AppUser appUser = userService.getUserByUserId(userId);
		return new ResponseEntity(appUser);
	}

	/**
	 * 修改用户昵称
	 * @param userId
	 * @param userNickname
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "/{userId}/nickname" }, method = RequestMethod.POST)
	public ResponseEntity updateUserNickName(@PathVariable String userId, String userNickname) {
		boolean isUpdate = userService.updateUserNickName(userId, userNickname);
		return new ResponseEntity(isUpdate);
	}

	/**
	 * 绑定新手机号
	 * @param msgId 客户端调用SmsMessageController.send接口获取的msgId
	 * @param smsCode 用户输入的验证码
	 * @param userId
	 * @param userPhone
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "/{userId}/phone" }, method = RequestMethod.POST)
	public ResponseEntity updateUserPhone(@PathVariable String userId, String msgId, String smsCode, String userPhone) {
		// 检测手机号码是否为空
		if (userPhone == null || "".equals(userPhone)) {
			log.debug("新输入的手机号码不能为空");
			return new ResponseEntity(HttpCode.UPDATE_IPHONE_NOT_NULL, userPhone);
		}
		// 检测手机号码格式
		if (!PhoneNumberUtil.validate(userPhone)) {
			log.debug("手机号码格式不正确" + userPhone);
			return new ResponseEntity(HttpCode.UPDATE_IPHONE_NUMBER_FORMAT_ERROR, userPhone);
		}
		// 检测短信验证码是否为空
		if (smsCode == null || "".equals(smsCode)) {
			log.debug("验证码不能为空" + smsCode);
			return new ResponseEntity(HttpCode.UPDATE_SMS_CODE_NOT_NULL, userPhone);
		}

		ResponseEntity responseEntity = null;
		// 验证短信验证码
		try {
			boolean validateMessage = smsService.validateMessage(msgId, smsCode);
			if (validateMessage) {
				// 验证当前手机号码是否已经注册
				AppUser userExist = userService.getUserByIphone(userPhone);
				// 如果用户为空，则可以设置为新手机号
				if (userExist == null) {
					boolean isUpdate = userService.updateUserPhone(userId, userPhone);
					responseEntity = new ResponseEntity(isUpdate);
				}
				// 如果用户存在，则说明已经注册过，不可以设置为新手机号
				else {
					responseEntity = new ResponseEntity(HttpCode.UPDATE_IPHONE_HAS_REGISTER, userPhone);
				}
			} else {
				log.debug("验证短信验证码验证失败");
				responseEntity = new ResponseEntity(HttpCode.UPDATE_SMS_CODE_WRONG_NUMBER, userPhone);
			}
		} catch (SMSException e) {
			log.debug("验证短信验证码出现异常");
			responseEntity = new ResponseEntity(HttpCode.UPDATE_SMS_VALIDATE_ERROR, userPhone);
		}
		return responseEntity;
	}

	/**
	 * 修改（上传）用户头像
	 * @param request
	 * @param userId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "/{userId}/avator" }, method = RequestMethod.POST)
	public ResponseEntity uploadUserHeadImg(HttpServletRequest request, @PathVariable String userId) {
		// 获取所有上传文件的绝对路径（临时）
		ResponseEntity responseEntity=null;
		Map<String,Object> resultMap=new HashMap<String,Object>();
		try {
			List<String> imgs = UploadUtil.uploadImage(request);
			if (imgs == null || imgs.size() == 0||!ValidateUtils.isNumeric(userId)) {
				return new ResponseEntity(HttpCode.PARAMETER_SETTING_ERROR, userId);
			}
			File file = new File(imgs.get(0));
			// 上传到文件服务器，返回服务器路径
			String avatorUrl = fdfsService.upload(file);
			// 删除临时文件
			file.delete();
			// 更新用户头像
			userService.updateUserAvatorUrl(userId, avatorUrl);
			resultMap.put("userId", userId);
			resultMap.put("avatorUrl", avatorUrl);
			responseEntity=new ResponseEntity(resultMap);
		} catch (IOException e) {
			log.error(e.getLocalizedMessage());
			responseEntity=new ResponseEntity(HttpCode.FDFS_FILE_UPLOAD_ERROR, userId);
		}
		return responseEntity;
	}

	/**
	 * 获取用户数据库保存的城市信息
	 * @param userId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "/{userId}/city" }, method = RequestMethod.GET)
	public ResponseEntity getUserCity(@PathVariable String userId) {
		if (!ValidateUtils.isNumeric(userId)) {
			return new ResponseEntity(HttpCode.PARAMETER_SETTING_ERROR, userId);
		}
		SysCity city = cityService.getSysCityByUserId(userId);
		return new ResponseEntity(city);
	}

	/**
	 * 更新用户数据库保存的城市信息
	 * @param userId 用户id
	 * @param cName 城市名称
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "/{userId}/city/{cName}" }, method = RequestMethod.POST)
	public ResponseEntity updateUserCity(@PathVariable String userId, @PathVariable String cName) {
		if (!ValidateUtils.isNumeric(userId)) {
			return new ResponseEntity(HttpCode.PARAMETER_SETTING_ERROR, userId);
		}
		String cCode = userService.updateUserCityInfo(userId, cName);
		Map<String,Object> resultMap=new HashMap<>();
		resultMap.put("cCode", cCode);
		return new ResponseEntity(resultMap);
	}

}
