package com.tencent.service;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.tencent.common.Configure;
import com.tencent.common.XMLParser;
import com.tencent.protocol.closeorder_protocol.CloseOrderReqData;
import com.tencent.protocol.closeorder_protocol.CloseOrderResData;

/**
 * @desc 取消订单服务
 *       以下情况需要调用关单接口：商户订单支付失败需要生成新单号重新发起支付，要对原订单号调用关单，
 *       避免重复支付；系统下单后，用户支付超时，系统退出不再受理，避免用户继续，请调用关单接口。
 * @author ganliang
 * @version 2016年8月23日 上午11:31:48
 */
public class CloseOrderService extends BaseService {

	public CloseOrderService() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		super(Configure.CLOSE_ORDER_API);
	}

	public CloseOrderResData request(CloseOrderReqData orderReqData) throws UnrecoverableKeyException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException, IOException, InstantiationException, IllegalAccessException, ParserConfigurationException, SAXException {
		// --------------------------------------------------------------------
		// 发送HTTPS的Post请求到API地址
		// --------------------------------------------------------------------
		String responseString = sendPost(orderReqData);

		CloseOrderResData resData = (CloseOrderResData) XMLParser.getResDataFromXml(responseString,
				CloseOrderResData.class);
		return resData;
	}
}
