package com.hf.dao.Controller;

import com.hf.dao.Service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/redisService")
public class RedisApiController {

    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "/get",produces="text/json")
    public Object get(@RequestParam("key") String key){return redisService.get(key); }

    @RequestMapping("/hasKey")
    public boolean hasKey(@RequestParam("key") String key){
        return redisService.hasKey(key);
    }

    @RequestMapping("/set")
    public boolean set(@RequestParam("key") String key,@RequestParam("value") Object value,@RequestParam("time") long time){ return redisService.set(key,value,time); }

    @RequestMapping("/hmget")
    public Map<Object, Object> hmget(@RequestParam("key") String key){return redisService.hmget(key); }

    @RequestMapping("/hmset")
    public boolean hmset(@RequestParam("key") String key, @RequestBody Map<String, Object> map, @RequestParam("time") long time){ return redisService.hmset(key,map,time); }



}
