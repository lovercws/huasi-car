package org.huasi.car.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/system")
public class SystemController {

	@RequestMapping(value={"/main"},method=RequestMethod.GET)
	public ModelAndView main() {
		return new ModelAndView("/system/main");
	}
}
