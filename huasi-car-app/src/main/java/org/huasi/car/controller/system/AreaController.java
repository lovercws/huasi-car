package org.huasi.car.controller.system;

import java.util.List;

import org.huasi.car.common.core.controller.BaseController;
import org.huasi.car.common.core.response.ResponseEntity;
import org.huasi.car.system.entity.SysArea;
import org.huasi.car.system.service.SysAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @desc 获取城市的区域
 * @author duanzhixin
 * @version 2016年8月11日 上午13：43
 */
@Controller
@RequestMapping("/system/area")
public class AreaController extends BaseController {

	@Autowired
	private SysAreaService sysAreaService;

	/**
	 * 获取城市中的所有区
	 * 
	 * @param cCode
	 *            城市的code
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "/{cCode}" }, method = RequestMethod.GET)
	public ResponseEntity getAllSysArea(@PathVariable String cCode) {
		List<SysArea> sysAreas = sysAreaService.getAllSysArea(cCode);
		return new ResponseEntity(sysAreas);
	}
}
