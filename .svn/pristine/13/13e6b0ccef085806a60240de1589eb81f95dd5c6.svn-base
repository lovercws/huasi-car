package org.huasi.car.info.dao.impl;

import java.util.List;
import java.util.Map;

import org.huasi.car.common.core.dao.impl.BaseDaoImpl;
import org.huasi.car.info.dao.ActiveDao;
import org.huasi.car.info.entity.Active;
import org.springframework.stereotype.Repository;

@Repository
public class ActiveDaoImpl extends BaseDaoImpl<Active> implements ActiveDao {

	@Override
	public List<Active> getActiveByClassifyId(Map<String, Object> paramMap) {
		return getSessionTemplate().selectList("getActiveByClassifyId", paramMap);
	}

	@Override
	public List<Active> getAllActive(Map<String, Object> paramMap) {
		return getSessionTemplate().selectList("getAllActive", paramMap);
	}

}
