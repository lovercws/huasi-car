package org.huasi.car.controller.system;

import java.util.List;

import org.huasi.car.common.core.controller.BaseController;
import org.huasi.car.common.core.response.ResponseEntity;
import org.huasi.car.system.entity.SysCity;
import org.huasi.car.system.service.SysCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/system/city")
public class CityController extends BaseController {

	@Autowired
	private SysCityService sysCityService;

	/**
	 * 获取所有的城市
	 * @param pCode
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity getAllSysCity() {
		List<SysCity> sysCitys = sysCityService.getAllSysCity();
		return new ResponseEntity(sysCitys);
	}

	/**
	 * 根据输入的内容来搜索城市（城市的名称、拼音和简拼）
	 * @param py
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "/search" }, method = RequestMethod.GET)
	public ResponseEntity getSysCityByPy(String searchContent) {
		List<SysCity> sysCity = sysCityService.getSysCityByPy(searchContent);
		return new ResponseEntity(sysCity);
	}
	
	/**
	 * 获取热门城市
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value={"/host"},method=RequestMethod.GET)
	public ResponseEntity getHostCity(){
		List<SysCity> sysCity=sysCityService.getHotCity();
		return new ResponseEntity(sysCity);
	}
	
}
