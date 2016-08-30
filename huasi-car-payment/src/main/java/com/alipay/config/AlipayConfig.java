package com.alipay.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.LoggerFactory;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.tencent.common.Configure;
import com.tencent.common.Log;

public class AlipayConfig {

	public static String app_id = "2088511248020001";

	// 商户的私钥【经过编码】
	public static String app_private_key = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAK9c6utq4rKB/P+tG4ehklkwY9zhc1pUwut4XREZdye+gSZRM5WKyGI6krFh8v272N4puIYv02uY9HipYobFJVPhaUZcMf8VJbD/12304tAWjyerP25uZJv3T/1zRQK/KWcnOlr9jhFAfRxBq8kJmNynFCyRgeC4n1ug0BuMAO7BAgMBAAECgYBQskNwXdlAJ80Sosg+W72KyVfK9vwsH0ErNlItYjiQ03t+9HL2Z8zaVvXWJqq41E5xvWUqaquxocsuE1RBjEsmUL/Bnqe9RCiLraevyqFROsPtI1MjLTaOzR5HySGMbx1fS/lwKCmlJaqlLogUYf14Fq9S9GxHgsPpZWt+0QkcOQJBAOVmVEz9/9xxd2kizHpOFt8ObAmwwgJ3BMuOVSUx7nrpZdVnh3p0d0txJ2OIz8YONIVE4DZ2kr7k+ApNmflINJ8CQQDDsoVrH5dJocWmOmqOAq+1dtpdw8qE8BYHF+lD029lFe6ZaQ6Ln8/8E7mSutyFUBFOCl184uY3+Lpl9tlor8CfAkEAzIewIfVVava/wL2GEoYNXlM9gGZYlFoJrHP69m7Ockgmw17LLCMrOdhphhU1KyD/MtN2FRkjPZBolscZwWjfgQJAZoCgX27JmFiypRHd9Ao2LI9Xa1t9PUpfz1FX7h3WMBVfx1z+sGWB1CAkyFU14mIA3maRdzOFsHWIdJXqZGoCMwJASBJS78+VCvPz0YpkUhzyFqK6VSEhBh3fVOIXNquzhaEWECiS2sTNi8JVpoLCw1GdrB/iEI6DaPw1XymBM45EYg==";

	// 支付宝的公钥，无需修改该值
	public static String alipay_public_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";

	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";

	// 签名方式 不需修改
	public static String sign_type = "RSA";

	// 调用的接口版本，固定为：1.0
	public static String format = "JSON";

	// 仅支持JSON
	public static String version = "1.0";

	// 卖家支付宝账号
	public static String seller_id = "2088511248020001";

	// 销售产品码，商家和支付宝签约的产品码
	public static String product_code = "2088511248020001";

	// 服务器异步通知页面路径
	public static String notify_url = "http://221.174.22.15:9001/alipay/pc/notify_url.jsp";

	public static String return_url = "http://221.174.22.15:9001/alipay/pc/notify_url.jsp";

	public static String show_url = "http://221.174.22.15:9001/alipay/pc/notify_url.jsp";

	public static String it_b_pay = "1d";

	// 打log用
	private static Log log = new Log(LoggerFactory.getLogger(Configure.class));
	static {
		String conf_filename = "/properties/alipay.properties";
		InputStream resourceAsStream = Configure.class.getResourceAsStream(conf_filename);
		Properties p = new Properties();
		try {
			log.i("加载alipay配置文件【" + conf_filename + "】.................................");
			p.load(resourceAsStream);
			log.i(p.toString());
			app_id = p.getProperty("app_id");
			app_private_key = p.getProperty("app_private_key");
			alipay_public_key = p.getProperty("alipay_public_key");
			seller_id = p.getProperty("seller_id");
			product_code = p.getProperty("product_code");
			notify_url = p.getProperty("notify_url");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String serverUrl = "";
	private static AlipayClient alipayClient = null;

	/**
	 * 单利获取AlipayClient
	 * 
	 * @return
	 */
	public static synchronized AlipayClient instance() {
		if (alipayClient == null) {
			alipayClient = new DefaultAlipayClient(serverUrl, app_id, app_private_key, format, input_charset);
		}
		return alipayClient;
	}
}
