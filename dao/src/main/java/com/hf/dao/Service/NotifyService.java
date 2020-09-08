package com.hf.dao.Service;

import com.hf.domain.Domain.Notify.NotifyDO;

import java.util.List;
import java.util.Map;



public interface NotifyService {
	
	NotifyDO get(Long notifyId);
	
	List<NotifyDO> list(Map<String, Object> map);

	List<NotifyDO> toDayList();

	int count(Map<String, Object> map);
	
	int save(NotifyDO notify);
	
	int update(NotifyDO notify);
	
	int remove(Long notifyId);
	
	int batchRemove(Long[] notifyIds);
	
}
