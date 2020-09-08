package com.hf.dao.Controller;

import java.util.List;
import java.util.Map;

import com.hf.dao.Service.OrdersDetailsService;
import com.hf.domain.Domain.Orders.OrdersDetailsDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/ordersDetailsService")
public class OrdersDetailsApiController {
	@Autowired
	private OrdersDetailsService ordersDetailsService;
	@GetMapping("/get")
	OrdersDetailsDO get(@RequestParam("detailsId") Long detailsId){return ordersDetailsService.get(detailsId);}
	@GetMapping("/getbyid")
	List<OrdersDetailsDO> getbyid(@RequestParam("detailsOrdersnumber")String detailsOrdersnumber){return ordersDetailsService.getbyoid(detailsOrdersnumber);}
	@PostMapping(value = "/list",consumes = "application/json")
	List<OrdersDetailsDO> list(@RequestBody Map<String, Object> map){return ordersDetailsService.list(map);}
	@RequestMapping("/count")
	int count(@RequestBody Map<String, Object> map){return ordersDetailsService.count(map);}
	@PostMapping("/save")
	int save(@RequestBody OrdersDetailsDO ordersDetails){return ordersDetailsService.save(ordersDetails);};
	@PostMapping("/update")
	int update(@RequestBody OrdersDetailsDO ordersDetails){return ordersDetailsService.update(ordersDetails);};
	@PostMapping("/remove")
	int remove(@RequestParam("detailsId")Long detailsId){return ordersDetailsService.remove(detailsId);};
	@PostMapping("/batchRemove")
	public int batchRemove(Long[] detailsIds){
		return ordersDetailsService.batchRemove(detailsIds);
	}





}
