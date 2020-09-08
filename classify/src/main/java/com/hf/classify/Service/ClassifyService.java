package com.hf.classify.Service;
import com.hf.domain.Domain.Classify.ClassifyDO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@FeignClient(value = "DAO")
public interface ClassifyService {

	@GetMapping("/classifyService/get")
	public ClassifyDO get(@RequestParam("classifyId")Long classifyId);

	@PostMapping(value = "/classifyService/list",consumes = "application/json")
	public List<ClassifyDO> list(@RequestBody Map<String, Object> map);

	@RequestMapping("/classifyService/count")
	public int count(@RequestBody Map<String, Object> map);

	@PostMapping("/classifyService/save")
	public int save(@RequestBody ClassifyDO classify);

	@PostMapping("/classifyService/update")
	public int update(@RequestBody ClassifyDO classify);

	@PostMapping("/classifyService/remove")
	public int remove(@RequestParam("classifyId")Long classifyId);

	@PostMapping("/classifyService/batchRemove")
	public int batchRemove(@RequestParam("fruitsIds") Long[] classifyIds);

}
