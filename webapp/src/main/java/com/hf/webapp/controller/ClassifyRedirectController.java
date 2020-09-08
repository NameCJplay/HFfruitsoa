package com.hf.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


//我也是用来跳转的!
@Controller
@RequestMapping("/webapp")
public class ClassifyRedirectController {

    @GetMapping("/ClassifyIndex")
    public String index(){
        return "classify/classify";
    }

    @GetMapping("/ClassifyAdd")
    String add(){
        return "classify/add";
    }

    @GetMapping("/ClassifyAddThis")
    String addthis(@RequestParam("classifyId")Integer classifyId, Model model){
        model.addAttribute("classifyId",classifyId);
        return "classify/add";
    }
    //带参跳转
    @GetMapping("/ClassifyEdit")
    String edit(@RequestParam("classifyId")Integer classifyId, Model model){
        model.addAttribute("classifyId",classifyId);
        return "classify/edit";
    }


}
