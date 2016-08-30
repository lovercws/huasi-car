package com.tencent.common;

import java.lang.reflect.Field;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

public class JSONParse {

	/**
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @Title: getResDataFromJSON
	 * @Description: 从返回的JSON中封装实体对象
	 * @param @param responseString
	 * @param @param class1
	 * @param @return
	 * @return Object 返回类型
	 * @throws
	 */
	@SuppressWarnings("rawtypes")
	public static Object getResDataFromJSON(String responseString, Class clazz)
			throws InstantiationException, IllegalAccessException {

		Field[] fields = clazz.getDeclaredFields();

		Object resData = clazz.newInstance();

		JSONObject jsonObject = JSONObject.fromObject(responseString);

		for (Object key : jsonObject.keySet()) {
			Object value = jsonObject.get(key);
			for (Field field : fields) {
				String fieldName = field.getName();
				field.setAccessible(true);
				if (String.valueOf(key).equalsIgnoreCase(fieldName)) {
					// 是json数组
					if (JSONUtils.isArray(value)) {
						JSONArray jsonArray = JSONArray.fromObject(value);
						field.set(resData, jsonArray.toString());
					} else {
						field.set(resData, value);
					}
				}
			}
		}

		return resData;
	}
}
