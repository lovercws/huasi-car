package org.huasi.car.log.service.impl;

import org.huasi.car.log.dao.MerSearchLogDao;
import org.huasi.car.log.entity.MerSearchLog;
import org.huasi.car.log.service.MerSearchLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerSearchLogServiceImpl implements MerSearchLogService {

	@Autowired
	private MerSearchLogDao searchLogDao;

	@Override
	public void addMerSearchLog(MerSearchLog searchLog) {
		searchLogDao.insert(searchLog);
	}

}
