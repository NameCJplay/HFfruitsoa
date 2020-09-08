package com.hf.dao.Controller;

import java.util.List;
import java.util.Map;

import com.hf.dao.Service.OrdersService;
import com.hf.domain.Domain.Orders.OrdersDO;
import com.hf.domain.Domain.Orders.OrdersDataDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/ordersService")
public class OrdersApiController {
	@Autowired
	private OrdersService ordersService;

	@GetMapping("/get")
	OrdersDO get(@RequestParam("ordersId") Long ordersId){return ordersService.get(ordersId);};
	@PostMapping(value = "/list",consumes = "application/json")
	List<OrdersDO> list(@RequestBody Map<String, Object> map){return ordersService.list(map);};
	@RequestMapping("/count")
	int count(@RequestBody Map<String,Object> map){return ordersService.count(map);};
	@PostMapping("/save")
	int save(@RequestBody OrdersDO orders){return ordersService.save(orders);};
	@PostMapping("/update")
	int update(@RequestBody OrdersDO orders){return ordersService.update(orders);};
	@PostMapping("/remove")
	int remove(@RequestParam("ordersId")Long ordersId){return ordersService.remove(ordersId);};
	@PostMapping("/batchRemove")
	int batchRemove(@RequestParam("ordersIds")Long[] ordersIds){return ordersService.batchRemove(ordersIds);};

	@PostMapping("/getDataOrders")
	List<OrdersDataDo> getDataOrders(@RequestBody OrdersDataDo ordersDataDo){return ordersService.getDataOrders(ordersDataDo);};



}
