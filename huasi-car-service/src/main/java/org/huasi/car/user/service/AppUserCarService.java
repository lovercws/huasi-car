package org.huasi.car.user.service;

import java.util.List;

import org.huasi.car.user.entity.AppUserCar;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.SUPPORTS, readOnly = true)
public interface AppUserCarService {

	/**
	 * 获取用户下的车辆列表
	 * @param userId 用户id
	 * @return
	 */
	public List<AppUserCar> getAppUserCarByUserId(String userId);
	
	/**
	 * 获取用户的车辆信息
	 * 
	 * @return
	 */
	public AppUserCar getAppUserCarByCarId(String carId);

	/**
	 * 添加用户的车辆信息
	 * 
	 * @param appUserCar
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public AppUserCar addAppUserCar(AppUserCar appUserCar);

	/**
	 * 更改用户的车辆信息
	 * 
	 * @param appUserCar
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean updateAppUserCar(AppUserCar appUserCar);

}
