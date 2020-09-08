package com.hf.dao.Service.impl;

import com.hf.dao.Dao.UserDao;
import com.hf.dao.Service.UserService;
import com.hf.domain.Domain.User.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;




@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDO get(Long userId){
		return userDao.get(userId);
	}
	
	@Override
	public List<UserDO> list(Map<String, Object> map){
		return userDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return userDao.count(map);
	}
	
	@Override
	public int save(UserDO user){
		return userDao.save(user);
	}
	
	@Override
	public int update(UserDO user){
		return userDao.update(user);
	}
	
	@Override
	public int remove(Long userId){
		return userDao.remove(userId);
	}
	
	@Override
	public int batchRemove(Long[] userIds){
		return userDao.batchRemove(userIds);
	}

	@Override
	public UserDO login(String userValue,String userPwd) {
		return userDao.login(userValue,userPwd);
	}

	@Override
	public UserDO getbyvalue(String userValue) {
		return userDao.getbyvalue(userValue);
	};
		
	@Override
	public Map<Long,String> getAllMap(Map<String, Object> map){
		List<UserDO> typeList=list(map);
		Map<Long,String> rest=new HashMap<>();
		for(UserDO one:typeList) {
			rest.put(one.getUserId(), one.getUserName());
		}
		return rest;
	}


	@Override
	public List<Map<String,Object>> buildSelectOption(){


		Map<String, Object> paraMap=new HashMap<>();
		paraMap.put("sort", "name");
		paraMap.put("order", "desc");

		List<UserDO> typeList=list(paraMap);

		List<Map<String,Object>> li = new LinkedList<>();

		for(UserDO em:typeList) {
	         Map<String,Object> one=new HashMap<>();
	         one.put("name", String.valueOf(em.getUserId()));
	         one.put("value",em.getUserName());
	         li.add(one);
		}

		return li;
	}



}
