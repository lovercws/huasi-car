package org.huasi.car.common.core.response;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @desc 服务器向客户端返回的数据
 * @author ganliang
 * @version 2016年8月8日 下午1:52:14
 */
@XmlRootElement
public class ResponseEntity implements Serializable {

	private static final long serialVersionUID = 1402067508931778446L;
	private int code;
	private String msg;
	private Object data;// 可以是对象、集合

	public ResponseEntity() {
		HttpCode code=HttpCode.OK;
		this.code = code.code();
		this.msg = code.msg();
	}
	
	public ResponseEntity(Object data) {
		HttpCode code=HttpCode.OK;
		if(data instanceof HttpCode){
			code=(HttpCode)data;
		}else if(data instanceof String){
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("reason", data);
			data=map;
		}
		this.code = code.code();
		this.msg = code.msg();
		this.data = data;
	}
	
	public ResponseEntity(HttpCode code, Object data) {
		this.code = code.code();
		this.msg = code.msg();
		this.data = data;
	}

	public ResponseEntity(int code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponseEntity [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}
}
