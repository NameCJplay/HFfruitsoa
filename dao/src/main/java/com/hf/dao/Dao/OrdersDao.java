package com.hf.dao.Dao;

import java.util.List;
import java.util.Map;

import com.hf.domain.Domain.Orders.OrdersDO;
import com.hf.domain.Domain.Orders.OrdersDataDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@Mapper
public interface OrdersDao {

	OrdersDO get(Long ordersId);
	
	List<OrdersDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(OrdersDO orders);
	
	int update(OrdersDO orders);
	
	int remove(Long orders_id);
	
	int batchRemove(Long[] ordersIds);

	List<OrdersDataDo> getDataOrders(OrdersDataDo ordersDataDo);
}
