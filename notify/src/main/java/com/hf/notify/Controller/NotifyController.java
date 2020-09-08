package com.hf.notify.Controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.hf.domain.Annatation.MyAuthorize;
import com.hf.domain.Common.FileUtil;
import com.hf.domain.Common.PageUtils;
import com.hf.domain.Common.QueryStruct;
import com.hf.domain.Common.R;
import com.hf.domain.Domain.Dept.DeptDO;
import com.hf.domain.Domain.Notify.NotifyDO;
import com.hf.domain.Domain.Notify.NotifyDOExample;
import com.hf.domain.Domain.Notify.NotifyFileDO;
import com.hf.domain.Domain.User.UserDO;
import com.hf.notify.Service.NotifyFileService;
import com.hf.notify.Service.NotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/notify")
public class NotifyController {
	@Autowired
	private NotifyService notifyService;
	@Autowired
	private NotifyFileService notifyFileService;

	@GetMapping("/list")
	@MyAuthorize(Role = {"ROLE_USER","ROLE_ADMIN"})
	public PageUtils list(NotifyDO notify, QueryStruct queryStruct) throws IllegalAccessException {
		//查询列表数据
		Map<String,Object> map= QueryStruct.objectToMap(queryStruct);
		List<NotifyDO> notifyList = notifyService.list(map);
		List<UserDO> userList = notifyService.getuserlist(new HashMap());
		Map<Long, String> usermap = userList.stream().collect(Collectors.toMap(UserDO::getUserId, UserDO::getUserName));
		for (NotifyDO list:notifyList) {
			list.setNotifyUserName(usermap.get(list.getNotifyUserId()));
		}
		int total = notifyService.count(map);
		PageUtils pageUtils = new PageUtils(notifyList, total);
		return pageUtils;
	}

	//进入修改页面
	@RequestMapping(value = "/edit")
	@MyAuthorize(Role = {"ROLE_USER","ROLE_ADMIN"})
	public NotifyDO edit(@RequestParam("notifyId")Integer notifyId,Model model){
		NotifyDO dept = notifyService.get((long)notifyId);
		return dept;
	}
	/**
	 * 保存
	 */
	@PostMapping("/save")
	@MyAuthorize(Role = {"ROLE_USER","ROLE_ADMIN"})
	public R save(NotifyDO notify){
		notify.setNotifyUserId(new Integer((Integer) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).longValue());
		notify.setNotifyCreateDate(new Date());
		notify.setNotifyUpdateDate(new Date());
		if(notifyService.save(notify)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@PostMapping("/update")
	@MyAuthorize(Role = {"ROLE_ADMIN"})
	public R update(NotifyDO notify){
		notify.setNotifyUpdateDate(new Date());
		if(notifyService.update(notify)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@MyAuthorize(Role = {"ROLE_ADMIN"})
	public R remove(Long notifyId){
		Map<String,Object> map1= new HashMap<>();
		map1.put("fileNotifyId",notifyId);
		List<NotifyFileDO> list = notifyFileService.list(map1);
		for (NotifyFileDO lis:list) {
			if(notifyFileService.remove(lis.getFileId())<=0 || !FileUtil.deleteFile(lis.getFilePath()+lis.getFileFilename())){
				return R.error();
			}
		}
		if(notifyService.remove(notifyId)<=0)return R.error();
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@MyAuthorize(Role = {"ROLE_ADMIN"})
	public R remove(@RequestParam("ids[]") Long[] notifyIds){
		Map<String,Object> map1= new HashMap<>();
		for (int i=0;i<notifyIds.length;i++){
			map1.put("fileNotifyId",notifyIds[i]);
			List<NotifyFileDO> list = notifyFileService.list(map1);
			for (NotifyFileDO lis:list) {
				if(notifyFileService.remove(lis.getFileId())<=0 || !FileUtil.deleteFile(lis.getFilePath()+lis.getFileFilename())){
					return R.error();
				}
			}
			map1.clear();
		}
		if(notifyService.batchRemove(notifyIds)<=0){
			return R.error();
		}
		return R.ok();
	}


	
}
