package com.hf.dao.Controller;

import com.hf.dao.Service.DeptService;
import com.hf.domain.Domain.Dept.DeptDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/deptService")
public class DeptApiController {
    @Autowired
    DeptService deptService;

    @RequestMapping("/get")
    DeptDO get(@RequestParam("deptId") Long deptId){return deptService.get(deptId);};

    @PostMapping(value = "/list",consumes = "application/json")
    public List<DeptDO> list(@RequestBody Map<String, Object> map){return deptService.list(map);};

    @RequestMapping("/count")
    int count(@RequestBody Map<String, Object> map){return deptService.count(map);};

    @PostMapping("/save")
    int save(@RequestBody DeptDO dept){return deptService.save(dept);};

    @PostMapping("/update")
    int update(@RequestBody DeptDO dept){return deptService.update(dept);};

    @PostMapping("/remove")
    int remove(@RequestParam("deptId")Long deptId){return deptService.remove(deptId);};

    @PostMapping("/batchRemove")
    int batchRemove(@RequestParam("deptIds")Long[] deptIds){return deptService.batchRemove(deptIds);};

    @RequestMapping("/getAllMap")
    Map<Long,String> getAllMap(@RequestBody Map<String, Object> map){return deptService.getAllMap(map);};

    @RequestMapping("/buildSelectOption")
    List<Map<String,Object>> buildSelectOption(){return deptService.buildSelectOption();};


}
