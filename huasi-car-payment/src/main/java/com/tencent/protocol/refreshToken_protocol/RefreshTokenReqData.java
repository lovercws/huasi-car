package com.tencent.protocol.refreshToken_protocol;

import com.tencent.common.Configure;

public class RefreshTokenReqData {

	private String appid;
	private String grant_type = "refresh_token";
	private String refresh_token;

	public RefreshTokenReqData(String refresh_token) {

		// 微信支付分配的商户号ID（开通公众号的微信支付功能之后可以获取到）
		setAppid(Configure.getAppid());

		setGrant_type(getGrant_type());

		setRefresh_token(refresh_token);
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getGrant_type() {
		return grant_type;
	}

	public void setGrant_type(String grant_type) {
		this.grant_type = grant_type;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

}
