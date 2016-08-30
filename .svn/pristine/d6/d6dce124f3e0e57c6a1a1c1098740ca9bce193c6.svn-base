package org.huasi.car.payment.alipay.service;

import java.util.UUID;

import org.junit.Test;

public class AlipayServiceTest {

	@Test
	public void requestRSAService() {
		AlipayPayService alipayService = new AlipayPayService();
		String sign = alipayService.requestRSAService("测试", "车行", UUID.randomUUID().toString().replace("-", ""),
				"0.01");
		System.out.println(sign);
	}

	@Test
	public void requestCheckRSAService() {
		AlipayPayService alipayService = new AlipayPayService();
		alipayService.requestCheckRSAService(
				"app_id='2088511248020001'&biz_content={'body':'测试','subject':'车行','out_trade_no':'bfa350a522e64c73adc226931c78644c','timeout_express':'1d','total_amount':'0.01','seller_id':'2088511248020001','product_code':'2088511248020001'}&charset='utf-8'&format='JSON'&method='alipay.trade.app.pay'&notify_url='http://221.174.22.15:9001/alipay/pc/notify_url.jsp'&sign_type='RSA'&timestamp='2016-08-26 09:38:05'&version='1.0'",
				"ENN6qHqymDos5j5whLZeiCHFi2nRDaWx95Elfa5yhj0Xrpv2vnz7eWZHcidFxKyaq7UyxDaVhHJgT2/MXJXBL5ni7EL60br/XHn9rDirkgb4jUrlQ1Jp2rUI3x8jIF1MfWeg79QV7ol26xvGFIkExVACyyGmEDifUPx5M8A3WkE=");
	}
}
