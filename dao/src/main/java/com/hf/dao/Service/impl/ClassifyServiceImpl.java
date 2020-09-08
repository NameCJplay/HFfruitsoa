package com.hf.dao.Service.impl;

import com.hf.domain.Domain.Classify.ClassifyDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.hf.dao.Dao.ClassifyDao;
import com.hf.dao.Service.ClassifyService;



@Service
public class ClassifyServiceImpl implements ClassifyService{
	@Autowired
	private ClassifyDao classifyDao;

	@Override
	public ClassifyDO get(Long classifyId){
		return classifyDao.get(classifyId);
	}

	@Override
	public List<ClassifyDO> list(Map<String, Object> map){
		return classifyDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return classifyDao.count(map);
	}
	
	@Override
	public int save(ClassifyDO classify){
		return classifyDao.save(classify);
	}
	
	@Override
	public int update(ClassifyDO classify){
		return classifyDao.update(classify);
	}
	
	@Override
	public int remove(Long classifyId){
		return classifyDao.remove(classifyId);
	}
	
	@Override
	public int batchRemove(Long[] classifyIds){
		return classifyDao.batchRemove(classifyIds);
	}
	
	
		
	@Override
	public Map<Long,String> getAllMap(Map<String, Object> map){
		List<ClassifyDO> typeList=list(map);
		Map<Long,String> rest=new HashMap<>();
		for(ClassifyDO one:typeList) {
			rest.put(one.getClassifyId(), one.getClassifyName());
		}
		return rest;
	}
	
	
	@Override
	public List<Map<String,Object>> buildSelectOption(){
		
		
		Map<String, Object> paraMap=new HashMap<>();
		paraMap.put("sort", "name");
		paraMap.put("order", "desc");
		List<ClassifyDO> typeList=list(paraMap);
		List<Map<String,Object>> li = new LinkedList<>();
		for(ClassifyDO em:typeList) {
	         Map<String,Object> one=new HashMap<>();
	         one.put("name", String.valueOf(em.getClassifyId()));
	         one.put("value",em.getClassifyName());
	         li.add(one);
		}
		return li;
	}

	@Override
	public List<ClassifyDO> getChildren(Integer parentid) {
		return classifyDao.getChildren(parentid);
	}
}
