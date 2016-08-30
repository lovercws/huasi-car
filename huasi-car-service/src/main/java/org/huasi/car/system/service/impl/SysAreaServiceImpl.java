package org.huasi.car.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.huasi.car.system.dao.SysAreaDao;
import org.huasi.car.system.entity.SysArea;
import org.huasi.car.system.service.SysAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysAreaServiceImpl implements SysAreaService {
	
	@Autowired
	private SysAreaDao sysAreaDao;

	@Override
	public List<SysArea> getAllSysArea(String cCode) {
		Map<String, Object> paramMap = new HashMap<String,Object>();
		paramMap.put("cCode", cCode);
		return sysAreaDao.listByColumn(paramMap);
	}

}
