package org.huasi.car.comment.service;

import java.util.List;

import org.huasi.car.comment.entity.MerOrdComment;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation=Propagation.SUPPORTS,isolation=Isolation.DEFAULT,readOnly=true)
public interface MerOrdCommentService {

	/**
	 * 获取商铺下的评论
	 * @param merId
	 * @return
	 */
	public List<MerOrdComment> getMerOrdCommentByMerId(int merId);
	
	/**
	 * 添加服务下的评论
	 * @param merOrdComment
	 * @return
	 */
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public MerOrdComment addMerOrdComment(MerOrdComment merOrdComment);
	
	/**
	 * 根据评论的id进行回复
	 * @param commId 评论的id
	 * @param commReplay 评论的回复
	 * @return
	 */
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public boolean addOrdCommReplayByCommId(int commId,String commMerReply);

}
