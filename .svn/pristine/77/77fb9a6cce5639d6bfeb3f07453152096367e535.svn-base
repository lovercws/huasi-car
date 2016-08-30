package org.huasi.car.payment.wxpay.service;

import org.huasi.car.payment.wxpay.exception.WXPayException;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccessTokenServiceImplTest {

	@Test
	public void requestAccessToken() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"spring/spring-context-payment.xml");

		applicationContext.start();

		WXPayService accessToken = applicationContext.getBean(WXPayService.class);

		try {
			accessToken.requestAccessToken("123");
		} catch (WXPayException e) {
			e.printStackTrace();
		}

		applicationContext.close();
	}
}
