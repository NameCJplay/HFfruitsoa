package com.hf.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * 我是用来跳转的controller
 * */
@Controller
@RequestMapping("/webapp")
public class OrdersRedirectController {

    @GetMapping("/OrdersIndex")
    public String index(){
        return "orders/orders";
    }
    //带参跳转
    @GetMapping("/OrdersEdit")
    String edit(@RequestParam("ordersId")Integer ordersId, Model model){
        model.addAttribute("ordersId",ordersId);
        return "orders/edit";
    }
    //订单详情
    @GetMapping("/OrdersDetailsIndex")
    public String Detailsindex(@RequestParam("ordersNumber")String ordersNumber, Model model){
        model.addAttribute("ordersNumber",ordersNumber);
        return "ordersDetails/ordersDetails";
    }

}
