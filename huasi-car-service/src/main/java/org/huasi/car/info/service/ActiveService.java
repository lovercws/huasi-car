package org.huasi.car.info.service;

import java.util.List;

import org.huasi.car.info.entity.Active;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT, readOnly = true)
public interface ActiveService {

	/**
	 * 获取分页的动态
	 * @param pageNum 分页数量
	 * @return
	 */
	public List<Active> getAllActive(int pageNum);

	/**
	 * 获取所有的动态
	 * @param activeClassifyId 动态分类的id
	 * @param pageNum 分页数量
	 * @return
	 */
	public List<Active> getActiveByClassifyId(String classifyId, int pagenum);
}
