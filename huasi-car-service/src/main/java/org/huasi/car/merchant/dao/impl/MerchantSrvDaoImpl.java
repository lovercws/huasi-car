package org.huasi.car.merchant.dao.impl;

import java.util.List;
import java.util.Map;

import org.huasi.car.common.core.dao.impl.BaseDaoImpl;
import org.huasi.car.merchant.dao.MerchantSrvDao;
import org.huasi.car.merchant.entity.MerService;
import org.springframework.stereotype.Repository;

@Repository
public class MerchantSrvDaoImpl extends BaseDaoImpl<MerService> implements MerchantSrvDao {

	@Override
	public List<MerService> getRecommentMerchantService(Map<String, Object> paramMap) {
		return getSessionTemplate().selectList("getRecommentMerchantService", paramMap);
	}

	@Override
	public List<MerService> getMerServiceBySrvId(List<Integer> srvIds) {
		return getSessionTemplate().selectList("getMerServiceBySrvId", srvIds);
	}

}
