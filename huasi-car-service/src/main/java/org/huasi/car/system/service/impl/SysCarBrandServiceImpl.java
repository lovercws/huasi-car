package org.huasi.car.system.service.impl;

import java.util.HashMap;
import java.util.List;

import org.huasi.car.system.dao.SysCarBrandDao;
import org.huasi.car.system.entity.SysCarBrand;
import org.huasi.car.system.service.SysCarBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysCarBrandServiceImpl implements SysCarBrandService {

	@Autowired
	private SysCarBrandDao sysCarBrandDao;

	@Override
	public List<SysCarBrand> getAllCarBrand() {
		return sysCarBrandDao.listByColumn(new HashMap<String, Object>());
	}

}
