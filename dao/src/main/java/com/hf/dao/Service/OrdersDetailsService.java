package com.hf.dao.Service;


import com.hf.domain.Domain.Orders.OrdersDetailsDO;

import java.util.List;
import java.util.Map;

public interface OrdersDetailsService {
	
	OrdersDetailsDO get(Long detailsId);
	
	List<OrdersDetailsDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OrdersDetailsDO ordersDetails);
	
	int update(OrdersDetailsDO ordersDetails);
	
	int remove(Long detailsId);
	
	int batchRemove(Long[] detailsIds);

	List<OrdersDetailsDO> getbyoid(String detailsOrdersnumber);
}
