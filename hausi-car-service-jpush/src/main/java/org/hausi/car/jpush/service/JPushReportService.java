package org.hausi.car.jpush.service;

import cn.jpush.api.JPushClient;

/**
 * 极光推送 送达统计、用户统计、消息统计
 * @author ganliang
 */
public class JPushReportService {
	//private static final Logger log = Logger.getLogger(JPushReportService.class);

	public JPushClient jPushClient;//极光推送客户端
	public void setjPushClient(JPushClient jPushClient) {
		this.jPushClient = jPushClient;
	}
	// ------------- 送达统计
	
}
