package org.huasi.car.log.service;

import org.huasi.car.log.entity.MerSearchLog;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT, readOnly = true)
public interface MerSearchLogService {

	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void addMerSearchLog(MerSearchLog searchLog);

}
