package com.hf.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/webapp")
public class IndexRedirectController {

    @RequestMapping("/")
    public String hf(){
        return "index";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/Cashier")
    public String cashier(){
        return "Cashier";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/loginHtml")
    public String loginHtml(){
        return "login";
    }

}
