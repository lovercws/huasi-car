package org.huasi.car.controller.portal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/portal")
public class PasswordController {

	/**
	 * 进入到忘记密码页面
	 * @return
	 */
	@RequestMapping(value={"/forgetPassword"},method=RequestMethod.GET)
	public ModelAndView forgetPassword() {
		return new ModelAndView("portal/forgetPassword");
	}
	
	/**
	 * 选择找回密码的方式
	 * @return
	 */
	@RequestMapping(value={"/findPasswordWay"},method=RequestMethod.POST)
	public ModelAndView selectRestPasswordWay(){
		return new ModelAndView("portal/findPasswordWay");
	}
}
