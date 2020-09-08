package com.hf.dao.Controller;

import com.hf.dao.Service.ClassifyService;
import com.hf.domain.Domain.Classify.ClassifyDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/classifyService")
public class ClassifyApiController {
	@Autowired
	private ClassifyService classifyService;

	@GetMapping("/get")
	ClassifyDO get(@RequestParam("classifyId")Long classifyId){return classifyService.get(classifyId);};

	@PostMapping(value = "/list",consumes = "application/json")
	List<ClassifyDO> list(@RequestBody Map<String, Object> map){return classifyService.list(map);};

	@RequestMapping("/count")
	int count(@RequestBody Map<String, Object> map){return classifyService.count(map);};
	@PostMapping("/save")
	int save(@RequestBody ClassifyDO classify){return classifyService.save(classify);};
	@PostMapping("/update")
	int update(@RequestBody ClassifyDO classify){return classifyService.update(classify);};
	@PostMapping("/remove")
	int remove(@RequestParam("classifyId")Long classifyId){return classifyService.remove(classifyId);};
	@PostMapping("/batchRemove")
	int batchRemove(@RequestParam("fruitsIds") Long[] classifyIds){return classifyService.batchRemove(classifyIds);}

	//通过父id获取子类.为空即获取所有子类
	@RequestMapping("/getChildren")
	List<ClassifyDO> getChildren(@RequestParam("parentid") Integer parentid){
		return classifyService.getChildren(parentid);
	}

}
