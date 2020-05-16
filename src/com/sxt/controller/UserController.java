package com.sxt.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxt.pojo.PageUtil;
import com.sxt.pojo.Role;
import com.sxt.pojo.User;
import com.sxt.service.RoleService;
import com.sxt.service.UserService;

@Controller
@RequestMapping("user/")
public class UserController {
	@Resource
	private UserService userService;
	@Resource
	private RoleService roleService;
	
	@RequestMapping("login")
	public String login(HttpSession session,String userName,String password){		
		User userLogin = userService.login(userName, password);
		if(userLogin!=null){//登陆成功
			session.setAttribute("userLogin", userLogin);
			//根据当前用户的角色查询菜单
			return "forward:/right/list";		
		}
		return "forward:/login.jsp";
	}
	@RequestMapping("exit")
	public String exit(HttpSession session){
		session.removeAttribute("userLogin");
		return "redirect:/login.jsp";
	}
	@RequestMapping("ajaxCheckUserName")
	@ResponseBody
	public String ajaxCheckUserName(String userName){
		User user=userService.ajaxCheckUserName(userName);
		if(user!=null){
			return "1";
		}else{
			return "0";
		}
	}
	
	
	
	
	@RequestMapping("list")
	public String findUsers(HttpServletRequest request,User user,Role role,@RequestParam(defaultValue="1") int currPage,@RequestParam(defaultValue="3") int pageSize){
		PageUtil pageUtil=new PageUtil();
		pageUtil.setCurrPage(currPage);
		pageUtil.setPageSize(pageSize);
		user.setRole(role);
		pageUtil = userService.findByPage(user, pageUtil);
		
		request.setAttribute("pageUtil", pageUtil);
		return "user/userList";
	}
	@RequestMapping("add")
	public String addUser(HttpServletRequest request){
		List<Role> roleList = roleService.findAll();
		
		request.setAttribute("roleList",roleList);
		return "user/addUser";
	}
	@RequestMapping("load/{id}")
	public String loadUser(HttpServletRequest request,@PathVariable int id){
		User user = userService.findById(id);
		List<Role> roleList = roleService.findAll();
		request.setAttribute("user",user);
		request.setAttribute("roleList",roleList);
		return "user/addUser";
	}
	
	@RequestMapping("addUpdate")
	public String addUpdateUser(User user){
		int num=0;
		if(user.getId()==0){//添加
			user.setHiredate(new Date());
			num=userService.add(user);
		}else{//修改
			num=userService.update(user);
		}
		if(num>0){//成功
			return "redirect:/user/list";			
		}else{
			return "forward:/error.jsp";
		}
	}
	@RequestMapping("delete/{id}")
	public String deleteUser(@PathVariable int id){
		int num = userService.delete(id);
		if(num>0){//成功
			
			return "redirect:/login.jsp";			
		}else{
			return "forward:/error.jsp";
		}
			
	}
	@RequestMapping("detail/{id}")
	@ResponseBody
	public User detail(@PathVariable int id){
		User user=userService.findById(id);
		return user;
	}
	@RequestMapping("updatePassword")
	public String updatePassword(HttpSession session,int id,String newPassword){
		int num=userService.updatePassword(id, newPassword);
		if(num>0){//修改成功
			session.removeAttribute("userLogin");
			return "forward:/rightMain.jsp";
			
		}else{//修改失败
			return "forward:/error.jsp";
		}
	}
	@RequestMapping("updatePdTiaozhuan")
	public String updatePdTiaozhuan(){
		return "user/updatePassword";
	}
	
	
	
	
	
	
	
}
