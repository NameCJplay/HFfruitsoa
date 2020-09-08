package com.hf.dao.Dao;


import java.util.List;
import java.util.Map;

import com.hf.domain.Domain.Orders.OrdersDetailsDO;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface OrdersDetailsDao {

	OrdersDetailsDO get(Long detailsId);
	
	List<OrdersDetailsDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(OrdersDetailsDO ordersDetails);
	
	int update(OrdersDetailsDO ordersDetails);
	
	int remove(Long details_id);
	
	int batchRemove(Long[] detailsIds);

	List<OrdersDetailsDO> getbyoid(String detailsOrdersnumber);
}
