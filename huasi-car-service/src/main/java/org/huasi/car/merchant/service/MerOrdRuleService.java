package org.huasi.car.merchant.service;

import java.util.List;

import org.huasi.car.merchant.entity.MerOrdRule;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT, readOnly = true)
public interface MerOrdRuleService {
	
	/**
	 * 获取商家排序规则的列表
	 * @return
	 */
	public List<MerOrdRule> getAllMerOrdRule();

}
