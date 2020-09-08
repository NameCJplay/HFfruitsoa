package com.hf.orders.Service;


import com.hf.domain.Domain.Orders.OrdersDO;
import com.hf.domain.Domain.Orders.OrdersDataDo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@FeignClient(value = "DAO")
public interface OrdersService {

	final String prefix = "/ordersService";

	@GetMapping(prefix+"/get")
	OrdersDO get(@RequestParam("ordersId") Long ordersId);
	@PostMapping(value = prefix+"/list",consumes = "application/json")
	List<OrdersDO> list(@RequestBody Map<String, Object> map);
	@RequestMapping(prefix+"/count")
	int count(@RequestBody Map<String,Object> map);
	@PostMapping(prefix+"/save")
	int save(@RequestBody OrdersDO orders);
	@PostMapping(prefix+"/update")
	int update(@RequestBody OrdersDO orders);
	@PostMapping(prefix+"/remove")
	int remove(@RequestParam("ordersId")Long ordersId);
	@PostMapping(prefix+"/batchRemove")
	int batchRemove(@RequestParam("ordersIds")Long[] ordersIds);

	//查历史数据
	@PostMapping(prefix + "/getDataOrders")
	List<OrdersDataDo> getDataOrders(@RequestBody OrdersDataDo ordersDataDo);


}
