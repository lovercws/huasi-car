package org.huasi.car.merchant.service;

import java.util.List;

import org.huasi.car.merchant.entity.MerService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT, readOnly = true)
public interface MerchantSrvService {

	/**
	 * 获取商铺下的服务
	 * @param merId 商铺id
	 * @return
	 */
	public List<MerService> getMerchantSrvByMerId(int merId);

	/**
	 * 获取推荐的服务
	 * @return
	 */
	public List<MerService> getRecommentMerchantService();

}
