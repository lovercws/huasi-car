package org.huasi.car.controller.user;

import java.util.List;

import org.huasi.car.common.core.controller.BaseController;
import org.huasi.car.common.core.response.ResponseEntity;
import org.huasi.car.user.entity.AppUserCar;
import org.huasi.car.user.service.AppUserCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/app/usercar")
public class AppUserCarController extends BaseController {

	@Autowired
	private AppUserCarService appUserCarService;
	
	/**
	 * 获取用户下的车辆列表
	 * @param carId 车辆id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "/user/{userId}" }, method = RequestMethod.GET)
	public ResponseEntity getAppUserCarByUserId(@PathVariable String userId) {
		List<AppUserCar> appUserCars = appUserCarService.getAppUserCarByUserId(userId);
		return new ResponseEntity(appUserCars);
	}
	
	/**
	 * 获取用户的汽车信息
	 * @param carId 车辆id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "/{carId}" }, method = RequestMethod.GET)
	public ResponseEntity getAppUserCarByCarId(@PathVariable String carId) {
		AppUserCar appUserCar = appUserCarService.getAppUserCarByCarId(carId);
		return new ResponseEntity(appUserCar);
	}
	
	/**
	 * 插入用户的汽车信息
	 * @param appUserCar
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity addAppUserCar(AppUserCar appUserCar) {
		appUserCar = appUserCarService.addAppUserCar(appUserCar);
		return new ResponseEntity(appUserCar);
	}

	/**
	 * 更新用户的汽车信息
	 * @param carId 车辆id
	 * @param appUserCar
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "/{carId}" }, method = RequestMethod.POST)
	public ResponseEntity updateAppUserCar(@PathVariable String carId,AppUserCar appUserCar) {
		boolean isUpdate = appUserCarService.updateAppUserCar(appUserCar);
		return new ResponseEntity(isUpdate);
	}
}
