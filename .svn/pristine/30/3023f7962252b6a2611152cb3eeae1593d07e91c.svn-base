/**
 * 
 */
package org.huasi.car.common.core.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.huasi.car.common.core.response.HttpCode;
import org.huasi.car.common.core.response.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;

/**
 * @desc 控制器基类
 * @author ganliang
 * @version 2016年8月8日 下午2:37:50
 */
@Component
public class BaseController {
	public final Logger log = Logger.getLogger(BaseController.class);
	private static final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

	/**
	 * 设置成功响应代码
	 * 
	 * @return
	 */
	public String setSuccessResponseBody() {
		return setSuccessResponseBody(null);
	}

	/**
	 * 设置成功响应代码
	 * 
	 * @param data
	 * @return
	 */
	public String setSuccessResponseBody(Object data) {
		return setResponseBody(HttpCode.OK, data);
	}

	/**
	 * 设置响应代码
	 * 
	 * @param code
	 * @return
	 */
	public String setResponseBody(HttpCode code) {
		return setResponseBody(code, null);
	}

	/**
	 * 设置响应代码
	 * 
	 * @param code
	 * @param data
	 * @return
	 */
	public String setResponseBody(HttpCode code, Object data) {
		ResponseEntity responseEntity = new ResponseEntity();
		if (data == null) {
			responseEntity.setData(new HashMap<String, String>());
		} else {
			responseEntity.setData(data);
		}
		responseEntity.setCode(code.code());
		responseEntity.setMsg(code.msg());
		return toJSON(responseEntity);
	}

	/**
	 * 将 ResponseEntity 对象转化为json
	 * 
	 * @return
	 */
	private String toJSON(Object obj) {
		String json = gson.toJson(obj);
		log.info("返回结果 " + json);
		return json;
	}

	/**
	 * 将对象转化为xml
	 * 
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unused")
	private String toXML(Object obj) {
		XStream xstream = new XStream();
		xstream.alias("response", ResponseEntity.class);
		String xml = xstream.toXML(obj);
		return xml;
	}

	/**
	 * 输出
	 * 
	 * @param response
	 * @param responseBody
	 */
	public void print(HttpServletResponse response, String responseBody) {
		print(response, responseBody, HttpStatus.OK.value());
	}

	/**
	 * 输出
	 * @param response
	 * @param responseBody
	 * @param status response状态码
	 */
	public void print(HttpServletResponse response, String responseBody, int status) {
		try {
			response.setStatus(status);
			response.getWriter().print(responseBody);
		} catch (IOException e) {
			log.error(e);
		}
	}
}
