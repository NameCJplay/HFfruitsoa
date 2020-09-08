package com.hf.dao.Service.impl;

import com.hf.dao.Dao.DeptDao;
import com.hf.dao.Service.DeptService;
import com.hf.domain.Domain.Dept.DeptDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;



@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptDao deptDao;
	
	@Override
	public DeptDO get(Long deptId){
		return deptDao.get(deptId);
	}
	
	@Override
	public List<DeptDO> list(Map<String, Object> map){
		return deptDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return deptDao.count(map);
	}
	
	@Override
	public int save(DeptDO dept){
		return deptDao.save(dept);
	}
	
	@Override
	public int update(DeptDO dept){
		return deptDao.update(dept);
	}
	
	@Override
	public int remove(Long deptId){
		return deptDao.remove(deptId);
	}
	
	@Override
	public int batchRemove(Long[] deptIds){
		return deptDao.batchRemove(deptIds);
	}
	
	
		
	@Override
	public Map<Long,String> getAllMap(Map<String, Object> map){
		List<DeptDO> typeList=list(map);
		Map<Long,String> rest=new HashMap<>();
		for(DeptDO one:typeList) {
			rest.put(one.getDeptId(), one.getDeptName());
		}
		return rest;
	}
	
	
	@Override
	public List<Map<String,Object>> buildSelectOption(){
		
		
		Map<String, Object> paraMap=new HashMap<>();
		paraMap.put("sort", "name");
		paraMap.put("order", "desc");
		
		List<DeptDO> typeList=list(paraMap);
		
		List<Map<String,Object>> li = new LinkedList<>();
		
		for(DeptDO em:typeList) {
	         Map<String,Object> one=new HashMap<>();
	         one.put("name", String.valueOf(em.getDeptId()));
	         one.put("value",em.getDeptName());
	         li.add(one);
		}

		return li;
	}
	
}
