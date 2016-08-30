package org.huasi.car.user.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @desc app用户实体 
 * @author ganliang
 * @version 2016年8月10日 下午3:45:24
 */
public class AppUser implements Serializable {

	private static final long serialVersionUID = -5979918664476543047L;

	private Integer userId;// 用户主键
	private String userName;// 用户名称
	private String userPhone;// 手机号

	private Byte phoneActive;// 0未激活；1激活
	private String userNickname;// 昵称
	private String avatorUrl;// 头像地址（缩略图）

	private String userEmail;// 邮箱
	private Byte emailActive;// 邮箱验证有效
	private String userPassword;// 密码

	private String userDesc;// 用户个人描述
	private Date createTime;// 创建时间
	private String createIp;// 创建ip

	private Date lastLoginTime;// 最后登录时间
	private String lastLoginIp;// 最后登录ip
	private Integer loginCount;// 登录计数

	private Byte userSex;// 0未知；1 男；2 女
	private Date userBirthday;// 生日
	private String userDetailArea;// 用户详细地址

	private String userProvince;// 省
	private String userCity;// 市
	private String userArea;// 区

	private Byte userStatus;// 状态(1正常;2禁止登陆;3删除 )
	private Byte userRegType;// 用户注册类别（1 手机号注册； 2 微信注册 ；3 qq注册）
	private String userToken;// 用户令牌（登陆的时候，可以凭借令牌登陆）

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone == null ? null : userPhone.trim();
	}

	public Byte getPhoneActive() {
		return phoneActive;
	}

	public void setPhoneActive(Byte phoneActive) {
		this.phoneActive = phoneActive;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname == null ? null : userNickname.trim();
	}

	public String getAvatorUrl() {
		return avatorUrl;
	}

	public void setAvatorUrl(String avatorUrl) {
		this.avatorUrl = avatorUrl == null ? null : avatorUrl.trim();
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail == null ? null : userEmail.trim();
	}

	public Byte getEmailActive() {
		return emailActive;
	}

	public void setEmailActive(Byte emailActive) {
		this.emailActive = emailActive;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword == null ? null : userPassword.trim();
	}

	public String getUserDesc() {
		return userDesc;
	}

	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc == null ? null : userDesc.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateIp() {
		return createIp;
	}

	public void setCreateIp(String createIp) {
		this.createIp = createIp == null ? null : createIp.trim();
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
	}

	public Integer getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	public Byte getUserSex() {
		return userSex;
	}

	public void setUserSex(Byte userSex) {
		this.userSex = userSex;
	}

	public Date getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}

	public String getUserDetailArea() {
		return userDetailArea;
	}

	public void setUserDetailArea(String userDetailArea) {
		this.userDetailArea = userDetailArea == null ? null : userDetailArea.trim();
	}

	public String getUserProvince() {
		return userProvince;
	}

	public void setUserProvince(String userProvince) {
		this.userProvince = userProvince == null ? null : userProvince.trim();
	}

	public String getUserCity() {
		return userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity == null ? null : userCity.trim();
	}

	public String getUserArea() {
		return userArea;
	}

	public void setUserArea(String userArea) {
		this.userArea = userArea == null ? null : userArea.trim();
	}

	public Byte getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Byte userStatus) {
		this.userStatus = userStatus;
	}

	public Byte getUserRegType() {
		return userRegType;
	}

	public void setUserRegType(Byte userRegType) {
		this.userRegType = userRegType;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken == null ? null : userToken.trim();
	}

	// 非持久化数据
	private String smsMsgId;// sms msgId
	private String smsCode;// sms 验证码

	public String getSmsMsgId() {
		return smsMsgId;
	}

	public void setSmsMsgId(String smsMsgId) {
		this.smsMsgId = smsMsgId;
	}

	public String getSmsCode() {
		return smsCode;
	}

	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}
}