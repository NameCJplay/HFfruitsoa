package com.hf.orders.Service;


import com.hf.domain.Domain.Fruits.FruitsDO;
import com.hf.domain.Domain.Orders.OrdersDetailsDO;
import com.hf.domain.Domain.User.UserDO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@FeignClient(value = "DAO")
public interface OrdersDetailsService {

	final String prefix = "/ordersDetailsService";
	final String prefix2 = "/fruitsService";
	final String prefix3 = "/userService";
	final String prefix4 = "/redisService";

	@GetMapping(prefix+"/get")
	OrdersDetailsDO get(@RequestParam("detailsId") Long detailsId);
	@GetMapping(prefix+"/getbyid")
	List<OrdersDetailsDO> getbyid(@RequestParam("detailsOrdersnumber")String detailsOrdersnumber);
	@PostMapping(value = prefix+"/list",consumes = "application/json")
	List<OrdersDetailsDO> list(@RequestBody Map<String, Object> map);
	@RequestMapping(prefix+"/count")
	int count(@RequestBody Map<String, Object> map);
	@PostMapping(prefix+"/save")
	int save(@RequestBody OrdersDetailsDO ordersDetails);
	@PostMapping(prefix+"/update")
	int update(@RequestBody OrdersDetailsDO ordersDetails);
	@PostMapping(prefix+"/remove")
	int remove(@RequestParam("detailsId")Long detailsId);
	@PostMapping(prefix+"/batchRemove")
	public int batchRemove(Long[] detailsIds);

	@GetMapping(prefix2+"/get")
	public FruitsDO getFruit(@RequestParam("fruitsId") Long fruitsId);
	@RequestMapping(prefix3+"/get")
	UserDO getUser(@RequestParam("userId")Long userId) ;
	//修改
	@PostMapping(prefix2+"/update")
	public Integer Fupdate(@RequestBody FruitsDO fruits);

	@RequestMapping(value = prefix4+"/get",produces="text/json")
	Object get(@RequestParam("key") String key);

	@RequestMapping(prefix4+"/hasKey")
	boolean hasKey(@RequestParam("key") String key);

	@RequestMapping(prefix4+"/set")
	boolean set(@RequestParam("key") String key,@RequestParam("value") Object value,@RequestParam("time") long time);

	@RequestMapping(prefix4+"/hmget")
	Map<Object, Object> hmget(@RequestParam("key") String key);

	@RequestMapping(prefix4+"/hmset")
	boolean hmset(@RequestParam("key") String key, @RequestBody Map<String, Object> map, @RequestParam("time") long time);


}
