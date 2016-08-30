package org.huasi.car.info.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.huasi.car.common.core.enums.PublicEnum;
import org.huasi.car.info.dao.ActiveClassifyDao;
import org.huasi.car.info.entity.ActiveClassify;
import org.huasi.car.info.service.ActiveClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActiveClassifyServiceImpl implements ActiveClassifyService{
	
	@Autowired
	private ActiveClassifyDao activeClassifyDao;

	@Override
	public List<ActiveClassify> getAllActiveClassify() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("activeClassifyStatus", PublicEnum.NORMAL.value());
		return activeClassifyDao.listByColumn(paramMap);
	}

}
