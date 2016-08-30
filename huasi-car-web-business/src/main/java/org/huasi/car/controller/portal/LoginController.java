package org.huasi.car.controller.portal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/portal/login")
public class LoginController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView layout() {
		return new ModelAndView("portal/login");
	}
}
