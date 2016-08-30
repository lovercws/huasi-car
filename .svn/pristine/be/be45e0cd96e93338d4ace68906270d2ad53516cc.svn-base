package org.huasi.car.comment.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.huasi.car.comment.dao.MerOrdCommentDao;
import org.huasi.car.comment.entity.MerOrdComment;
import org.huasi.car.comment.service.MerOrdCommentService;
import org.huasi.car.common.core.exception.BizException;
import org.huasi.car.merchant.dao.MerchantDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerOrdCommentServiceImpl implements MerOrdCommentService {

	@Autowired
	private MerOrdCommentDao commentDao;

	@Autowired
	private MerchantDao merchantDao;

	@Override
	public List<MerOrdComment> getMerOrdCommentByMerId(int merId) {
		return commentDao.getMerOrdCommentByMerId(merId);
	}

	@Override
	public MerOrdComment addMerOrdComment(MerOrdComment merOrdComment) {
		//更新商户评论数量
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("merEvaCount", 1);
		paramMap.put("merId", merOrdComment.getMerId());
		int update = merchantDao.update(paramMap);
		if(update<1){
			throw new BizException("更新商户信息失败");
		}
		return merOrdComment = commentDao.insert(merOrdComment);
	}

	@Override
	public boolean addOrdCommReplayByCommId(int commId, String commMerReply) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("commId", commId);
		paramMap.put("commMerReply", commMerReply);
		return commentDao.update(paramMap) > 0;
	}

}
