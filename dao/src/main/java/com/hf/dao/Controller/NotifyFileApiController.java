package com.hf.dao.Controller;

import java.util.List;
import java.util.Map;

import com.hf.dao.Service.NotifyFileService;
import com.hf.domain.Domain.Notify.NotifyFileDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/notifyFileService")
public class NotifyFileApiController {
	@Autowired
	private NotifyFileService notifyFileService;

	@GetMapping("/get")
	NotifyFileDO get(@RequestParam("fileId") Long fileId){return notifyFileService.get(fileId);};
	@PostMapping(value = "/getby",consumes = "application/json")
	public List<NotifyFileDO> getby(@RequestParam("fileNotifyId") Long fileNotifyId){return notifyFileService.getby(fileNotifyId);};
	@PostMapping(value = "/list",consumes = "application/json")
	public List<NotifyFileDO> list(@RequestBody Map<String,Object> params){return notifyFileService.list(params);}
	@RequestMapping("/count")
	int count(@RequestBody Map<String,Object> map){return notifyFileService.count(map);};
	@PostMapping("/save")
	int save(@RequestBody NotifyFileDO notifyFileDO){return notifyFileService.save(notifyFileDO);};
	@PostMapping("/update")
	int update(@RequestBody NotifyFileDO notifyFileDO){return notifyFileService.update(notifyFileDO);};
	@PostMapping("/remove")
	int remove(@RequestParam("fileId")Long fileId){return notifyFileService.remove(fileId);};
	@PostMapping("/batchRemove")
	int batchRemove(@RequestParam("fileIds")Long[] fileIds){return notifyFileService.batchRemove(fileIds);};


	
}
