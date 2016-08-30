package org.huasi.car.log.service.impl;

import org.huasi.car.log.dao.AppUserRegisterLogDao;
import org.huasi.car.log.entity.AppUserRegisterLog;
import org.huasi.car.log.service.AppUserRegisterLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @desc app用户注册日志记录 
 * @author ganliang
 * @version 2016年8月12日 上午10:28:18
 */
@Service
public class AppUserRegisterLogServiceImpl implements AppUserRegisterLogService{

	@Autowired
	private AppUserRegisterLogDao registerLogDao;
	
	@Override
	public void addAppuserRegisterLog(AppUserRegisterLog log) {
		registerLogDao.insert(log);
	}

}
