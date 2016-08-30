package com.tencent.protocol.auth_protocol;

public class AuthReqData {

	private String access_token;
	private String openid;

	public AuthReqData(String access_token, String openid) {

		// 微信分配的公众号ID（开通公众号之后可以获取到）
		setOpenid(openid);

		// 微信支付分配的商户号ID（开通公众号的微信支付功能之后可以获取到）
		setAccess_token(access_token);
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

}
