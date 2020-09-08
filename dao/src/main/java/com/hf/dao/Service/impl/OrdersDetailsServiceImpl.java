package com.hf.dao.Service.impl;

import com.hf.dao.Dao.OrdersDetailsDao;
import com.hf.dao.Service.OrdersDetailsService;
import com.hf.domain.Domain.Orders.OrdersDetailsDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service
public class OrdersDetailsServiceImpl implements OrdersDetailsService {
	@Autowired
	private OrdersDetailsDao ordersDetailsDao;
	
	@Override
	public OrdersDetailsDO get(Long detailsId){
		return ordersDetailsDao.get(detailsId);
	}
	
	@Override
	public List<OrdersDetailsDO> list(Map<String, Object> map){
		return ordersDetailsDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return ordersDetailsDao.count(map);
	}
	
	@Override
	public int save(OrdersDetailsDO ordersDetails){
		return ordersDetailsDao.save(ordersDetails);
	}
	
	@Override
	public int update(OrdersDetailsDO ordersDetails){
		return ordersDetailsDao.update(ordersDetails);
	}
	
	@Override
	public int remove(Long detailsId){
		return ordersDetailsDao.remove(detailsId);
	}
	
	@Override
	public int batchRemove(Long[] detailsIds){
		return ordersDetailsDao.batchRemove(detailsIds);
	}

	@Override
	public List<OrdersDetailsDO> getbyoid(String detailsOrdersnumber) {
		return ordersDetailsDao.getbyoid(detailsOrdersnumber);
	}

}
