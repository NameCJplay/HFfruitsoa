package com.hf.user.Controller;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.hf.domain.Annatation.MyAuthorize;
import com.hf.domain.Common.FileUtil;
import com.hf.domain.Common.PageUtils;
import com.hf.domain.Common.QueryStruct;
import com.hf.domain.Common.R;
import com.hf.domain.Domain.Dept.DeptDO;
import com.hf.domain.Domain.User.UserDOExample;
import com.hf.user.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.hf.domain.Domain.User.UserDO;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	//文件存储路径
	@Value("${hf.FileUrl}")
	private String FileUrl;


	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	private SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm");
	static Map mapall = new HashMap();

	@GetMapping("/list")
	@MyAuthorize(Role = {"ROLE_USER","ROLE_ADMIN"})
	public PageUtils list(UserDO user, QueryStruct queryStruct) throws IllegalAccessException {
		//查询列表数据
		Map<String,Object> map1= QueryStruct.objectToMap(queryStruct);
		List<UserDO> userList = userService.list(map1);
		List<DeptDO> deptlist = userService.getdeptlist(mapall);
		Map<Long, String> deptmap = deptlist.stream().collect(Collectors.toMap(DeptDO::getDeptId, DeptDO::getDeptName));
		for (UserDO list:userList) {
			list.setUserDeptName(deptmap.get(list.getUserDeptId()));
		}
		int total = userService.count(map1);
		PageUtils pageUtils = new PageUtils(userList, total);
		return pageUtils;
	}
	@GetMapping("/edit")
	@MyAuthorize(Role = "ROLE_ADMIN")
	UserDOExample edit(@RequestParam("userId") Long userId){
		UserDO user = userService.get(userId);
		UserDOExample exam = new UserDOExample(user);
		exam.setDeptlist(userService.getdeptlist(mapall));
		return exam;
	}

	@GetMapping("/detail")
	@MyAuthorize(Role = {"ROLE_USER","ROLE_ADMIN"})
	UserDOExample detail(){
		Integer userId = (Integer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDO user = userService.get(userId.longValue());
		UserDOExample exam = new UserDOExample(user);
		return exam;
	}

	/**
	 * 保存
	 */
	@PostMapping(value = "/save")
	@MyAuthorize(Role = "ROLE_ADMIN")
	public R save(UserDO user,@RequestParam(value="userImgs",required=false) MultipartFile userImg) throws Exception {
		String date = sdf.format(new Date());
		if(userImg != null){
			String uuidfilename = FileUtil.renameToUUID(userImg.getOriginalFilename());
			FileUtil.uploadFile(userImg.getBytes(),FileUrl,uuidfilename);
			user.setUserImg(uuidfilename);
		}
		user.setUserPwd(passwordEncoder().encode(user.getUserPwd()));
		user.setUserCreate(date);
		user.setUserModified(date);
		if(userService.save(user)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@PostMapping(value = "/update")
	@MyAuthorize(Role = "ROLE_ADMIN")
	public R update(UserDO user,@RequestParam(value="userImgs",required=false) MultipartFile userImg) throws Exception {
		if(userImg != null){
			FileUtil.deleteFile(FileUrl+user.getUserImg());
			String uuidfilename = FileUtil.renameToUUID(userImg.getOriginalFilename());
			FileUtil.uploadFile(userImg.getBytes(),FileUrl,uuidfilename);
			user.setUserImg(uuidfilename);
		}
		if(user.getUserPwd() != null && user.getUserPwd().length()<50){
			user.setUserPwd(passwordEncoder().encode(user.getUserPwd()));
		}
		user.setUserModified(sdf.format(new Date()));
		if(userService.update(user)>0){
			return R.ok();
		}
		return R.error();
	}

	//get图片
	@GetMapping("/getPicture")
	@MyAuthorize(Role = {"ROLE_USER","ROLE_ADMIN"})
	public void getPicture(HttpServletRequest request, HttpServletResponse response, Long userId) {
		try {
			response.setContentType("image/jpeg");// 设置相应类型,告诉浏览器输出的内容为图片
			response.setHeader("Pragma", "No-cache");// 设置响应头信息，告诉浏览器不要缓存此内容
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expire", 0);

			UserDO ed = userService.get(userId);
			if (ed.getUserImg() == null) {
				return;
			}
			try {
				BufferedImage bi1 = ImageIO.read(new File(FileUrl+ed.getUserImg()));
				// 将内存中的图片通过流形式输出到客户端
				ImageIO.write(bi1, "JPEG", response.getOutputStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@MyAuthorize(Role = "ROLE_ADMIN")
	public R remove( Long userId){
		UserDO userDO = userService.get(userId);
		if(userService.remove(userId)>0 && FileUtil.deleteFile(FileUrl+userDO.getUserImg())){
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@MyAuthorize(Role = "ROLE_ADMIN")
	public R remove(@RequestParam("ids[]") Long[] userIds){

		for (int i = 0;i<userIds.length;i++){
			UserDO userDO = userService.get(userIds[i]);
			if(FileUtil.deleteFile(FileUrl+userDO.getUserImg()))return R.error();
		}
		if(userService.batchRemove(userIds)>0){
			return R.ok();
		}
		return R.error();
	}

	//get头部图片
	@GetMapping("/getUserPicture")
	@MyAuthorize(Role = {"ROLE_USER","ROLE_ADMIN"})
	public void getUserPicture(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setContentType("image/jpeg");// 设置相应类型,告诉浏览器输出的内容为图片
			response.setHeader("Pragma", "No-cache");// 设置响应头信息，告诉浏览器不要缓存此内容
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expire", 0);
			Integer userId = (Integer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			UserDO userDO = userService.get(userId.longValue());
			if (userDO.getUserImg() == null || userDO.getUserImg().equals("")) {
				return;
			}else{
				try {
					BufferedImage bi1 = ImageIO.read(new File(FileUrl+userDO.getUserImg()));
					// 将内存中的图片通过流形式输出到客户端
					ImageIO.write(bi1, "JPEG", response.getOutputStream());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@PostMapping("/editPwd")
	@MyAuthorize(Role = {"ROLE_USER","ROLE_ADMIN"})
	public R editPwd(@RequestParam("oldPwd") String oldPwd,@RequestParam("newPwd") String newPwd){
		Integer userId = (Integer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDO userDO = userService.get(userId.longValue());
		if(passwordEncoder().matches(oldPwd,userDO.getUserPwd())){
			userDO.setUserPwd(passwordEncoder().encode(newPwd));
			if(userService.update(userDO)>0){
				return R.ok("修改成功！");
			}
		}else {
			return R.error("原密码错误！");
		}
		return R.error("修改失败！");
	}
	@GetMapping("/getUserName")
	@MyAuthorize(Role = {"ROLE_USER","ROLE_ADMIN"})
	public Model getUserName(Model model) {
		Integer userId = (Integer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = userService.get(userId.longValue()).getUserName();
		model.addAttribute("userName",userName);
		return model;
	}





}
