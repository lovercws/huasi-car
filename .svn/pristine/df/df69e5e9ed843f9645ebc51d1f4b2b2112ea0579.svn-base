package org.huasi.car.comment.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.huasi.car.comment.dao.MerOrdCommLikeDao;
import org.huasi.car.comment.entity.MerOrdCommLike;
import org.huasi.car.comment.service.MerOrdCommLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerOrdCommLikeServiceImpl implements MerOrdCommLikeService {

	@Autowired
	private MerOrdCommLikeDao merOrdCommLikeDao;

	@Override
	public MerOrdCommLike addMerOrdCommLike(String commId, String userId) {
		MerOrdCommLike merOrdCommLike = new MerOrdCommLike();
		merOrdCommLike.setCommId(Integer.parseInt(commId));
		merOrdCommLike.setUserId(Integer.parseInt(userId));
		merOrdCommLike.setCommlikeCreateTime(new Date());
		return merOrdCommLikeDao.insert(merOrdCommLike);
	}

	@Override
	public boolean deleteMerOrdCommLike(String commlikeId) {
		return merOrdCommLikeDao.delete(commlikeId) > 0;
	}

	@Override
	public MerOrdCommLike getMerOrdCommLike(String commId, String userId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("commId", commId);
		paramMap.put("userId", userId); 
		return merOrdCommLikeDao.getByColumn(paramMap);
	}

}
