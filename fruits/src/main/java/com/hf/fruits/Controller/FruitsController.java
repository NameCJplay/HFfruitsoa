package com.hf.fruits.Controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import com.hf.domain.Annatation.MyAuthorize;
import com.hf.domain.Common.*;
import com.hf.domain.Domain.Classify.ClassifyDO;
import com.hf.domain.Domain.Fruits.FruitsDO;
import com.hf.domain.Domain.Fruits.FruitsDOExample;
import com.hf.domain.Domain.User.UserDO;
import com.hf.fruits.Service.FruitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/fruits")
public class FruitsController {
	@Autowired
	private FruitsService fruitsService;

	@Value("${hf.FileUrl}")
	public String FileUrl;

	static SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm");
	static List<ClassifyDO> classfiyList = null;
	//通过分类id或 hot id 查询
	@GetMapping("/GetFruClassfiy")
	@MyAuthorize(Role = {"ROLE_USER","ROLE_ADMIN"})
	public List<FruitsDO> GetFruClassfiy(Integer classid,Integer hotid){
		FruitsDO fd = new FruitsDO();
		fd.setFruitsHot(hotid);
		if(classid != null)fd.setFruitsClassifyId(classid.longValue());
		List<FruitsDO> fruitsList =fruitsService.GetFruClassfiy(fd);
		return fruitsList;
	}
	@GetMapping("/list")
	@MyAuthorize(Role = {"ROLE_USER","ROLE_ADMIN"})
	public PageUtils list(FruitsDO fruits, QueryStruct queryStruct) throws IllegalAccessException {
		//查询列表数据
		Map<String,Object> map1=QueryStruct.objectToMap(queryStruct);
		List<FruitsDO> fruitsList = fruitsService.Getlist(map1);
		int total = fruitsService.Getcount(map1);
		classfiyList = fruitsService.getChildren(-1);
		Map<Long, String> classfiymap = classfiyList.stream().collect(Collectors.toMap(ClassifyDO::getClassifyId, ClassifyDO::getClassifyName));
		for(FruitsDO fd :fruitsList){
			String name = classfiymap.get(fd.getFruitsClassifyId());
			fd.setClassname(name);
		}
		//System.out.println(classfiyList);
		PageUtils pageUtils = new PageUtils(fruitsList, total);
		return pageUtils;
	}
	//通过id获取对象(修改时用)
	@RequestMapping(value = "/edit")
	@MyAuthorize(Role = {"ROLE_USER","ROLE_ADMIN"})
	public FruitsDOExample edit(@RequestParam("fruitsId")Integer fruitsId, Model model){
		FruitsDO fruitsdo=fruitsService.get((long)fruitsId);
		//替换成前端识别的日期格式
		StringBuffer sb = new StringBuffer(sdf.format(fruitsdo.getFruitsCreateDate()));
		StringBuffer sv = sb.replace(10,11,"T");
		String createtime = sv.toString();
		//结束
		int mutitytime = DateUtil.SubDays(fruitsdo.getFruitsCreateDate(),fruitsdo.getFruitsMaturityDate());
		FruitsDOExample fruits = new FruitsDOExample(fruitsdo);
		fruits.setFruitsCreateDate(createtime);
		fruits.setFruitsMaturityDate(mutitytime);
		fruits.setClasslist(classfiyList);
		model.addAttribute("fruits",fruits);
		return fruits;
	}
	//删除
	@PostMapping("/remove")
	@MyAuthorize(Role = {"ROLE_ADMIN"})
	public R Remove(@RequestParam("fruitsId")Integer fruitsId){
		String url = fruitsService.get(fruitsId.longValue()).getFruitsImg();
		if(fruitsService.remove((long)fruitsId)>0&&FileUtil.deleteFile(FileUrl+url)){
			return R.ok();
		}
		return R.error();
	}
	//保存
	// @DateTimeFormat(pattern = "YYYY/MM/dd")
	@PostMapping(value = "/save")
	@MyAuthorize(Role = {"ROLE_USER","ROLE_ADMIN"})
	public R Save(FruitsDOExample fep,@RequestParam(value="fruitsImgs",required=false) MultipartFile fruitsImgs) throws Exception {
		Date now = new Date();
		Date mdate = DateUtil.getDate(now,fep.getFruitsMaturityDate());
		if(fruitsImgs != null){
			String uuidfilename = FileUtil.renameToUUID(fruitsImgs.getOriginalFilename());
			FileUtil.uploadFile(fruitsImgs.getBytes(),FileUrl,uuidfilename);
			fep.setFruitsImg(uuidfilename);
		}
		FruitsDO fruits =
				new FruitsDO(null,(long)fep.getFruitsClassifyId(),fep.getFruitsName(),
				fep.getFruitsCprice(),fep.getFruitsPrice(),fep.getFruitsUnit(),fep.getFruitsStock(),
				fep.getFruitsImg(),now,mdate,fep.getFruitsSupplier(),fep.getFruitsHot(),fep.getFruitsStatus());
		if(fruitsService.save(fruits)>0){
			return R.ok();
		}
		return R.error();
	}
	//修改
	@PostMapping("/update")
	@MyAuthorize(Role = {"ROLE_USER","ROLE_ADMIN"})
	public R Update(FruitsDOExample fep,@RequestParam(value="fruitsImgs",required=false) MultipartFile fruitsImgs) throws Exception {
		StringBuffer sb = new StringBuffer(fep.getFruitsCreateDate());
		StringBuffer sv = sb.replace(10,11," ");
		String createtime = sv.toString();
		Date CreateDate = sdf.parse(createtime);
		Date MaturityDate = DateUtil.getDate(CreateDate,fep.getFruitsMaturityDate());
		if(fruitsImgs != null){
			FileUtil.deleteFile(FileUrl+fep.getFruitsImg());
			String uuidfilename = FileUtil.renameToUUID(fruitsImgs.getOriginalFilename());
			FileUtil.uploadFile(fruitsImgs.getBytes(),FileUrl,uuidfilename);
			fep.setFruitsImg(uuidfilename);
		}
		FruitsDO fruits = new FruitsDO(fep);
		fruits.setFruitsCreateDate(CreateDate);
		fruits.setFruitsMaturityDate(MaturityDate);
		if(fruitsService.update(fruits)>0){
			return R.ok();
		}
		return R.error();
	}

