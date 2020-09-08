package com.hf.notify.Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.hf.domain.Annatation.MyAuthorize;
import com.hf.domain.Common.FileUtil;
import com.hf.domain.Common.PageUtils;
import com.hf.domain.Common.QueryStruct;
import com.hf.domain.Common.R;
import com.hf.domain.Domain.Notify.NotifyFileDO;
import com.hf.notify.Service.NotifyFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/notifyFile")
public class NotifyFileController {
	@Autowired
	private NotifyFileService notifyFileService;

	//文件存储路径
	@Value("${hf.FileUrl}")
	public String FileUrl;

	@GetMapping("/list")
	@MyAuthorize(Role = {"ROLE_USER","ROLE_ADMIN"})
	public PageUtils list(NotifyFileDO notifyFile, QueryStruct queryStruct) throws IllegalAccessException {
		//查询列表数据
		Map<String,Object> map1= QueryStruct.objectToMap(queryStruct);
		List<NotifyFileDO> notifyFileList = notifyFileService.list(map1);
		int total = notifyFileService.count(map1);
		PageUtils pageUtils = new PageUtils(notifyFileList, total);
		return pageUtils;
	}

	@GetMapping("/getby")
	@MyAuthorize(Role = {"ROLE_USER","ROLE_ADMIN"})
	public List<NotifyFileDO> getby(@RequestParam("fileNotifyId")Long fileNotifyId) throws IllegalAccessException {
		return notifyFileService.getby(fileNotifyId);
	}


	/**
	 * 保存
	 */
	@PostMapping("/save")
	@MyAuthorize(Role = {"ROLE_USER","ROLE_ADMIN"})
	public R save(@RequestParam(required = false,value = "hfFiles") MultipartFile[] hfFiles , NotifyFileDO notifyFile) throws Exception {
		if(hfFiles == null || hfFiles.length<=0 || hfFiles[0].isEmpty() || hfFiles[0].getName()==null )return R.error();
		boolean result = true;
		for (MultipartFile file:hfFiles) {
			String filename = file.getOriginalFilename();
			String uuidfilename = FileUtil.renameToUUID(filename);
			NotifyFileDO notifyFileDO = new NotifyFileDO(null,notifyFile.getFileNotifyId(),FileUrl,uuidfilename,filename);
			if(notifyFileService.save(notifyFileDO)<=0){result = false;}
			FileUtil.uploadFile(file.getBytes(),FileUrl,uuidfilename);
		}
		if(result)return R.ok();
		return R.error();
	}

	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@MyAuthorize(Role = {"ROLE_USER","ROLE_ADMIN"})
	public R remove(Long fileId){
		NotifyFileDO notifyFileDO = notifyFileService.get(fileId);
		if(notifyFileService.remove(fileId)>0){

			return R.ok();
		}
		return R.error();
	}
	



	
}
