package org.huasi.car.common.core.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @desc 手机号码检测 
 * @author ganliang
 * @version 2016年8月9日 上午10:41:44
 */
public class PhoneNumberUtil {

	/**
	 * 检测手机号码是否规范
	 * @param mobile
	 * @return
	 */
	public static boolean validate(String mobile) {
		if (mobile == null) {
			return false;
		}
		if (mobile.length() != 11) {
			return false;
		}
		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
		Matcher m = p.matcher(mobile);
		if (!m.matches()) {
			return false;
		}
		return true;
	}
}
