package com.hf.dao.Service;


import com.hf.domain.Domain.Classify.ClassifyDO;

import java.util.List;
import java.util.Map;



public interface ClassifyService {
	
	ClassifyDO get(Long classifyId);
	
	List<ClassifyDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ClassifyDO classify);
	
	int update(ClassifyDO classify);
	
	int remove(Long classifyId);
	
	int batchRemove(Long[] classifyIds);
	
	Map<Long,String> getAllMap(Map<String, Object> map);
	
	List<Map<String,Object>> buildSelectOption();

	List<ClassifyDO> getChildren(Integer parentid);
}
