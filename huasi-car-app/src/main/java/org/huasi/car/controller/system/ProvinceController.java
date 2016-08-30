package org.huasi.car.controller.system;

import java.util.List;

import org.huasi.car.common.core.response.ResponseEntity;
import org.huasi.car.system.entity.SysProvince;
import org.huasi.car.system.service.SysProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/system/province")
public class ProvinceController {
	
	@Autowired
	private SysProvinceService sysProvinceService;
	
	/**
	 * 获取所有的省
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity getAllProvince(){
		List<SysProvince> provinces = sysProvinceService.getAllProvince();
		return new ResponseEntity(provinces);
	}
}
