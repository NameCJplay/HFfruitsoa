package com.hf.dao.Service;


import com.hf.domain.Domain.Orders.OrdersDO;
import com.hf.domain.Domain.Orders.OrdersDataDo;

import java.util.List;
import java.util.Map;



public interface OrdersService {
	
	OrdersDO get(Long ordersId);
	
	List<OrdersDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OrdersDO orders);
	
	int update(OrdersDO orders);
	
	int remove(Long ordersId);
	
	int batchRemove(Long[] ordersIds);

	List<OrdersDataDo> getDataOrders(OrdersDataDo ordersDataDo);
}
