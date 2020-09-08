package com.hf.orders.Controller;

import java.util.List;
import java.util.Map;

import com.hf.domain.Annatation.MyAuthorize;
import com.hf.domain.Common.PageUtils;
import com.hf.domain.Common.Query;
import com.hf.domain.Common.QueryStruct;
import com.hf.domain.Common.R;
import com.hf.domain.Domain.Orders.OrdersDO;
import com.hf.orders.Service.OrdersDetailsService;
import com.hf.orders.Service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/orders")
public class OrdersController {
	@Autowired
	private OrdersService ordersService;
	@Autowired
	private OrdersDetailsService ordersDetailsService;
	

	@GetMapping("/list")
	@MyAuthorize(Role = {"ROLE_USER","ROLE_ADMIN"})
	public PageUtils list(@RequestParam Map<String, Object> params) throws IllegalAccessException {
		Integer userid = (Integer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//查询列表数据
		Map<String,Object> map= QueryStruct.objectToMap(params);
		map.put("ordersUserId",	ordersDetailsService.getUser(userid.longValue()).getUserId());
		List<OrdersDO> ordersList = ordersService.list(map);
		int total = ordersService.count(map);
		PageUtils pageUtils = new PageUtils(ordersList, total);
		return pageUtils;
	}

	@MyAuthorize(Role = {"ROLE_ADMIN"})
	@PostMapping( "/remove")
	public R remove( Long ordersId){
		if(ordersService.remove(ordersId)>0){
		return R.ok();
		}
		return R.error();
	}

}
