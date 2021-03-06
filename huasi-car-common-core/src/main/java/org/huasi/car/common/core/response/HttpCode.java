package org.huasi.car.common.core.response;

/**
 * @desc huasi 后台服务器状态吗
 * @author ganliang
 * @version 2016年8月9日 上午11:39:52
 */
public enum HttpCode {
	/**
	 * 请求成功
	 */
	OK(200, "success"),

	/**
	 * 短信验证码 手机号码不能为空
	 */
	SMS_IPHONE_NOT_NULL(2020, "sms iphone not null"),

	/**
	 * 短信验证码 手机号码格式不正确
	 */
	SMS_IPHONE_NUMBER_FORMAT_ERROR(2021, "sms iphone snumber format error"),

	/**
	 * 短信验证码 发送失败
	 */
	SMS_SEND_ERROR(2022, "sms send error"),

	/**
	 * 客户端令牌设置错误
	 */
	TOKEN_SETTING_ERROR(2030, "token setting error"),

	/**
	 * 客户端令牌设置错误
	 */
	TOKEN_NOT_SETTING(2031, "token not setting"),

	/**
	 * 登录时 用户手机号码不能为空
	 */
	LOGIN_IPHONE_NOT_NULL(2040, "login iphone not null"),

	/**
	 * 登录时 用户手机号码格式不正确
	 */
	LOGIN_IPHONE_NUMBER_FORMAT_ERROR(2041, "login iphone number format error"),

	/**
	 * 登录时验证码不能为空
	 */
	LOGIN_SMS_CODE_NOT_NULL(2042, "login sms code not null"),

	/**
	 * 登录时 短信验证码验证失败
	 */
	LOGIN_SMS_VALIDATE_ERROR(2043, "login sms validate error"),

	/**
	 * 登录时 短信验证码 不正确
	 */
	LOGIN_SMS_CODE_WRONG_NUMBER(2044, "login sms code wrong number"),

	/**
	 * 登录时 注册用户失败
	 */
	LOGIN_REGISTER_ERROR(2045, "login register error"),

	/**
	 * 绑定新手机时 输入的手机号码不能为空
	 */
	UPDATE_IPHONE_NOT_NULL(2050, "new iphone not null"),
	
	/**
	 * 绑定新手机时 用户手机号码格式不正确
	 */
	UPDATE_IPHONE_NUMBER_FORMAT_ERROR(2051, "new iphone number format error"),
	
	/**
	 * 绑定新手机时 验证码不能为空
	 */
	UPDATE_SMS_CODE_NOT_NULL(2052, "update sms code not null"),
	
	/**
	 * 绑定新手机时 短信验证码验证失败
	 */
	UPDATE_SMS_VALIDATE_ERROR(2053, "update sms validate error"),
	
	/**
	 * 登录时 短信验证码 不正确
	 */
	UPDATE_SMS_CODE_WRONG_NUMBER(2054, "update sms code wrong number"),
	
	/**
	 * 绑定新手机时 输入的手机号已经注册
	 */
	UPDATE_IPHONE_HAS_REGISTER(2055, "update iphone has register"),

	/**
	 * fastdfs 文件服务器上传图片失败
	 */
	FDFS_FILE_UPLOAD_ERROR(2060,"fastdfs file upload error"),
	
	/**
	 * 商铺已经被收藏过
	 */
	MERCHANT_HAS_COLLECTED(2070,"merchant has collected"),
	
     /**
	 * 参数设置错误
	 */
	PARAMETER_SETTING_ERROR(400,"paramter setting error"),
	
	/**
	 * 服务出现异常
	 */
	INTERNAL_SERVER_ERROR(500, "internal server error");
	
	private final Integer code;
	private final String msg;

	private HttpCode(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	/**
	 * Return the integer value of this status code.
	 */
	public Integer code() {
		return this.code;
	}

	public String msg() {
		return this.msg;
	}

	public String toString() {
		return this.code.toString();
	}
}
