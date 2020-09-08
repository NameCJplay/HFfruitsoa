package com.hf.orders.Controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hf.domain.Annatation.MyAuthorize;
import com.hf.domain.Common.*;
import com.hf.domain.Domain.Fruits.FruitsDO;
import com.hf.domain.Domain.Orders.CashierDo;
import com.hf.domain.Domain.Orders.OrdersDO;
import com.hf.domain.Domain.Orders.OrdersDetailsDO;
import com.hf.orders.Domain.AlipayBean;
import com.hf.orders.Service.OrdersDetailsService;
import com.hf.orders.Service.OrdersService;
import com.hf.orders.Util.AlipayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/ordersDetails")
public class OrdersDetailsController {
	@Autowired
	private OrdersDetailsService ordersDetailsService;
	@Autowired
	private OrdersService ordersService;

	@RequestMapping(value = "/getbyid")
	public PageUtils getbyoid(@RequestParam Map<String, Object> params,@RequestParam("detailsOrdersnumber")String detailsOrdersnumber) throws IllegalAccessException {
		Map<String,Object> map= QueryStruct.objectToMap(params);
		map.put("detailsOrdersnumber",detailsOrdersnumber);
		List<OrdersDetailsDO> ordersDetailsList = ordersDetailsService.getbyid(detailsOrdersnumber);
		int total = ordersDetailsService.count(map);
		PageUtils pageUtils = new PageUtils(ordersDetailsList, total);
		return pageUtils;
	}

	@MyAuthorize(Role = {"ROLE_USER","ROLE_ADMIN"})
	@PostMapping(value = "/pay", consumes = "application/json")//
	public String pay(@RequestBody Map<Integer,CashierDo> list,HttpServletResponse response) throws AlipayApiException, IOException {
		AlipayBean alipayBean = new AlipayBean();
		try {
			//用户id
			Integer ordersUserId = (Integer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			//部门id
			Long ordersDeptId = ordersDetailsService.getUser(ordersUserId.longValue()).getUserDeptId();
			//订单编号
			String orders_number = OrderGenUtil.getOrderIdByUUId();
			//总价
			Double ordersGross = 0.0;
			//折扣
			Double ordersDiscount = 1.0;
			//折扣后总价
			Double ordersDcprice = 0.0;
			//利润
			Double ordersProfit = 0.0;
			//创建时间
			Date ordersCreateDate = new Date();
			//交易状态 默认为2已付款
			Integer ordersStatus = 1;

			List<FruitsDO> fruitList = new ArrayList();
			List<OrdersDetailsDO> orderDetailList = new ArrayList();
			Map<String,Object> orderMap = new HashMap<>();

			for (int i = 0; i < list.size(); i++) {

				CashierDo cashierDo = list.get(i);
				//折扣 8折
				Double detailsDiscount = (cashierDo.getDetailsDiscount() == null || cashierDo.getDetailsDiscount().equals("") ? 1.0 : new Double(cashierDo.getDetailsDiscount()));
				//数量
				Double detailsCount = new Double(cashierDo.getDetailsCount());
				//商品id
				long detailsFruitsid = new Long(cashierDo.getdetailsFruitsid());
				FruitsDO fruitsDO = ordersDetailsService.getFruit(detailsFruitsid);
				fruitsDO.setFruitsStock((int) (fruitsDO.getFruitsStock() - detailsCount));
				//单价
				Double detailsPrice = new Double(cashierDo.getDetailsPrice());
				//成本单价
				Double fruitsCprice = fruitsDO.getFruitsCprice();
				//成本价
				Double detailsCprice = MathUtil.KeepThreePoint(fruitsCprice * detailsCount);
				//小计
				Double detailsGross = new Double(cashierDo.getDetailsGross());
				//折扣后价格
				Double detailsDcprice = MathUtil.KeepThreePoint(detailsGross * detailsDiscount);
				//利润
				Double detailsProfit = MathUtil.KeepThreePoint(detailsDcprice - detailsCprice);

				ordersGross += detailsGross;
				ordersDiscount = detailsDiscount;
				ordersDcprice = new Double(cashierDo.getDetailsDcprice());
				ordersProfit += detailsProfit;

				OrdersDetailsDO ordersDetailsDO =
						new OrdersDetailsDO(null, orders_number, detailsFruitsid, cashierDo.getDetailsFruitsname(), detailsCount, detailsPrice, detailsGross, detailsDiscount, detailsDcprice, detailsCprice, detailsProfit);
				fruitList.add(fruitsDO);
				orderDetailList.add(ordersDetailsDO);
//				if (ordersDetailsService.Fupdate(fruitsDO) < 0) result = false;
//				if (ordersDetailsService.save(ordersDetailsDO) < 0) result = false;
			}
			OrdersDO ordersDO =
					new OrdersDO(null, orders_number, ordersUserId.longValue(), ordersDeptId, ordersGross, ordersDiscount, ordersDcprice, ordersProfit, ordersCreateDate, ordersCreateDate, ordersStatus);

//			if (ordersService.save(ordersDO) < 0) result = false;
			//将订单信息存到Redis
			orderMap.put("orderDetailList",orderDetailList);
			orderMap.put("fruitList",fruitList);
			orderMap.put("ordersDO",ordersDO);
			ordersDetailsService.hmset(orders_number,orderMap,60*10);
//			Map<Object, Object> o = ordersDetailsService.hmget(orders_number);
			//设置支付码参数
			alipayBean.setOut_trade_no(orders_number);
			alipayBean.setSubject(fruitList.get(0).getFruitsName()+"...等"+fruitList.size()+"件商品");
			alipayBean.setTotal_amount(ordersDcprice+"");
//			response.setContentType("text/html;charset=UTF-8");
//			response.getWriter().write(AlipayUtil.alipay(alipayBean));
//			response.getWriter().flush();
//			response.getWriter().close();
		}catch (Exception e){
			e.printStackTrace();
		}
		return AlipayUtil.alipay(alipayBean);
	}
	/**
	 * 保存
	 */
	@RequestMapping(value = "/save")
	@MyAuthorize(Role = {"ROLE_USER","ROLE_ADMIN"})
	public void save(HttpServletRequest request, HttpServletResponse response)  {
		try {
			String key = request.getParameter("out_trade_no");
			Map<Object, Object> orderMap = ordersDetailsService.hmget(key);

			List<OrdersDetailsDO> orderDetailList = (List<OrdersDetailsDO>) orderMap.get("orderDetailList");
			List<FruitsDO> fruitList = (List<FruitsDO>) orderMap.get("fruitList");
			OrdersDO ordersDO = JSONObject.parseObject(JSONObject.toJSONString(orderMap.get("ordersDO")) ,OrdersDO.class);

			for (int i = 0;i< orderDetailList.size();i++){
				OrdersDetailsDO ordersDetails = JSONObject.parseObject(JSONObject.toJSONString(orderDetailList.get(i)) ,OrdersDetailsDO.class);
				FruitsDO fruitsDO = JSONObject.parseObject(JSONObject.toJSONString(fruitList.get(i)) ,FruitsDO.class);
				ordersDetailsService.Fupdate(fruitsDO);
				ordersDetailsService.save(ordersDetails);
			}
			ordersDO.setOrdersStatus(2);
			ordersService.save(ordersDO);
			response.sendRedirect("http://localhost:8080/Cashier");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
