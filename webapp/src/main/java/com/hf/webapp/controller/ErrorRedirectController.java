package com.hf.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/webapp")
public class ErrorRedirectController {

    @RequestMapping("/Error403")
    public String hf403(){
        return "Error/Error403";
    }

    @RequestMapping("/Error404")
    public String hf404(){
        return "Error/Error404";
    }

    @RequestMapping("/Error500")
    public String hf500(){
        return "Error/Error500";
    }


}
