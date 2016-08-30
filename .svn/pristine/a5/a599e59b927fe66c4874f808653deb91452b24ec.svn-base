package org.huasi.car.merchant.service;

import java.util.List;

import org.huasi.car.merchant.entity.MerClassify;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT, readOnly = true)
public interface MerClassifyService {

	/**
	 * 获取所有的分类
	 * @param level 分类等级 0（默认）:显示所有的分类 1:只显示大分类；2:显示二级分类
	 * @return
	 */
	public List<MerClassify> getAllClassify(int level);

	/**
	 * 获取商家分类下的所有子分类
	 * @param classifyId 分类id
	 * @return
	 */
	public List<MerClassify> getClassifyByPrtClassifyId(String classifyId);

	/**
	 * 根据分类id 获取分类信息
	 * @param classifyId 分类id
	 * @return
	 */
	public MerClassify getClassifyByClassifyId(String classifyId);

	/**
	 * 根据商铺id 获取分类列表
	 * @param i
	 * @return
	 */
	public List<MerClassify> getMerClassifyByMerId(int merId);

}
