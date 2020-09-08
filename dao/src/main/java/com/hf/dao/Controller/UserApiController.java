package com.hf.dao.Controller;

import com.hf.dao.Service.UserService;
import com.hf.domain.Domain.User.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/userService")
public class UserApiController {
    @Autowired
    UserService userService;

    @RequestMapping("/get")
    UserDO get(@RequestParam("userId")Long userId) {return userService.get(userId); }

    @PostMapping(value = "/list",consumes = "application/json")
    List<UserDO> list(@RequestBody Map<String, Object> map){ return userService.list(map);};

    @RequestMapping("/count")
    int count(@RequestBody Map<String, Object> map){return userService.count(map);};

    @PostMapping("/save")
    public int save(@RequestBody UserDO user){return userService.save(user);};

    @PostMapping("/update")
    int update(@RequestBody UserDO user){return userService.update(user);};

    @PostMapping( "/remove")
    int remove(@RequestParam("userId")Long userId){return userService.remove(userId);};

    @PostMapping( "/batchRemove")
    int batchRemove(@RequestParam("userIds")Long[] userIds){return userService.batchRemove(userIds);};

    @PostMapping("/getAllMap")
    Map<Long,String> getAllMap(@RequestBody Map<String, Object> map){return userService.getAllMap(map);};

    @PostMapping("/buildSelectOption")
    List<Map<String,Object>> buildSelectOption(){return userService.buildSelectOption();};

    @PostMapping("/login")
    public UserDO login(@RequestParam("userValue")String userValue,@RequestParam("userPwd")String userPwd) {
        return userService.login(userValue,userPwd);}

    @GetMapping("/getbyvalue")
    public UserDO getbyvalue(@RequestParam("userValue") String userValue) {
        return userService.getbyvalue(userValue);
    };
}
