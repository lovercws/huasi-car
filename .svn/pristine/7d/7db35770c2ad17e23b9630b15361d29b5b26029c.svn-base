package org.huasi.car.controller.user;

import java.util.HashMap;
import java.util.Map;

import org.huasi.car.utils.HttpClientUtil;
import org.junit.Test;

public class AppUserLoginControllerTest {

	//String url = "http://192.168.11.88:8081/car-service/app/user/register";
	String url = "http://192.168.11.88:8080/huasi-car-app/app/user/register";

	@Test
	public void register() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userPhone", "15330061489");
		String post = HttpClientUtil.post(url, params);
		System.out.println(post);
	}
}
