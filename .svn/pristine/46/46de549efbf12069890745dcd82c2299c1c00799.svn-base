package org.huasi.car.merchant.dao.impl;

import java.util.List;
import java.util.Map;

import org.huasi.car.common.core.dao.impl.BaseDaoImpl;
import org.huasi.car.merchant.dao.MerchantDao;
import org.huasi.car.merchant.entity.Merchant;
import org.springframework.stereotype.Repository;

@Repository
public class MerchantDaoImpl extends BaseDaoImpl<Merchant> implements MerchantDao {

	@Override
	public List<Merchant> getNearbyMerchant(Map<String, Object> paramMap) {
		return getSessionTemplate().selectList(getStatement("getNearbyMerchant"), paramMap);
	}

	@Override
	public List<Merchant> getMerchantByUserId(int userId) {
		return getSessionTemplate().selectList(getStatement("getMerchantByUserId"), userId);
	}

	@Override
	public List<Merchant> matchMerchantByNearby(Map<String, Object> paramMap) {
		return getSessionTemplate().selectList(getStatement("matchMerchantByNearby"), paramMap);
	}

	@Override
	public List<Merchant> matchMerchantByEvaluation(Map<String, Object> paramMap) {
		return getSessionTemplate().selectList(getStatement("matchMerchantByEvaluation"), paramMap);
	}

	@Override
	public List<Merchant> matchMerchantByPopular(Map<String, Object> paramMap) {
		return getSessionTemplate().selectList(getStatement("matchMerchantByPopular"), paramMap);
	}

}
