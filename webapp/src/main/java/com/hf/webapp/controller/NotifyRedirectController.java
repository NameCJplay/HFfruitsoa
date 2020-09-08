package com.hf.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@RequestMapping("/webapp")
public class NotifyRedirectController {

    @GetMapping("/NotifyIndex")
    public String index(){
        return "notify/notify";
    }

    @GetMapping("/NotifyAdd")
    String add(){
        return "notify/add";
    }
    //带参跳转
    @GetMapping("/NotifyEdit")
    String edit(@RequestParam("notifyId")Integer notifyId, Model model){
        model.addAttribute("notifyId",notifyId);
        return "notify/edit";
    }

    @GetMapping("/NotifyFile")
    String file(@RequestParam("notifyId")Integer notifyId, Model model){
        model.addAttribute("notifyId",notifyId);
        return "notify/notifyFile";
    }

}
