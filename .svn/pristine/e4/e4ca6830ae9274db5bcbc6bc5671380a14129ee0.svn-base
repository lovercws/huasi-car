package org.huasi.car.controller.system;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.huasi.car.utils.HttpClientUtil;
import org.junit.Test;

public class FeedbackControllerTest {

	String url = "http://192.168.11.88:8081/huasi-car-app/system/feedback";

	@Test
	public void addFeedback() {
		// 文件集合
		List<File> files = new ArrayList<File>();
		files.add(new File("c:/unintall.log"));
		files.add(new File("c:/unintall.log"));
		files.add(new File("c:/unintall.log"));
		files.add(new File("c:/unintall.log"));
		files.add(new File("c:/unintall.log"));
		files.add(new File("c:/unintall.log"));
		files.add(new File("c:/unintall.log"));
		files.add(new File("c:/unintall.log"));
		files.add(new File("c:/unintall.log"));
		files.add(new File("c:/unintall.log"));
		files.add(new File("c:/unintall.log"));
		files.add(new File("c:/unintall.log"));
		files.add(new File("c:/unintall.log"));
		files.add(new File("c:/unintall.log"));
		files.add(new File("c:/unintall.log"));
		files.add(new File("c:/unintall.log"));
		files.add(new File("c:/unintall.log"));
		files.add(new File("c:/unintall.log"));
		files.add(new File("c:/unintall.log"));
		files.add(new File("c:/unintall.log"));
		files.add(new File("c:/unintall.log"));
		files.add(new File("c:/unintall.log"));
		files.add(new File("c:/unintall.log"));
		files.add(new File("c:/unintall.log"));
		files.add(new File("c:/unintall.log"));
		files.add(new File("c:/unintall.log"));
		files.add(new File("c:/unintall.log"));
		files.add(new File("c:/unintall.log"));
		files.add(new File("c:/unintall.log"));
		files.add(new File("c:/unintall.log"));
		// 参数map
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", "1");
		paramMap.put("feedbackTitle", "反攻大陆");
		paramMap.put("feedbackContent", "反攻大陆11111111111111111111");
		// httpclient upload
		String upload = HttpClientUtil.upload(url, files, paramMap);
		System.out.println(upload);
	}
}
