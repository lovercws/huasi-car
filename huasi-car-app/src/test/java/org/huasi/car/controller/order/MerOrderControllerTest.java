package org.huasi.car.controller.order;

import java.util.HashMap;
import java.util.Map;

import org.huasi.car.utils.HttpClientUtil;
import org.junit.Test;

public class MerOrderControllerTest {

	@Test
	public void order() {
		String url = "http://192.168.11.88:8081/huasi-car-app/mer/order";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", "1");
		params.put("orderBody", "[{\"srvId\":1,\"orddetailCount\":1},{\"srvId\":2,\"orddetailCount\":1}]");
		String string = HttpClientUtil.post(url, params);
		System.out.println(string);
	}

}
