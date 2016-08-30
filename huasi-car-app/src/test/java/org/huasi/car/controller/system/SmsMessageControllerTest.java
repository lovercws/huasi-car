package org.huasi.car.controller.system;

import java.util.HashMap;
import java.util.Map;

import org.huasi.car.utils.HttpClientUtil;
import org.junit.Test;

public class SmsMessageControllerTest {

	//String sendSmsurl = "http://192.168.11.88:8080/huasi-car-app/system/sms/send";
	String url = "http://192.168.11.88:8081/car-service/system/sms/send";

	@Test
	public void send() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userPhone", "15330061450");
		String post = HttpClientUtil.post(url, params);
		System.out.println(post);
	}
}
