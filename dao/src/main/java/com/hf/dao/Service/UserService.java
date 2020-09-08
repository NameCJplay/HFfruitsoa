package com.hf.dao.Service;

import com.hf.domain.Domain.User.UserDO;

import java.util.List;
import java.util.Map;



public interface UserService {
	
	UserDO get(Long userId);
	
	List<UserDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UserDO user);
	
	int update(UserDO user);
	
	int remove(Long userId);
	
	int batchRemove(Long[] userIds);
	
	Map<Long,String> getAllMap(Map<String, Object> map);
	
	List<Map<String,Object>> buildSelectOption();

	UserDO login(String userValue,String userPwd);

	UserDO getbyvalue(String userValue);
}
