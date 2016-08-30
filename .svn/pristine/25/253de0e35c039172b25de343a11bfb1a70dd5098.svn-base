package org.huasi.car.info.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.huasi.car.common.core.enums.PublicEnum;
import org.huasi.car.info.dao.ActiveLikeDao;
import org.huasi.car.info.entity.ActiveLike;
import org.huasi.car.info.service.ActiveLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActiveLikeServiceImpl implements ActiveLikeService {

	@Autowired
	private ActiveLikeDao activeLikeDao;

	@Override
	public ActiveLike addActiveLike(String activeId, String userId) {
		ActiveLike activeLike = new ActiveLike();
		activeLike.setActiveId(Integer.parseInt(activeId));
		activeLike.setUserId(Integer.parseInt(userId));
		activeLike.setActiveLikeStatus(PublicEnum.NORMAL.value());
		activeLike.setActiveLikeCreateTime(new Date());
		return activeLikeDao.insert(activeLike);
	}

	@Override
	public ActiveLike getActiveLike(String activeId, String userId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("activeId", activeId);
		paramMap.put("userId", userId);
		paramMap.put("activeCommStatus", PublicEnum.NORMAL.value());
		return activeLikeDao.getByColumn(paramMap);
	}

	public boolean updateActiveLike(String activeId, String userId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("activeId", activeId);
		paramMap.put("userId", userId);
		paramMap.put("activeCommStatus", PublicEnum.DELETE.value());
		paramMap.put("activeLikeCreateTime", new Date());
		return activeLikeDao.update(paramMap) > 0;
	}

}
