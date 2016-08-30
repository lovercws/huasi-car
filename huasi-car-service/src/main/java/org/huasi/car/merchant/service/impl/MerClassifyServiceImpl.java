package org.huasi.car.merchant.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.huasi.car.common.core.enums.PublicEnum;
import org.huasi.car.merchant.dao.MerClassifyDao;
import org.huasi.car.merchant.entity.MerClassify;
import org.huasi.car.merchant.service.MerClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerClassifyServiceImpl implements MerClassifyService {

	@Autowired
	private MerClassifyDao classifyDao;

	@Override
	public List<MerClassify> getAllClassify(int level) {
		// level 默认为 显示全部
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("level", level);
		paramMap.put("classifyStatus", PublicEnum.NORMAL.value());
		return classifyDao.listBy(paramMap);
	}

	@Override
	public List<MerClassify> getClassifyByPrtClassifyId(String prtClassifyId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("prtClassifyId", prtClassifyId);
		paramMap.put("classifyStatus", PublicEnum.NORMAL.value());
		return classifyDao.listBy(paramMap);
	}

	@Override
	public MerClassify getClassifyByClassifyId(String classifyId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("classifyId", classifyId);
		paramMap.put("classifyStatus", PublicEnum.NORMAL.value());
		List<MerClassify> classifys = classifyDao.listBy(paramMap);
		if (classifys != null && classifys.size() > 0) {
			return classifys.get(0);
		}
		return null;
	}

	@Override
	public List<MerClassify> getMerClassifyByMerId(int merId) {
		return classifyDao.getMerClassifyByMerId(merId);
	}

}
