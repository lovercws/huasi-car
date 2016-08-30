package org.huasi.car.controller.system;

import java.util.List;

import org.huasi.car.common.core.controller.BaseController;
import org.huasi.car.common.core.response.ResponseEntity;
import org.huasi.car.system.entity.SysCarBrand;
import org.huasi.car.system.service.SysCarBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/system/carbrand")
public class CarBrandController extends BaseController{
	
	@Autowired
	private SysCarBrandService sysCarBrandService;

	/**
	 * 获取所有的汽车品牌
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity getAllCarBrand(){
		List<SysCarBrand> carBrands = sysCarBrandService.getAllCarBrand();
		return new ResponseEntity(carBrands);
	}
	
}
