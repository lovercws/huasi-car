package org.hausi.car.sms.service;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import cn.jpush.api.utils.Base64;

/**
 * jpush短信发送服务
 * 
 * @author ganliang
 */
public class SMSService {

	private String appKey = "32c9523bce94668163b10256";
	private String masterSecret = "b84f424f1c1c410b4e38d30f";

	private String send_sms_uri = "https://api.sms.jpush.cn/v1/codes";
	private static final String APPLICATION_JSON = "application/json";

	/**
	 * 发送sms消息
	 * @return
	 */
	public boolean sendSMS() {
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();

		HttpPost httpPost = new HttpPost(send_sms_uri);
		httpPost.addHeader("Authorization", getAuthCode());
		httpPost.addHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON);
		try {

			httpPost.setEntity(new StringEntity("{\"mobile\":\"15330061450\",\"temp_id\":1}", "UTF-8"));

			CloseableHttpResponse httpResponse = httpClient.execute(httpPost);

			String string = EntityUtils.toString(httpResponse.getEntity());
			System.out.println(string);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	private String getAuthCode() {
		return Base64.encode((appKey + ":" + masterSecret).getBytes()).toString();
	}

	public static void main(String[] args) {
		new SMSService().sendSMS();
	}
}
