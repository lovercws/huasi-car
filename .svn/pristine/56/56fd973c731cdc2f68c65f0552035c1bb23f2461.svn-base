package org.huasi.car.system.dao.impl;

import java.util.List;

import org.huasi.car.common.core.dao.impl.BaseDaoImpl;
import org.huasi.car.system.dao.SysCityDao;
import org.huasi.car.system.entity.SysCity;
import org.springframework.stereotype.Repository;

@Repository
public class SysCityDaoImpl extends BaseDaoImpl<SysCity> implements SysCityDao {

	@Override
	public List<SysCity> getHotCity() {
		return getSessionTemplate().selectList("getHotCity");
	}

	@Override
	public SysCity getSysCityByUserId(String userId) {
		return getSessionTemplate().selectOne("getSysCityByUserId", userId);
	}

}
