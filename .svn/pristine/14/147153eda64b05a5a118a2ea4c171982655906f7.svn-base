package org.huasi.car.info.service;

import org.huasi.car.info.entity.ActiveLike;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT, readOnly = true)
public interface ActiveLikeService {

	/**
	 * 对某个动态进行点赞
	 * 
	 * @param activeId
	 * @param userId
	 * @return
	 */
	public ActiveLike addActiveLike(String activeId, String userId);

	/**
	 * 判断某个动态某个用户是否已经点赞
	 * 
	 * @param activeId
	 * @param userId
	 * @return
	 */
	public ActiveLike getActiveLike(String activeId, String userId);

	/**
	 * 对某个动态取消点赞，改变点赞的状态
	 * 
	 * @param activeId
	 * @param userId
	 * @return
	 */
	public boolean updateActiveLike(String activeId, String userId);

}
