package org.huasi.car.system.service.impl;

import java.util.HashMap;
import java.util.List;

import org.huasi.car.system.dao.SysProvinceDao;
import org.huasi.car.system.entity.SysProvince;
import org.huasi.car.system.service.SysProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysProvinceServiceImpl implements SysProvinceService {
	
	@Autowired
	private SysProvinceDao sysProvinceDao;

	@Override
	public List<SysProvince> getAllProvince() {
		return sysProvinceDao.listByColumn(new HashMap<String, Object>());
	}

}
