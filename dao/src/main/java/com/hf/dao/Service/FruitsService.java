package com.hf.dao.Service;

import com.hf.domain.Domain.Fruits.FruitsDO;

import java.util.Date;
import java.util.List;
import java.util.Map;




public interface FruitsService {

	List<FruitsDO> toMaturity(Date date, Integer day);
	
	FruitsDO get(Long fruitsId);
	
	List<FruitsDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(FruitsDO fruits);
	
	int update(FruitsDO fruits);
	
	int remove(Long fruitsId);
	
	int batchRemove(Long[] fruitsIds);
	
	Map<Long,String> getAllMap(Map<String, Object> map);
	
	List<Map<String,Object>> buildSelectOption();

	List<FruitsDO> getfruits(FruitsDO fruits);
}
