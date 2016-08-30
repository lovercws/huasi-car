package org.huasi.car.order.dao.impl;

import org.huasi.car.common.core.dao.impl.BaseDaoImpl;
import org.huasi.car.common.core.exception.BizException;
import org.huasi.car.order.dao.OrderDao;
import org.huasi.car.order.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl extends BaseDaoImpl<Order> implements OrderDao {

	@Override
	public Order getOrderByOrderCode(String ordCode) {
		return getSessionTemplate().selectOne("getOrderByOrderCode", ordCode);
	}

	@Override
	public int updateByOrderCode(Order ord) {
		int update = getSessionTemplate().update("updateByOrdCode", ord);
		if (update <= 0) {
			throw BizException.DB_UPDATE_RESULT_0.newInstance("数据库操作,updateByOrdCode返回0.{%s}",
					getStatement(SQL_UPDATE_BY_ID));
		}
		return update;
	}

}
