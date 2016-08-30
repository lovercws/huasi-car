package org.huasi.car.system.service;

import java.util.List;

import org.huasi.car.system.entity.SysCity;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT, readOnly = true)
public interface SysCityService {
	/**
	 * 获取所有城市
	 * 
	 * @return
	 */
	public List<SysCity> getAllSysCity();

	/**
	 * 根据输入内容来搜索城市（包含城市名称，拼音和简拼）
	 * @param searchContent
	 * @return
	 */
	public List<SysCity> getSysCityByPy(String searchContent);

	/**
	 * 获取热门城市
	 * @return
	 */
	public List<SysCity> getHotCity();

	/**
	 * 获取用户城市信息
	 * @param userId
	 * @return
	 */
	public SysCity getSysCityByUserId(String userId);
	
}
