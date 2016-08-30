package org.huasi.car.controller.info;

import org.huasi.car.utils.HttpClientUtil;
import org.junit.Test;

public class ActiveClassifyControllerTest {

	@Test
	public void getAllInfoClassify() {
		String url = "http://192.168.11.88:8081/huasi-car-app/info/classify";
		String string = HttpClientUtil.get(url);
		System.out.println(string);
	}
	
	@Test
	public void getActiveByClassifyId() {
		String url = "http://192.168.11.88:8081/huasi-car-app/info/classify/1/active";
		String string = HttpClientUtil.get(url);
		System.out.println(string);
	}
}
