package org.huasi.car.controller.portal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/portal/login")
public class LoginController {

	/**
	 * 进入到系统登录页面
	 * @return
	 */
	@RequestMapping(value = { "/goLogin" }, method = RequestMethod.GET)
	public ModelAndView goLogin() {
		return new ModelAndView("portal/login");
	}

	/**
	 * 用户登录
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView login() {
		return new ModelAndView("portal/login");
	}
}
