package com.hf.dao.Dao;


import java.util.List;
import java.util.Map;

import com.hf.domain.Domain.Notify.NotifyFileDO;
import org.apache.ibatis.annotations.Mapper;




@Mapper
public interface NotifyFileDao {

	NotifyFileDO get(Long fileId);

	List<NotifyFileDO> getby(Long fileNotifyId);
	
	List<NotifyFileDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(NotifyFileDO notifyFile);
	
	int update(NotifyFileDO notifyFile);
	
	int remove(Long file_id);
	
	int batchRemove(Long[] fileIds);
}
