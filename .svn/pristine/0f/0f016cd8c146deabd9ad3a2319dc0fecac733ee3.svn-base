package org.huasi.car.comment.dao.impl;

import java.util.List;

import org.huasi.car.comment.dao.MerOrdCommentDao;
import org.huasi.car.comment.entity.MerOrdComment;
import org.huasi.car.common.core.dao.impl.BaseDaoImpl;
import org.springframework.stereotype.Repository;

@Repository
public class MerOrdCommentDaoImpl extends BaseDaoImpl<MerOrdComment> implements MerOrdCommentDao {

	@Override
	public List<MerOrdComment> getMerOrdCommentByMerId(int merId) {
		return getSessionTemplate().selectList("getMerOrdCommentByMerId", merId);
	}

}
