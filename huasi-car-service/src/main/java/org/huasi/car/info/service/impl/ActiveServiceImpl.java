package org.huasi.car.info.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.huasi.car.common.core.enums.PublicEnum;
import org.huasi.car.common.core.page.PageParam;
import org.huasi.car.info.dao.ActiveDao;
import org.huasi.car.info.entity.Active;
import org.huasi.car.info.service.ActiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActiveServiceImpl implements ActiveService {

	@Autowired
	private ActiveDao activeDao;

	@Override
	public List<Active> getAllActive(int pageNum) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("activeStatus", PublicEnum.NORMAL.value());

		int beginPageIndex = (pageNum - 1) * PageParam.DEFAULT_NUM_PER_PAGE;
		int endPageIndex = pageNum * PageParam.DEFAULT_NUM_PER_PAGE;
		paramMap.put("beginPageIndex", beginPageIndex);
		paramMap.put("endPageIndex", endPageIndex);
		return activeDao.getAllActive(paramMap);
	}

	@Override
	public List<Active> getActiveByClassifyId(String classifyId, int pageNum) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("activeStatus", PublicEnum.NORMAL.value());
		paramMap.put("activeClassifyId", classifyId);

		int beginPageIndex = (pageNum - 1) * PageParam.DEFAULT_NUM_PER_PAGE;
		int endPageIndex = pageNum * PageParam.DEFAULT_NUM_PER_PAGE;
		paramMap.put("beginPageIndex", beginPageIndex);
		paramMap.put("endPageIndex", endPageIndex);
		return activeDao.getActiveByClassifyId(paramMap);
	}

}
