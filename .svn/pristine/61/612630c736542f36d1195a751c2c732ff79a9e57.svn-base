package org.huasi.car.system.service;

import java.util.List;

import org.huasi.car.system.entity.SysFeedback;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT, readOnly = true)
public interface SysFeedbackService {

	/**
	 * 获取所有的意见反馈
	 * 
	 * @return
	 */
	public List<SysFeedback> getAllFeedback();

	/**
	 * 添加意见反馈
	 * 
	 * @param sysFeedback
	 * @return
	 */
	public SysFeedback addFeedback(SysFeedback sysFeedback);
}