	//get图片
	@GetMapping("/getPicture")
	@MyAuthorize(Role = {"ROLE_USER","ROLE_ADMIN"})
	public void getPicture(HttpServletRequest request, HttpServletResponse response, Long fruitsId) {
		try {
			response.setContentType("image/jpeg");// 设置相应类型,告诉浏览器输出的内容为图片
			response.setHeader("Pragma", "No-cache");// 设置响应头信息，告诉浏览器不要缓存此内容
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expire", 0);

			FruitsDO ed = fruitsService.get(fruitsId);
			if (ed.getFruitsImg() == null || ed.getFruitsImg().equals("")) {
				return;
			}else{
				try {
					BufferedImage bi1 = ImageIO.read(new File(FileUrl+ed.getFruitsImg()));
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

	//批量删除
	@PostMapping("/batchRemove")
	@MyAuthorize(Role = {"ROLE_ADMIN"})
	public R Batchremove(@RequestParam("ids[]") Long[] fruitsIds){
		for (int i = 0;i<fruitsIds.length;i++){
			FruitsDO fruitsDO = fruitsService.get(fruitsIds[i]);
			if(FileUtil.deleteFile(FileUrl+fruitsDO.getFruitsImg()))return R.error();
		}
		if(fruitsService.batchremove(fruitsIds)>0){
			return R.ok();
		}
		return R.error();
	}

}
