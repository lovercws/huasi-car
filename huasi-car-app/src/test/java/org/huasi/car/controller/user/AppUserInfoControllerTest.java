package org.huasi.car.controller.user;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.huasi.car.utils.HttpClientUtil;
import org.junit.Test;

public class AppUserInfoControllerTest {

	@Test
	public void uploadAvator() {
		String url = "http://192.168.11.88:8081/huasi-car-app/app/userinfo/1/avator";
		List<File> files = new ArrayList<File>();
		files.add(new File("c:/unintall.log"));

		Map<String, Object> paramMap = new HashMap<String, Object>();
		String post = HttpClientUtil.upload(url, files, paramMap);
		System.out.println(post);
	}
	
	@Test
	public void getUserCity() {
		String url = "http://192.168.11.88:8081/huasi-car-app/app/userinfo/1/city";
		String post = HttpClientUtil.get(url);
		System.out.println(post);
	}

	@Test
	public void updateUserCity() {
		String url = "http://192.168.11.88:8081/huasi-car-app/app/userinfo/1/city/信阳";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		//paramMap.put("cName", "信阳");
		String post = HttpClientUtil.post(url, paramMap);
		System.out.println(post);
	}
}