package cn.sp.appinfo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sp.appinfo.entity.DevUser;
import cn.sp.appinfo.service.DevUserService;

@Controller
@RequestMapping("/dev")
public class DevUserController {
	
	@Resource
	private DevUserService devUserService;
	
	//跳转到开发者登陆界面
	@RequestMapping("/beforeLogin")
	public String beforeLogin(){
		return "devlogin";
	}
	
	//登陆验证
	@RequestMapping("/login")
	public String login(String devCode,String devPassword,HttpSession session,Model model){
		DevUser devUser = devUserService.login(devCode, devPassword);
		if(devUser != null){
			session.setAttribute("devUserSession", devUser);
			return "developer/main";
		}else{
			model.addAttribute("error", "用户名或者密码错误，请重新登陆！");
			return "devlogin";
		}
	}
	
	//开发者注销
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		// 让session失效
		session.invalidate();
		return "devlogin";
	}

}
