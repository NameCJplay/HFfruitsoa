package com.hf.dao.Service;


import com.hf.domain.Domain.Notify.NotifyFileDO;

import java.util.List;
import java.util.Map;




public interface NotifyFileService {

	NotifyFileDO get(Long fileId);

	List<NotifyFileDO> getby(Long fileNotifyId);
	
	List<NotifyFileDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(NotifyFileDO notifyFile);
	
	int update(NotifyFileDO notifyFile);
	
	int remove(Long fileId);
	
	int batchRemove(Long[] fileIds);
}
