package org.huasi.car.controller.merchant;

import org.huasi.car.utils.HttpClientUtil;
import org.junit.Test;

public class MerchantClassifyControllerTest {

	String sendSmsurl = "http://192.168.11.88:8080/car-service/mer/classify";

	@Test
	public void getAllClassify() {
		String post = HttpClientUtil.get(sendSmsurl);
		System.out.println(post);
	}
	
	@Test
	public void getClassify(){
		String body = HttpClientUtil.get(sendSmsurl+"/"+1+"/child");
		System.out.println(body);
	}
}
