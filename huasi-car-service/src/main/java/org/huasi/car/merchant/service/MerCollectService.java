package org.huasi.car.merchant.service;

import org.huasi.car.merchant.entity.MerCollect;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT, readOnly = true)
public interface MerCollectService {

	/**
	 * 添加收藏商铺
	 * @param merCollect
	 * @return
	 */
	public MerCollect collectMerchant(String merId, String userId);

	/**
	 * 判断是否已经收藏过
	 * @param merId
	 * @param suerId
	 * @return
	 */
	public MerCollect getMerchantCollect(String merId, String userId);
}
