package org.huasi.car.resolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.huasi.car.common.core.controller.BaseController;
import org.huasi.car.common.core.response.HttpCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * @desc 全局处理异常
 * @author ganliang
 * @version 2016年8月10日 下午3:05:09
 */
public class GlobalHandlerExceptionResolver implements HandlerExceptionResolver {

	private static final Logger log = Logger.getLogger(GlobalHandlerExceptionResolver.class);

	@Autowired
	private BaseController baseController;

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object object,
			Exception e) {
		log.info("服务器出现异常" + e.getLocalizedMessage());

		String responseBody = baseController.setResponseBody(HttpCode.INTERNAL_SERVER_ERROR);
		
		baseController.print(response, responseBody, 500);
		
		return null;
	}

}
