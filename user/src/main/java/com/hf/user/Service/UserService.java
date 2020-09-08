package com.hf.user.Service;

import com.hf.domain.Domain.Dept.DeptDO;
import com.hf.domain.Domain.User.UserDO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


@FeignClient(value = "DAO")
public interface UserService {

	final String prefix = "/userService";
	final String prefix2 = "/deptService";

	@RequestMapping(prefix + "/get")
	UserDO get(@RequestParam("userId")Long userId);

	@PostMapping(value = prefix + "/list",consumes = "application/json")
	List<UserDO> list(@RequestBody Map<String, Object> map);

	@RequestMapping(prefix + "/count")
	int count(@RequestBody Map<String, Object> map);

	@PostMapping(prefix + "/save")
	int save(@RequestBody UserDO user);

	@PostMapping(prefix + "/update")
	int update(@RequestBody UserDO user);

	@PostMapping(prefix + "/remove")
	int remove(@RequestParam("userId")Long userId);

	@PostMapping(prefix + "/batchRemove")
	int batchRemove(@RequestParam("userIds")Long[] userIds);

	@RequestMapping(prefix2 + "/get")
	public DeptDO getdept(@RequestParam("deptId") Long deptId);

	@PostMapping(value = prefix2 +"/list",consumes = "application/json")
	public List<DeptDO> getdeptlist(@RequestBody Map<String, Object> map);

	@PostMapping(prefix +"/getAllMap")
	Map<Long,String> getAllMap(@RequestBody Map<String, Object> map);

	@PostMapping(prefix +"/buildSelectOption")
	List<Map<String,Object>> buildSelectOption();

	@PostMapping(prefix +"/login")
	public UserDO login(@RequestParam("userValue")String userValue,@RequestParam("userPwd")String userPwd);


}
