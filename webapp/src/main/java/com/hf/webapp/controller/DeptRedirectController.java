package com.hf.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//我也是用来跳转的!
@Controller
@RequestMapping("/webapp")
public class DeptRedirectController {

    @GetMapping("/DeptIndex")
    public String index(){
        return "dept/dept";
    }

    @GetMapping("/DeptAdd")
    String add(){
        return "dept/add";
    }

    @GetMapping("/DeptAddThis")
    String addthis(@RequestParam("deptId")Integer deptId, Model model){
        model.addAttribute("deptId",deptId);
        return "dept/add";
    }
    //带参跳转
    @GetMapping("/DeptEdit")
    String edit(@RequestParam("deptId")Integer deptId, Model model){
        model.addAttribute("deptId",deptId);
        return "dept/edit";
    }
}
