package com.hf.webapp.controller;

import com.netflix.client.http.HttpResponse;
import org.springframework.http.HttpRequest;
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
public class FruitsRedirectController {

    @GetMapping("/FruitsIndex")
    public String index(){
        return "fruits/fruits";
    }

    @GetMapping("/FruitsAdd")
    String add(){
        return "fruits/add";
    }
    //带参跳转
    @GetMapping("/FruitsEdit")
    String edit(@RequestParam("fruitsId")Integer fruitsId, Model model){
        model.addAttribute("fruitsId",fruitsId);
        return "fruits/edit";
    }

}
