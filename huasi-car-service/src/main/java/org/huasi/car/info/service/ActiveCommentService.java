package org.huasi.car.info.service;

import java.util.List;

import org.huasi.car.info.entity.ActiveComment;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT, readOnly = true)
public interface ActiveCommentService {

	/**
	 * 对动态进行评论
	 * @param activeComment
	 * @return
	 */
	public ActiveComment addActiveComment(ActiveComment activeComment);

	/**
	 * 获取动态下所有的评论
	 * @param activeId
	 * @param userId
	 * @return
	 */
	public List<ActiveComment> getActiveCommentByActiveId(String activeId);
}
