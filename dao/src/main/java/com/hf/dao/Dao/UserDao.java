package com.hf.dao.Dao;


import java.util.List;
import java.util.Map;

import com.hf.domain.Domain.User.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface UserDao {

	UserDO get(Long userId);
	
	List<UserDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(UserDO user);
	
	int update(UserDO user);
	
	int remove(Long user_id);
	
	int batchRemove(Long[] userIds);

	UserDO login(String userValue,String userPwd);

	UserDO getbyvalue(String userValue);
}
