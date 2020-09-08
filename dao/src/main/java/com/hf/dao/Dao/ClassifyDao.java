package com.hf.dao.Dao;

import com.hf.domain.Domain.Classify.ClassifyDO;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;
import java.util.Map;




@Mapper
public interface ClassifyDao {

	ClassifyDO get(Long classifyId);

	List<ClassifyDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(ClassifyDO classify);
	
	int update(ClassifyDO classify);
	
	int remove(Long classify_id);
	
	int batchRemove(Long[] classifyIds);

	List<ClassifyDO> getChildren(Integer parentid);

}
