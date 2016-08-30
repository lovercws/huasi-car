package org.huasi.car.system.service.impl;

import java.util.HashMap;
import java.util.List;

import org.huasi.car.system.dao.SysHelperDao;
import org.huasi.car.system.entity.SysHelper;
import org.huasi.car.system.service.SysHelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysHelperServiceImpl implements SysHelperService {

	@Autowired
	private SysHelperDao sysHelperDao;

	@Override
	public List<SysHelper> getAllHelper() {
		return sysHelperDao.listByColumn(new HashMap<String, Object>());
	}

}
