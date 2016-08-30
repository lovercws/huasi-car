package com.tencent.common;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.tencent.protocol.refund_query_protocol.RefundOrderData;

/**
 * User: rizenguo Date: 2014/11/1 Time: 14:06
 */
public class XMLParser {

	/**
	 * 从RefunQueryResponseString里面解析出退款订单数据
	 * 
	 * @param refundQueryResponseString
	 *            RefundQuery API返回的数据
	 * @return 因为订单数据有可能是多个，所以返回一个列表
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<RefundOrderData> getRefundOrderList(
			String refundQueryResponseString) throws IOException, SAXException,
			ParserConfigurationException {
		List list = new ArrayList();

		Map<String, Object> map = XMLParser
				.getMapFromXML(refundQueryResponseString);

		int count = Integer.parseInt((String) map.get("refund_count"));
		Util.log("count:" + count);

		if (count < 1) {
			return list;
		}

		RefundOrderData refundOrderData;

		for (int i = 0; i < count; i++) {
			refundOrderData = new RefundOrderData();

			refundOrderData.setOutRefundNo(Util.getStringFromMap(map,
					"out_refund_no_" + i, ""));
			refundOrderData.setRefundID(Util.getStringFromMap(map, "refund_id_"
					+ i, ""));
			refundOrderData.setRefundChannel(Util.getStringFromMap(map,
					"refund_channel_" + i, ""));
			refundOrderData.setRefundFee(Util.getIntFromMap(map, "refund_fee_"
					+ i));
			refundOrderData.setCouponRefundFee(Util.getIntFromMap(map,
					"coupon_refund_fee_" + i));
			refundOrderData.setRefundStatus(Util.getStringFromMap(map,
					"refund_status_" + i, ""));
			list.add(refundOrderData);
		}

		return list;
	}

	public static Map<String, Object> getMapFromXML(String xmlString)
			throws ParserConfigurationException, IOException, SAXException {

		// 这里用Dom的方式解析回包的最主要目的是防止API新增回包字段
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		InputStream is = Util.getStringStream(xmlString);
		Document document = builder.parse(is);

		// 获取到document里面的全部结点
		NodeList allNodes = document.getFirstChild().getChildNodes();
		Node node;
		Map<String, Object> map = new HashMap<String, Object>();
		int i = 0;
		while (i < allNodes.getLength()) {
			node = allNodes.item(i);
			if (node instanceof Element) {
				map.put(node.getNodeName(), node.getTextContent());
			}
			i++;
		}
		return map;

	}

	/**
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws SAXException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 * @Title: getResDataFromXml
	 * @Description: 把返回结果封装到实体对象中去
	 * @param @param resDataXMLString
	 * @param @param clazz
	 * @param @return
	 * @return Object 返回类型
	 * @throws
	 */
	@SuppressWarnings("rawtypes")
	public static Object getResDataFromXml(String resDataXMLString, Class clazz)
			throws ParserConfigurationException, IOException, SAXException,
			InstantiationException, IllegalAccessException {

		Map<String, Object> mapFromXML = getMapFromXML(resDataXMLString);

		Field[] fields = clazz.getDeclaredFields();

		Object resData = clazz.newInstance();

		for (String key : mapFromXML.keySet()) {
			for (Field field : fields) {
				field.setAccessible(true);

				String fieldName = field.getName();
				Object value = mapFromXML.get(key);
				if (key.equalsIgnoreCase(fieldName)) {
					String typeName = field.getType().getName();
					if ((typeName.equals("int") || typeName
							.equals("java.lang.Integer"))) {
						if (value != null) {
							field.set(resData,
									Integer.parseInt(value.toString()));
						} else {
							field.set(resData, 0);
						}
					} else {
						field.set(resData, value);
					}
				}
			}
		}
		return resData;
	}

}
