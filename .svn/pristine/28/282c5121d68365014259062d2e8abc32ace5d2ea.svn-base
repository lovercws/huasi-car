package com.tencent.protocol.accessToken_protocol;

import com.tencent.common.Configure;

public class AccessTokenReqData {

	// 每个字段具体的意思请查看API文档
	private String appid = "";
	private String secret = "";
	private String code = "";
	private String grant_type = "authorization_code";

	public AccessTokenReqData(String code) {

		// 微信分配的公众号ID（开通公众号之后可以获取到）
		setAppid(Configure.getAppid());

		setCode(code);

		setSecret(Configure.secret);

		setGrant_type(grant_type);
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getGrant_type() {
		return grant_type;
	}

	public void setGrant_type(String grant_type) {
		this.grant_type = grant_type;
	}
}
