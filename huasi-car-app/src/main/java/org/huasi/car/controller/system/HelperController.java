package org.huasi.car.controller.system;

import java.util.List;

import org.huasi.car.common.core.controller.BaseController;
import org.huasi.car.common.core.response.ResponseEntity;
import org.huasi.car.system.entity.SysHelper;
import org.huasi.car.system.service.SysHelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/system/helper")
public class HelperController extends BaseController {

	@Autowired
	private SysHelperService sysHelperService;

	/**
	 * 获取所有的系统帮助
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity getAllHelper() {
		List<SysHelper> helpers = sysHelperService.getAllHelper();
		return new ResponseEntity(helpers);
	}
}
