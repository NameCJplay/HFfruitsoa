package com.hf.dao.Service;

import com.hf.domain.Domain.Dept.DeptDO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;


public interface DeptService {
	
	DeptDO get(Long deptId);

	List<DeptDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(DeptDO dept);

	int update(DeptDO dept);

	int remove(Long deptId);

	int batchRemove(Long[] deptIds);

	Map<Long,String> getAllMap(Map<String, Object> map);

	List<Map<String,Object>> buildSelectOption();
}
