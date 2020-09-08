package com.hf.dao.Controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.hf.dao.Service.FruitsService;
import com.hf.domain.Common.Query;
import com.hf.domain.Domain.Fruits.FruitsDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;





@RestController
@RequestMapping("/fruitsService")
public class FruitsApiController {
	@Autowired
	private FruitsService fruitsService;

	// 热销
	@RequestMapping("/GetFruits")
	public List<FruitsDO> GetFruits(@RequestBody FruitsDO fruits){
		return fruitsService.getfruits(fruits);
	}
	//列表查所有
	@PostMapping(value = "/list",consumes = "application/json")
	public List<FruitsDO> list(@RequestBody Map<String,Object> params){return fruitsService.list(params);}
	//条数
	@RequestMapping("/count")
	public Integer count(@RequestBody Map<String,Object> params){return fruitsService.count(new Query(params));}
	//通过id获取对象
	@GetMapping("/get")
	public FruitsDO edit(@RequestParam("fruitsId") Long fruitsId){return fruitsService.get(fruitsId);}
	// 删除
	@PostMapping("/remove")
	public Integer remove(@RequestParam("fruitsId")Long fruitsId){return fruitsService.remove(fruitsId);}
	//保存
	@PostMapping("/save")
	public Integer save(@RequestBody FruitsDO fruits){return fruitsService.save(fruits);}
	//修改
	@PostMapping("/update")
	public Integer update(@RequestBody FruitsDO fruits){return fruitsService.update(fruits);}
	//批量删除
	@PostMapping("/batchRemove")
	public Integer batchremove(@RequestParam("fruitsIds") Long[] fruitsIds){return fruitsService.batchRemove(fruitsIds);}
	//即将过期
	@PostMapping(value = "/toMaturity")
	public List<FruitsDO> toMaturity(@RequestParam("date") Date date,@RequestParam("day") Integer day){return fruitsService.toMaturity(date,day);}

	
}
