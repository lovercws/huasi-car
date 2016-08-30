package org.huasi.car.controller.merchant;

import java.util.HashMap;
import java.util.Map;

import org.huasi.car.common.core.enums.OrdRuleEnum;
import org.huasi.car.utils.HttpClientUtil;
import org.junit.Test;

public class MerchantSearchControllerTest {

	@Test
	public void search() {
		String url = "http://192.168.11.88:8081/huasi-car-app/mer/merchant/search";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("searchContent", "洗车");
		params.put("userId", "1");

		String post = HttpClientUtil.post(url, params);
		System.out.println(post);
	}

	@Test
	public void getNearbyMerchant() {
		String url = "http://192.168.11.88:8081/huasi-car-app/mer/merchant/nearby";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("merLang", "1.00");
		params.put("merLat", "2.00");
		String post = HttpClientUtil.post(url,params);
		System.out.println(post);
	}
	
	@Test
	public void matchByMearby() {
		String url = "http://192.168.11.88:8081/huasi-car-app/mer/merchant/match";
		Map<String, Object> params = new HashMap<String, Object>();
		//params.put("classifyId", "1");
		//params.put("areaCode", "1");
		params.put("ordruleId", OrdRuleEnum.INTELLIGENT_ORDERING.value());
		params.put("merLang", "1.00");
		params.put("merLat", "2.00");
		params.put("pageNum", "1");
		String post = HttpClientUtil.post(url,params);
		System.out.println(post);
	}
	
	@Test
	public void matchByEvaluation() {
		String url = "http://192.168.11.88:8081/huasi-car-app/mer/merchant/match";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("classifyId", "1");
		//params.put("areaCode", "1");
		params.put("ordruleId", OrdRuleEnum.EVALUATION_BEST.value());
		String post = HttpClientUtil.post(url,params);
		System.out.println(post);
	}
	
	@Test
	public void matchByPopular() {
		String url = "http://192.168.11.88:8081/huasi-car-app/mer/merchant/match";
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("classifyId", "1");
		params.put("areaCode", "420111");
		params.put("ordruleId", OrdRuleEnum.POPULAR_MOST.value());
		String post = HttpClientUtil.post(url,params);
		System.out.println(post);
	}
}
