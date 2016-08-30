package com.tencent.service;

import com.tencent.common.Configure;
import com.tencent.common.JSONParse;
import com.tencent.protocol.refreshToken_protocol.RefreshTokenReqData;
import com.tencent.protocol.refreshToken_protocol.RefreshTokenResData;

/**
 * @desc 刷新access token 
 * @author ganliang
 * @version 2016年8月23日 上午11:08:57
 */
public class RefreshTokenService extends BaseService {

	public RefreshTokenService() throws IllegalAccessException,
			InstantiationException, ClassNotFoundException {
		super(Configure.UNIFIEDORDER_API);
	}

	public RefreshTokenResData request(RefreshTokenReqData refreshTokenReqData)
			throws Exception {

		// --------------------------------------------------------------------
		// 发送HTTPS的Get请求到API地址
		// --------------------------------------------------------------------
		String apiURL = Configure.REFRESH_TOKEN_URL + "?appid="
				+ refreshTokenReqData.getAppid() + "&grant_type="
				+ refreshTokenReqData.getGrant_type() + "&refresh_token="
				+ refreshTokenReqData.getRefresh_token();
		String responseString = sendGet(apiURL);

		Object resData = JSONParse.getResDataFromJSON(responseString,
				RefreshTokenResData.class);

		return (RefreshTokenResData) resData;
	}

}
