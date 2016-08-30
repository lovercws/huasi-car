package org.huasi.car.merchant.dao.impl;

import java.util.List;

import org.huasi.car.common.core.dao.impl.BaseDaoImpl;
import org.huasi.car.merchant.dao.MerClassifyDao;
import org.huasi.car.merchant.entity.MerClassify;
import org.springframework.stereotype.Repository;

@Repository
public class MerClassifyDaoImpl extends BaseDaoImpl<MerClassify> implements MerClassifyDao {

	@Override
	public List<MerClassify> getMerClassifyByMerId(int merId) {
		return getSessionTemplate().selectList("getMerClassifyByMerId", merId);
	}

}
