package com.hf.zuul.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "DAO")
public interface RedisService {

    final String prefix = "/redisService";

    @RequestMapping(prefix+"/get")
    Object get(@RequestParam("key") String key);

    @RequestMapping(prefix+"/hasKey")
    boolean hasKey(@RequestParam("key") String key);

    @RequestMapping(prefix+"/set")
    boolean set(@RequestParam("key") String key,@RequestParam("value") Object value,@RequestParam("time") long time);
}
