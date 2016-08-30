package com.tencent.service;

import com.tencent.common.Configure;
import com.tencent.common.JSONParse;
import com.tencent.protocol.accessToken_protocol.AccessTokenReqData;
import com.tencent.protocol.accessToken_protocol.AccessTokenResData;

/**
 * @desc 获取access_token 
 * @author ganliang
 * @version 2016年8月23日 上午11:08:10
 */
public class AccessTokenService extends BaseService {

	public AccessTokenService() throws IllegalAccessException,
			InstantiationException, ClassNotFoundException {
		super(Configure.UNIFIEDORDER_API);
	}

	public AccessTokenResData request(AccessTokenReqData accessTokenReqData)
			throws Exception {

		// --------------------------------------------------------------------
		// 发送HTTPS的Get请求到API地址
		// --------------------------------------------------------------------
		String apiURL = Configure.ACCESS_TOKEN_URL + "?appid="
				+ accessTokenReqData.getAppid() + "&secret="
				+ accessTokenReqData.getSecret() + "&code="
				+ accessTokenReqData.getCode() + "&grant_type="
				+ accessTokenReqData.getGrant_type();
		String responseString = sendGet(apiURL);

		Object resData = JSONParse.getResDataFromJSON(responseString,
				AccessTokenResData.class);

		return (AccessTokenResData) resData;
	}

}
