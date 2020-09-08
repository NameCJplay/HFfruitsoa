package com.hf.dao.Controller;

import java.util.List;
import java.util.Map;

import com.hf.dao.Service.NotifyService;
import com.hf.domain.Domain.Notify.NotifyDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;




 
@RestController
@RequestMapping("/notifyService")
public class NotifyApiController {
	@Autowired
	private NotifyService notifyService;

	@GetMapping("/get")
	NotifyDO get(@RequestParam("ordersId") Long notifyId){return notifyService.get(notifyId);};
	@PostMapping(value = "/list",consumes = "application/json")
	public List<NotifyDO> list(@RequestBody Map<String,Object> params){return notifyService.list(params);}
	@RequestMapping("/count")
	int count(@RequestBody Map<String,Object> map){return notifyService.count(map);};
	@PostMapping("/save")
	int save(@RequestBody NotifyDO notifyDO){return notifyService.save(notifyDO);};
	@PostMapping("/update")
	int update(@RequestBody NotifyDO notifyDO){return notifyService.update(notifyDO);};
	@PostMapping("/remove")
	int remove(@RequestParam("ordersId")Long notifyId){return notifyService.remove(notifyId);};
	@PostMapping("/batchRemove")
	int batchRemove(@RequestParam("ordersIds")Long[] notifyIds){return notifyService.batchRemove(notifyIds);};
	@PostMapping("/toDayList")
	public List<NotifyDO> toDayList(){return notifyService.toDayList();}
	
}
