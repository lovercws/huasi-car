package org.huasi.car.comment.service;

import org.huasi.car.comment.entity.MerOrdCommLike;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT, readOnly = true)
public interface MerOrdCommLikeService {

	/**
	 * 对商铺服务订单的评论进行点赞
	 * 
	 * @param commId
	 * @param userId
	 * @return
	 */
	public MerOrdCommLike addMerOrdCommLike(String commId, String userId);

	/**
	 * 对商铺服务订单的评论取消点赞
	 * 
	 * @param commId
	 * @param userId
	 * @return
	 */
	public boolean deleteMerOrdCommLike(String commlikeId);

	/**
	 * 判断商铺服务订单的评论是否已经点赞
	 * 
	 * @param commId
	 * @param userId
	 * @return
	 */
	public MerOrdCommLike getMerOrdCommLike(String commId, String userId);
}
