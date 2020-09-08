package com.hf.dao.Service.impl;

import com.hf.dao.Dao.NotifyDao;
import com.hf.dao.Service.NotifyService;
import com.hf.domain.Domain.Notify.NotifyDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Service
public class NotifyServiceImpl implements NotifyService {
	@Autowired
	private NotifyDao notifyDao;
	
	@Override
	public NotifyDO get(Long notifyId){
		return notifyDao.get(notifyId);
	}
	
	@Override
	public List<NotifyDO> list(Map<String, Object> map){
		return notifyDao.list(map);
	}

	@Override
	public List<NotifyDO> toDayList() {
		return notifyDao.toDayList();
	}

	@Override
	public int count(Map<String, Object> map){
		return notifyDao.count(map);
	}
	
	@Override
	public int save(NotifyDO notify){
		return notifyDao.save(notify);
	}
	
	@Override
	public int update(NotifyDO notify){
		return notifyDao.update(notify);
	}
	
	@Override
	public int remove(Long notifyId){
		return notifyDao.remove(notifyId);
	}
	
	@Override
	public int batchRemove(Long[] notifyIds){
		return notifyDao.batchRemove(notifyIds);
	}
	

}
