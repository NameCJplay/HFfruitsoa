package com.hf.dao.Service.impl;

import com.hf.dao.Dao.NotifyFileDao;
import com.hf.dao.Service.NotifyFileService;
import com.hf.domain.Domain.Notify.NotifyFileDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;




@Service
public class NotifyFileServiceImpl implements NotifyFileService {
	@Autowired
	private NotifyFileDao notifyFileDao;
	
	@Override
	public NotifyFileDO get(Long fileId){
		return notifyFileDao.get(fileId);
	}

	@Override
	public List<NotifyFileDO> getby(Long fileNotifyId) { return notifyFileDao.getby(fileNotifyId); }

	@Override
	public List<NotifyFileDO> list(Map<String, Object> map){
		return notifyFileDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return notifyFileDao.count(map);
	}
	
	@Override
	public int save(NotifyFileDO notifyFile){
		return notifyFileDao.save(notifyFile);
	}
	
	@Override
	public int update(NotifyFileDO notifyFile){
		return notifyFileDao.update(notifyFile);
	}
	
	@Override
	public int remove(Long fileId){
		return notifyFileDao.remove(fileId);
	}
	
	@Override
	public int batchRemove(Long[] fileIds){
		return notifyFileDao.batchRemove(fileIds);
	}

}
