package org.huasi.car.info.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.huasi.car.common.core.enums.PublicEnum;
import org.huasi.car.info.dao.ActiveCommentDao;
import org.huasi.car.info.entity.ActiveComment;
import org.huasi.car.info.service.ActiveCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActiveCommetServiceImpl implements ActiveCommentService {

	@Autowired
	private ActiveCommentDao activeCommentDao;

	@Override
	public ActiveComment addActiveComment(ActiveComment activeComment) {
		activeComment.setActiveCommStatus(PublicEnum.NORMAL.value());
		activeComment.setActiveCommCreateTime(new Date());
		return activeCommentDao.insert(activeComment);
	}

	@Override
	public List<ActiveComment> getActiveCommentByActiveId(String activeId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("activeId", activeId);
		paramMap.put("activeCommStatus", PublicEnum.NORMAL.value());
		return activeCommentDao.listByColumn(paramMap);
	}

}
