package org.hausi.car.sms.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.apache.log4j.Logger;

/**
 * @description 第一信息 sms平台短信服务
 * @author ganliang
 * @date 2016年7月29日上午11:28:31
 */
public class InfoSMSService {
	private static Logger log = Logger.getLogger(InfoSMSService.class);
	private static String SIGN = "";
	private static String NAME = "18518299667";
	private static String PWD = "C06D13FD0FA094527F5F4B1A1D90";

	public static boolean sendSMS(String mobile, String content) {
		try {
			StringBuffer sb = new StringBuffer(
					"http://sms.1xinxi.cn/asmx/smsservice.aspx?");
			sb.append("name=" + NAME);
			sb.append("&pwd=" + PWD);
			sb.append("&mobile=" + mobile);
			sb.append("&content="
					+ URLEncoder.encode("【华四】  亲爱的华四，你好。您的本次验证码是" + content
							+ "如非本人操作，请忽略本条提醒。回复TD可退订本信息。", "utf-8"));
			sb.append("&stime=");
			sb.append("&sign=" + URLEncoder.encode(SIGN, "utf-8"));
			sb.append("&type=pt&extno=");
			URL url = new URL(sb.toString());

			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestMethod("POST");
			BufferedReader in = new BufferedReader(new InputStreamReader(
					url.openStream()));
			String inputline = in.readLine();
			String responseCode = inputline.split(",")[0];
			log.info(inputline);
			if ("0".equals(responseCode)) {
				// log.info("短信发送成功!" + mobile + " 发送内容:[" + content + "]");
				return true;
			}
			// log.info("短信发送失败!" + mobile + " 发送内容:[" + content + "]");
		} catch (Exception e) {
			throw new RuntimeException("发送短信出现异常", e);
		}
		return false;
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// sendSMS("18518299667", "123456");
		sendSMS("15330061450", "123456");
	}
}
