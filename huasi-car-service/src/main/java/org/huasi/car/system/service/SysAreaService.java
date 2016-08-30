package org.huasi.car.system.service;

import java.util.List;

import org.huasi.car.system.entity.SysArea;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT, readOnly = true)
public interface SysAreaService {
	/**
	 * 根据城市code获取城市所属的所有区
	 * @param cCode 城市的codes
	 * @return
	 */
	public List<SysArea> getAllSysArea(String cCode);
}
