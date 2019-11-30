package cn.sp.appinfo.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.sp.appinfo.entity.AppCategory;
import cn.sp.appinfo.service.AppCategoryService;

@Controller
@RequestMapping("/appinfo")
public class AppInfoController {
	
	@Resource
	private AppCategoryService appCategoryService;
	
	//点击APP维护，跳转到APP信息查询页面appinfolist.jsp
	@RequestMapping("beforeList")
	public String beforeList(Model model){
		//查询APP状态
		//查询所属平台
		//查询一级分类
		List<AppCategory> oneCategory = appCategoryService.getByParentId(null);
		model.addAttribute("categoryLevel1List", oneCategory);
		return "developer/appinfolist";
	}
	
	//ajax根据父级id查找对应的子级分类
	@RequestMapping("/categoryLinkage")
	@ResponseBody
	public Object categoryLinkage(String pid){
		List<AppCategory> oneCategory = appCategoryService.getByParentId(pid==""?null:Integer.parseInt(pid));
		return oneCategory;
	}
	
	//点击新增APP基础信息，跳转到新增APP基础信息页面appinfoadd.jsp
	@RequestMapping("/beforeAdd")
	public String beforeAdd(){
		return "developer/appinfoadd";
	}
	
	//点击保存按钮，新增APP
	@RequestMapping("/add")
	@ResponseBody
	public String add(MultipartFile mf,HttpServletRequest req){
		//获得文件名
		String fileName = mf.getOriginalFilename();
		//获得软件名称
		String softName = req.getParameter("softwareName");
		return fileName+"-----"+softName;
	}

}
