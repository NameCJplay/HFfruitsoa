package com.hf.zuul.Service;

import com.hf.domain.Domain.User.UserDO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "DAO")
public interface UserService {

    final String prefix = "/userService";

    @RequestMapping(prefix+"/get")
    UserDO get(@RequestParam("userId")Long userId);

    @RequestMapping(prefix+"/getbyvalue")
    UserDO getbyvalue(@RequestParam("userValue") String userValue);

}
