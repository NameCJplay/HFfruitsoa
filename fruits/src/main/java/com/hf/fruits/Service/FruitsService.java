package com.hf.fruits.Service;

import com.hf.domain.Domain.Classify.ClassifyDO;
import com.hf.domain.Domain.Fruits.FruitsDO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@FeignClient(value = "DAO")
public interface FruitsService {

	final String prefix = "/fruitsService";

	//通过classid或hot查询
	@RequestMapping(prefix+"/GetFruits")
	public List<FruitsDO> GetFruClassfiy(@RequestBody FruitsDO fruits);
	//查列表
	@PostMapping(value = prefix+"/list",consumes = "application/json")
	public List<FruitsDO> Getlist(@RequestBody Map<String,Object> params);
	//查数量
	@RequestMapping(prefix+"/count")
	public Integer Getcount(@RequestBody Map<String,Object> params);
	//通过id获取对象
	@RequestMapping(prefix+"/get")
	public FruitsDO get(@RequestParam("fruitsId")Long fruitsId);
	// 删除
	@PostMapping(prefix+"/remove")
	public Integer remove(@RequestParam("fruitsId")Long fruitsId);
	//保存
	@PostMapping(prefix+"/save")
	public Integer save(@RequestBody FruitsDO fruits);
	//修改
	@PostMapping(prefix+"/update")
	public Integer update(@RequestBody FruitsDO fruits);
	//批量删除
	@PostMapping(prefix+"/batchRemove")
	public Integer batchremove(@RequestParam("fruitsIds") Long[] fruitsIds);
	//获得分类名
	@RequestMapping("/classifyService/getChildren")
	List<ClassifyDO> getChildren(@RequestParam("parentid") Integer parentid);
	//即将过期
	@PostMapping(value = prefix+"/toMaturity")
	public List<FruitsDO> toMaturity(@RequestParam("date") Date date, @RequestParam("day") Integer day);


}
