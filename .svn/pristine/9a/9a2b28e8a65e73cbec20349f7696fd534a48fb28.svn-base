package org.huasi.car.info.service;

import java.util.List;

import org.huasi.car.info.entity.ActiveClassify;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT, readOnly = true)
public interface ActiveClassifyService {
	
	/**
	 * 获取所有的动态分类
	 * @return
	 */
	public List<ActiveClassify> getAllActiveClassify();
}
