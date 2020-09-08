package com.hf.notify.Service;

import com.hf.domain.Domain.Notify.NotifyDO;
import com.hf.domain.Domain.User.UserDO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(value = "DAO")
public interface NotifyService {
	final String prefix = "/notifyService";
	final String prefix2 = "/userService";

	@GetMapping(prefix+"/get")
	NotifyDO get(@RequestParam("ordersId") Long notifyId);
	@PostMapping(value = prefix+"/list", consumes = "application/json")
	public List<NotifyDO> list(@RequestBody Map<String,Object> params);
	@RequestMapping(prefix+"/count")
	int count(@RequestBody Map<String,Object> map);
	@PostMapping(prefix+"/save")
	int save(@RequestBody NotifyDO notifyDO);
	@PostMapping(prefix+"/update")
	int update(@RequestBody NotifyDO notifyDO);
	@PostMapping(prefix+"/remove")
	int remove(@RequestParam("ordersId")Long notifyId);
	@PostMapping(prefix+"/batchRemove")
	int batchRemove(@RequestParam("ordersIds")Long[] notifyIds);
	@PostMapping(prefix+"/toDayList")
	public List<NotifyDO> toDayList();

	@PostMapping(value = prefix2 + "/list",consumes = "application/json")
	public List<UserDO> getuserlist(@RequestBody Map<String, Object> map);
}
