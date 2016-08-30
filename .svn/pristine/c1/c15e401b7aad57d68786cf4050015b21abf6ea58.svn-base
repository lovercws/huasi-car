package org.huasi.car.system.service;

import java.util.List;

import org.huasi.car.system.entity.SysCarBrand;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT, readOnly = true)
public interface SysCarBrandService {
	
	/**
	 * 获取所有的汽车品牌
	 * @return
	 */
	public List<SysCarBrand> getAllCarBrand();
}
