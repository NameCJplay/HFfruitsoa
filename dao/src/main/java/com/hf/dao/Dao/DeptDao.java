package com.hf.dao.Dao;


import java.util.List;
import java.util.Map;

import com.hf.domain.Domain.Dept.DeptDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptDao {

	DeptDO get(Long deptId);
	
	List<DeptDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(DeptDO dept);
	
	int update(DeptDO dept);
	
	int remove(Long dept_id);
	
	int batchRemove(Long[] deptIds);
}
