package com.hf.classify.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hf.classify.Service.ClassifyService;
import com.hf.domain.Annatation.MyAuthorize;
import com.hf.domain.Common.R;
import com.hf.domain.Domain.Classify.ClassifyDO;
import com.hf.domain.Domain.Classify.ClassifyDOExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/classify")
public class ClassifyController {
	@Autowired
	private ClassifyService classifyService;

	@MyAuthorize(Role = {"ROLE_USER","ROLE_ADMIN"})
	@GetMapping("/list")
	public List<ClassifyDO> list(@RequestParam Map<String, Object> params){
		return classifyService.list(params);
	}

	@MyAuthorize(Role = {"ROLE_ADMIN"})
	@RequestMapping(value = "/edit")
	public ClassifyDOExample edit(@RequestParam("classifyId")Integer classifyId, Model model){
		ClassifyDO classify = classifyService.get((long)classifyId);
		ClassifyDOExample list =  new ClassifyDOExample(classify);
		list.setClasslist(classifyService.list(new HashMap()));
	    return list;
	}
	
	/**
	 * 保存
	 */
	@MyAuthorize(Role = {"ROLE_ADMIN"})
	@RequestMapping(value = "/save",consumes = "application/x-www-form-urlencoded",method = RequestMethod.POST)
	public R save( ClassifyDO classify){
		//System.out.println(classify.getClassifyParentid());
		if(classifyService.save(classify)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@MyAuthorize(Role = {"ROLE_ADMIN"})
	@PostMapping("/update")
	public R update(ClassifyDO classify){
		classifyService.update(classify);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@MyAuthorize(Role = {"ROLE_ADMIN"})
	@PostMapping("/remove")
	public R Remove(@RequestParam("classifyId")Integer classifyId){
		if(classifyService.remove((long)classifyId)>0){
			return R.ok();
		}
		return R.error();
	}
}
