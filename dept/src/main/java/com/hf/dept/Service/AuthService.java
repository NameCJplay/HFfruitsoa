package com.hf.dept.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@FeignClient(value = "ZUUL")
public interface AuthService {

    @RequestMapping("/authService/getAuth")
    public Map<String,Object> getAuth();

}
