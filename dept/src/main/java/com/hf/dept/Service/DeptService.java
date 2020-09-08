package com.hf.dept.Service;

import com.hf.domain.Domain.Dept.DeptDO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@FeignClient(value = "DAO")
public interface DeptService {
	String prefix = "/deptService";

	@RequestMapping(prefix+"/get")
	DeptDO get(@RequestParam("deptId") Long deptId);

	@PostMapping(value = prefix+"/list",consumes = "application/json")
	public List<DeptDO> list(@RequestBody Map<String, Object> map);

	@RequestMapping(prefix+"/count")
	int count(@RequestBody Map<String, Object> map);

	@PostMapping(prefix+"/save")
	int save(@RequestBody DeptDO dept);

	@PostMapping(prefix+"/update")
	int update(@RequestBody DeptDO dept);

	@PostMapping(prefix+"/remove")
	int remove(@RequestParam("deptId")Long deptId);

	@PostMapping(prefix+"/batchRemove")
	int batchRemove(@RequestParam("deptIds")Long[] deptIds);

	@RequestMapping(prefix+"/getAllMap")
	Map<Long,String> getAllMap(@RequestBody Map<String, Object> map);

	@RequestMapping(prefix+"/buildSelectOption")
	List<Map<String,Object>> buildSelectOption();

}
