package org.huasi.car.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.huasi.car.system.dao.SysCityDao;
import org.huasi.car.system.entity.SysCity;
import org.huasi.car.system.service.SysCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysCityServiceImpl implements SysCityService {

	@Autowired
	private SysCityDao sysCityDao;

	@Override
	public List<SysCity> getAllSysCity() {
		return sysCityDao.listByColumn(new HashMap<>());
	}

	@Override
	public List<SysCity> getSysCityByPy(String searchContent) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		//如果用户没有 填入搜索内容 默认显示所有的城市
		if(searchContent!=null&&!"".equals(searchContent)){
			paramMap.put("searchContent", searchContent);
		}
		return sysCityDao.listBy(paramMap);
	}

	@Override
	public List<SysCity> getHotCity() {
		return sysCityDao.getHotCity();
	}

	@Override
	public SysCity getSysCityByUserId(String userId) {
		return sysCityDao.getSysCityByUserId(userId);
	}

}
