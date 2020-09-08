package com.hf.webapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/webapp")
public class UserRedirectController {

    @GetMapping("/UserIndex")
    public String index(){
        return "user/user";
    }

    @GetMapping("/UserAdd")
    String add(){
        return "user/add";
    }
    //带参跳转
    @GetMapping("/UserEdit")
    String edit(@RequestParam("userId")Integer userId, Model model){
        model.addAttribute("userId",userId);
        return "user/edit";
    }
    @GetMapping("/UserDetails")
    String UserDetails(){
        return "user/details";
    }

    @GetMapping("/UserEditPwd")
    String UserEditPwd(){
        return "user/editPwd";
    }

}
