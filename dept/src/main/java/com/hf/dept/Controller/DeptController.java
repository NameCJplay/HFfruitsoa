package com.hf.dept.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hf.dept.Service.DeptService;
import com.hf.domain.Annatation.MyAuthorize;
import com.hf.domain.Common.R;
import com.hf.domain.Domain.Dept.DeptDO;
import com.hf.domain.Domain.Dept.DeptDOExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/dept")
public class DeptController {
	@Autowired
	private DeptService deptService;

	@MyAuthorize(Role = {"ROLE_USER","ROLE_ADMIN"})
	@GetMapping("/list")
	public List<DeptDO> list(@RequestParam Map<String, Object> params){
		return deptService.list(params);
	}

	//进入修改页面
	@MyAuthorize(Role = {"ROLE_ADMIN"})
	@GetMapping("/edit")
	public DeptDOExample edit(@RequestParam("deptId")Integer deptId, Model model){
		DeptDO dept = deptService.get((long)deptId);
		DeptDOExample deptDOExample = new DeptDOExample(dept);
		deptDOExample.setDeptlist(deptService.list(new HashMap<>()));
	    return deptDOExample;
	}
	
	/**
	 * 保存
	 */
	@MyAuthorize(Role = {"ROLE_ADMIN"})
	@RequestMapping(value = "/save",consumes = "application/x-www-form-urlencoded",method = RequestMethod.POST)
	public R save(DeptDO dept){
		if(deptService.save(dept)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@MyAuthorize(Role = {"ROLE_ADMIN"})
	@PostMapping("/update")
	public R update(DeptDO dept){
		deptService.update(dept);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@MyAuthorize(Role = {"ROLE_ADMIN"})
	@PostMapping( "/remove")
	public R remove( Long deptId){
		if(deptService.remove(deptId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 批量删除
	 */
	@MyAuthorize(Role = {"ROLE_ADMIN"})
	@PostMapping( "/batchRemove")
	public R remove(@RequestParam("ids[]") Long[] deptIds){
		deptService.batchRemove(deptIds);
		return R.ok();
	}
	


	
}
