package org.huasi.car.converter;

import java.io.IOException;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
/**
 * @desc springmvc消息转换器 
 * @author ganliang
 * @version 2016年8月11日 下午1:37:40
 * @param <T>
 */
public class GlobalHttpMessageConverter<T> extends AbstractHttpMessageConverter<T> {

	@Override
	protected boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	protected T readInternal(Class<? extends T> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
		return null;
	}

	@Override
	protected void writeInternal(Object t, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {

	}
}
