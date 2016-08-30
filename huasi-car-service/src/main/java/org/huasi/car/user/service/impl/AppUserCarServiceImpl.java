package org.huasi.car.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.huasi.car.user.dao.AppUserCarDao;
import org.huasi.car.user.entity.AppUserCar;
import org.huasi.car.user.service.AppUserCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserCarServiceImpl implements AppUserCarService {

	@Autowired
	private AppUserCarDao appUserCarDao;

	@Override
	public List<AppUserCar> getAppUserCarByUserId(String userId) {
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("userId", userId);
		return appUserCarDao.listByColumn(paramMap);
	}
	
	@Override
	public AppUserCar getAppUserCarByCarId(String carId) {
		return appUserCarDao.getById(carId);
	}

	@Override
	public AppUserCar addAppUserCar(AppUserCar appUserCar) {
		return appUserCarDao.insert(appUserCar);
	}

	@Override
	public boolean updateAppUserCar(AppUserCar appUserCar) {
		return appUserCarDao.update(appUserCar) > 0;
	}

}
