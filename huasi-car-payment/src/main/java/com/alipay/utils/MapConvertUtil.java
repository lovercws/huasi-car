package com.alipay.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

/**
 * @desc 将对象转化为map
 * @author ganliang
 * @version 2016年8月26日 上午8:51:06
 */
public class MapConvertUtil {

	/**
	 * 将对象转化为map
	 * 
	 * @param obj
	 * @return
	 */
	public static Map<String, String> objectToMap(Object obj) {
		if (obj == null) {
			return null;
		}
		Map<String, String> map = new HashMap<String, String>();
		try {
			// 获取对象所有的参数
			Field[] declaredFields = obj.getClass().getDeclaredFields();
			for (Field field : declaredFields) {
				field.setAccessible(true);
				// 参数名
				String name = field.getName();
				// 参数值
				Object value = field.get(obj);
				if (value == null) {
					continue;
				}
				Gson gson=new Gson();
				map.put(name, gson.toJson(value));
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return map;
	}
}
