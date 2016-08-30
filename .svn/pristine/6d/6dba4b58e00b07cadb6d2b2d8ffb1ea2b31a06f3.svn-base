package com.tencent.service;

import java.io.IOException;
import java.lang.reflect.Field;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.tencent.common.XMLParser;
import com.tencent.protocol.paycall_protocol.PayCallReqData;
import com.tencent.protocol.paycall_protocol.PayCallResData;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

/**
 * @desc 微信回调 
 * @author ganliang
 * @version 2016年8月23日 上午11:09:12
 */
public class PayCallService {

	public PayCallResData requestPayCallResData(String xml)
			throws InstantiationException, IllegalAccessException,
			ParserConfigurationException, IOException, SAXException {
		Object resDataFromXml = XMLParser.getResDataFromXml(xml,
				PayCallResData.class);
		return (PayCallResData) resDataFromXml;
	}

	public String requestPayCallReqData(PayCallReqData payCallReqData)
			throws IllegalArgumentException, IllegalAccessException {
		Field[] fields = payCallReqData.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			field.set(payCallReqData, "<![CDATA[" + field.get(payCallReqData)
					+ "]]>");
		}
		// 解决XStream对出现双下划线的bug
		XStream xStreamForRequestPostData = new XStream(new DomDriver("UTF-8",
				new XmlFriendlyNameCoder("-_", "_")));
		// 将要提交给API的数据对象转换成XML格式数据Post给API
		String postDataXML = xStreamForRequestPostData.toXML(payCallReqData);
		postDataXML = postDataXML.replace(
				"com.tencent.protocol.paycall_protocol.PayCallReqData", "xml");
		postDataXML = postDataXML.replace("&lt;", "<");
		postDataXML = postDataXML.replace("&gt;", ">");
		return postDataXML;
	}
}
