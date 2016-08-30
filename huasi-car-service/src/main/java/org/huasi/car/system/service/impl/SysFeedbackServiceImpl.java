package org.huasi.car.system.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.huasi.car.common.core.enums.FeedbackEnum;
import org.huasi.car.system.dao.SysFeedbackDao;
import org.huasi.car.system.entity.SysFeedback;
import org.huasi.car.system.service.SysFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysFeedbackServiceImpl implements SysFeedbackService {

	@Autowired
	private SysFeedbackDao sysFeedbackDao;

	@Override
	public List<SysFeedback> getAllFeedback() {
		return sysFeedbackDao.listByColumn(new HashMap<String, Object>());
	}

	@Override
	public SysFeedback addFeedback(SysFeedback sysFeedback) {
		sysFeedback.setCreateTime(new Date());
		sysFeedback.setFeedbackStatus(FeedbackEnum.NORMAL.value());
		return sysFeedbackDao.insert(sysFeedback);
	}

}
