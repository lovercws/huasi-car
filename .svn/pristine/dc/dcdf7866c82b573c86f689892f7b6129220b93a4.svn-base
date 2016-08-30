package com.tencent.service;

import com.tencent.common.Configure;
import com.tencent.common.XMLParser;
import com.tencent.protocol.unifiedorder_protocol.UnifiedorderReqData;
import com.tencent.protocol.unifiedorder_protocol.UnifiedorderResData;

import net.sf.json.JSONObject;

public class UnifiedorderService extends BaseService {

	public UnifiedorderService() throws IllegalAccessException,
			InstantiationException, ClassNotFoundException {
		super(Configure.UNIFIEDORDER_API);
	}

	public UnifiedorderResData request(UnifiedorderReqData unifiedorderReqData)
			throws Exception {

		// --------------------------------------------------------------------
		// 发送HTTPS的Post请求到API地址
		// --------------------------------------------------------------------
		String responseString = sendPost(unifiedorderReqData);

		Object resData = XMLParser.getResDataFromXml(responseString,
				UnifiedorderResData.class);

		JSONObject fromObject = JSONObject.fromObject(resData);
		System.out.println(fromObject.toString());
		return (UnifiedorderResData) resData;
	}
}
