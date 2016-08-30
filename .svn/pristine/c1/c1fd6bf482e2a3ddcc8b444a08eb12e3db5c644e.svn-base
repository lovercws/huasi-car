package org.huasi.car.log.service;

import org.huasi.car.log.entity.AppUserRegisterLog;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT, readOnly = true)
public interface AppUserRegisterLogService {

	/**
	 * 添加App用户注册日志记录
	 * @param log
	 */
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void addAppuserRegisterLog(AppUserRegisterLog log);

}
