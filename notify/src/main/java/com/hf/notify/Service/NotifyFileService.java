package com.hf.notify.Service;

import com.hf.domain.Domain.Notify.NotifyFileDO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@FeignClient(value = "DAO")
public interface NotifyFileService {

	final String prefix = "/notifyFileService";

	@GetMapping(prefix+"/get")
	NotifyFileDO get(@RequestParam("fileId") Long fileId);
	@PostMapping(value = prefix+"/getby",consumes = "application/json")
	public List<NotifyFileDO> getby(@RequestParam("fileNotifyId") Long fileNotifyId);
	@PostMapping(value = prefix+"/list",consumes = "application/json")
	public List<NotifyFileDO> list(@RequestBody Map<String,Object> params);
	@RequestMapping(prefix+"/count")
	int count(@RequestBody Map<String,Object> map);
	@PostMapping(prefix+"/save")
	int save(@RequestBody NotifyFileDO notifyFileDO);
	@PostMapping(prefix+"/update")
	int update(@RequestBody NotifyFileDO notifyFileDO);
	@PostMapping(prefix+"/remove")
	int remove(@RequestParam("fileId")Long fileId);
	@PostMapping(prefix+"/batchRemove")
	int batchRemove(@RequestParam("fileIds")Long[] fileIds);

}
