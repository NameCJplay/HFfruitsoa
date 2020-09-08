package com.hf.dao.Service.impl;

import com.hf.dao.Dao.OrdersDao;
import com.hf.dao.Service.OrdersService;
import com.hf.domain.Domain.Orders.OrdersDO;
import com.hf.domain.Domain.Orders.OrdersDataDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service
public class OrdersServiceImpl implements OrdersService {
	@Autowired
	private OrdersDao ordersDao;
	
	@Override
	public OrdersDO get(Long ordersId){
		return ordersDao.get(ordersId);
	}
	
	@Override
	public List<OrdersDO> list(Map<String, Object> map){
		return ordersDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return ordersDao.count(map);
	}
	
	@Override
	public int save(OrdersDO orders){
		return ordersDao.save(orders);
	}
	
	@Override
	public int update(OrdersDO orders){
		return ordersDao.update(orders);
	}
	
	@Override
	public int remove(Long ordersId){
		return ordersDao.remove(ordersId);
	}
	
	@Override
	public int batchRemove(Long[] ordersIds){
		return ordersDao.batchRemove(ordersIds);
	}

	@Override
	public List<OrdersDataDo> getDataOrders(OrdersDataDo ordersDataDo) {return ordersDao.getDataOrders(ordersDataDo); }

}
