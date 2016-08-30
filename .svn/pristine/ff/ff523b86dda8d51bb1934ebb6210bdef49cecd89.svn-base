package org.huasi.car.controller.user;

import java.util.HashMap;
import java.util.Map;

import org.huasi.car.utils.HttpClientUtil;
import org.junit.Test;

public class AppUserCarControllerTest {

	private String url = "http://192.168.11.88:8081/car-service/app/usercar";

	@Test
	public void addUserCar() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("brandId", "1");
		params.put("userId", "2");
		params.put("carNumber", "鄂A7pm38");

		String post = HttpClientUtil.proxyPut(url, params);
		System.out.println(post);
	}
}
