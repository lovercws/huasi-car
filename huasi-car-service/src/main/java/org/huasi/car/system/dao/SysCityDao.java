package org.huasi.car.system.dao;

import java.util.List;

import org.huasi.car.common.core.dao.BaseDao;
import org.huasi.car.system.entity.SysCity;

public interface SysCityDao extends BaseDao<SysCity>{

	public List<SysCity> getHotCity();

	public SysCity getSysCityByUserId(String userId);
	
}
