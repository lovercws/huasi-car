package org.huasi.car.order.dao;

import org.huasi.car.common.core.dao.BaseDao;
import org.huasi.car.order.entity.Order;

public interface OrderDao extends BaseDao<Order> {

	public Order getOrderByOrderCode(String ordCode);

	public int updateByOrderCode(Order ord);

}
