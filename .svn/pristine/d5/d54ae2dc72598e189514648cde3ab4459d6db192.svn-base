package com.tencent.service;

import com.tencent.common.Configure;
import com.tencent.common.JSONParse;
import com.tencent.protocol.auth_protocol.AuthReqData;
import com.tencent.protocol.auth_protocol.AuthResData;

/**
 * @desc 检验授权凭证 
 * @author ganliang
 * @version 2016年8月23日 上午11:08:01
 */
public class AuthService extends BaseService {

	public AuthService() throws ClassNotFoundException, IllegalAccessException,
			InstantiationException {
		super("");
	}

	public AuthResData request(AuthReqData authReqData) throws Exception {

		// --------------------------------------------------------------------
		// 发送HTTPS的Get请求到API地址
		// --------------------------------------------------------------------
		String apiURL = Configure.AUTH_URL + "?access_token="
				+ authReqData.getAccess_token() + "&openid="
				+ authReqData.getOpenid();
		String responseString = sendGet(apiURL);

		Object authResData = JSONParse.getResDataFromJSON(responseString,
				AuthResData.class);

		return (AuthResData) authResData;
	}
}
