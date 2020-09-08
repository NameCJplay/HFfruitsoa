package com.hf.dao.Service.impl;

import com.hf.dao.Service.FruitsService;
import com.hf.domain.Domain.Fruits.FruitsDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.hf.dao.Dao.FruitsDao;


@Service
public class FruitsServiceImpl implements FruitsService {
	@Autowired
	private FruitsDao fruitsDao;

	@Override
	public List<FruitsDO> toMaturity(Date date, Integer day) {
		return fruitsDao.toMaturity(date,day);
	}

	@Override
	public FruitsDO get(Long fruitsId){
		return fruitsDao.get(fruitsId);
	}
	
	@Override
	public List<FruitsDO> list(Map<String, Object> map){
		return fruitsDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return fruitsDao.count(map);
	}
	
	@Override
	public int save(FruitsDO fruits){
		return fruitsDao.save(fruits);
	}
	
	@Override
	public int update(FruitsDO fruits){
		return fruitsDao.update(fruits);
	}
	
	@Override
	public int remove(Long fruitsId){
		return fruitsDao.remove(fruitsId);
	}
	
	@Override
	public int batchRemove(Long[] fruitsIds){
		return fruitsDao.batchRemove(fruitsIds);
	}
	
	
		
	@Override
	public Map<Long,String> getAllMap(Map<String, Object> map){
		List<FruitsDO> typeList=list(map);
		Map<Long,String> rest=new HashMap<>();
		for(FruitsDO one:typeList) {
			rest.put(one.getFruitsId(), one.getFruitsName());
		}
		return rest;
	}
	
	
	@Override
	public List<Map<String,Object>> buildSelectOption(){
		
		
		Map<String, Object> paraMap=new HashMap<>();
		paraMap.put("sort", "name");
		paraMap.put("order", "desc");
		
		List<FruitsDO> typeList=list(paraMap);
		
		List<Map<String,Object>> li = new LinkedList<>();
		
		for(FruitsDO em:typeList) {
	         Map<String,Object> one=new HashMap<>();
	         one.put("name", String.valueOf(em.getFruitsId()));
	         one.put("value",em.getFruitsName());
	         li.add(one);
		}

		return li;
	}

	@Override
	public List<FruitsDO> getfruits(FruitsDO fruits) {
		return fruitsDao.getfruits(fruits);
	}

}
