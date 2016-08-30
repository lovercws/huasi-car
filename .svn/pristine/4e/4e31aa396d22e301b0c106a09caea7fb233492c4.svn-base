package org.huasi.car.merchant.dao;

import java.util.List;
import java.util.Map;

import org.huasi.car.common.core.dao.BaseDao;
import org.huasi.car.merchant.entity.Merchant;

public interface MerchantDao extends BaseDao<Merchant> {

	public List<Merchant> getNearbyMerchant(Map<String, Object> paramMap);
	
	public List<Merchant> getMerchantByUserId(int userId);

	public List<Merchant> matchMerchantByNearby(Map<String, Object> paramMap);

	public List<Merchant> matchMerchantByEvaluation(Map<String, Object> paramMap);

	public List<Merchant> matchMerchantByPopular(Map<String, Object> paramMap);

}
