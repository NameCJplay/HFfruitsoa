package com.hf.dao.Dao;


import java.util.Date;
import java.util.List;
import java.util.Map;

import com.hf.domain.Domain.Fruits.FruitsDO;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface FruitsDao {

	List<FruitsDO> toMaturity(Date date, Integer day);

	FruitsDO get(Long fruitsId);
	
	List<FruitsDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(FruitsDO fruits);
	
	int update(FruitsDO fruits);
	
	int remove(Long fruits_id);
	
	int batchRemove(Long[] fruitsIds);

	List<FruitsDO> getfruits(FruitsDO fruits);
}
