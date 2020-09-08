package com.hf.dao.Dao;


import java.util.List;
import java.util.Map;

import com.hf.domain.Domain.Notify.NotifyDO;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface NotifyDao {

	NotifyDO get(Long notifyId);
	
	List<NotifyDO> list(Map<String,Object> map);

	List<NotifyDO> toDayList();

	int count(Map<String,Object> map);
	
	int save(NotifyDO notify);
	
	int update(NotifyDO notify);
	
	int remove(Long notify_id);
	
	int batchRemove(Long[] notifyIds);
}
