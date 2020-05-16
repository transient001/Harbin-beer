package com.sxt.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxt.pojo.PageUtil;
import com.sxt.pojo.Right;
import com.sxt.pojo.Role;
import com.sxt.pojo.RoleRight;
import com.sxt.service.RightService;
import com.sxt.service.RoleRightService;
import com.sxt.service.RoleService;

@Controller
@RequestMapping("role/")
public class RoleController {
	@Resource
	private RoleService roleService;
	@Resource
	private RightService rightService;
	@Resource
	private RoleRightService roleRightService;
	
	@RequestMapping("list")
	public String findRoles(HttpServletRequest request,Role role,@RequestParam(defaultValue="1") int currPage,@RequestParam(defaultValue="3") int pageSize){
		PageUtil pageUtil=new PageUtil();
		pageUtil.setCurrPage(currPage);
		pageUtil.setPageSize(pageSize);
		pageUtil=roleService.findByPage(role, pageUtil);
		
		request.setAttribute("pageUtil",pageUtil);
		return "role/roleList";	
	}
	//跳转添加页面
	@RequestMapping("add")
	public String addRole(HttpServletRequest request){
		List<Right> rightList = rightService.findByLevel();
		request.setAttribute("rightList", rightList);
		return "role/addRole";
	}
	//跳转修改界面
	@RequestMapping("load/{id}")
	public String loadRole(HttpServletRequest request,@PathVariable int id){
		//查询所有的一级菜单显示复选框时使用
		List<Right> rightList = rightService.findByLevel();
		request.setAttribute("rightList", rightList);
		//根据id查询角色所拥有的权限
		List<Right> rights = rightService.findByRoleId(id);
		request.setAttribute("rights", rights);
		//根据id查询角色详情
		Role role = roleService.findById(id);
		request.setAttribute("role", role);
		return "role/addRole";
	}
	//进行添加操作
	@RequestMapping("addRole")
	public String addUpdate(HttpServletRequest request,String roleName,int[] rightIdArray){
		//添加角色
		Role role1=new Role();
		role1.setRoleName(roleName);
		int num1=roleService.add(role1);
		System.out.println(roleName);
		//添加角色权限
		//根据 roleName查询详情	查到id
		Role role2=roleService.findByRoleName(roleName);
		int num2=0;
		int num3=0;
		//遍历 集合  进行集合长度次数的添加 t_role_right数据
		for(int i=0;i<rightIdArray.length;i++){
			System.out.println(rightIdArray[i]);
			RoleRight roleRight=new RoleRight();
			roleRight.setRightId(rightIdArray[i]);
			roleRight.setRoleId(role2.getId());
			num3=roleRightService.add(roleRight);
			num2+=num3;
		}
		if(num1+num2>rightIdArray.length){//成功
			return "redirect:/role/list";
		}else{
			return "forward:/error.jsp";
		}		
	}
	//进行修改操作
	@RequestMapping("updateRole")
	public String updateRole(int id,String roleName,int[] rightIdArray){
		//修改角色
		Role role1=new Role();
		role1.setId(id);
		role1.setRoleName(roleName);
		int num1=roleService.update(role1);
		//修改权限
		//根据角色id查询出原有的权限		
		List<RoleRight> roleRightList = roleRightService.findByRoleId(id);
		int [] oldRight=new int[roleRightList.size()];
		//看旧权限是否继续存在，不存在对该权限进行删除操作		
		for (RoleRight r : roleRightList) {
			int count=0;//通过判断count的值来确认是否删除
			int oldId=r.getRightId();
			for(int i=0;i<rightIdArray.length;i++){
				System.out.println("rightId: "+rightIdArray[i]);
				//判断
				if(oldId==rightIdArray[i]){
					count=1;//旧的权限依然存在
				}		
			}
			if(count==0){//新的权限里取消 了该权限，进行删除操作
				roleRightService.delete(id,oldId);
			}			
		}
		//看新权限是否继续存在，不存在对该权限进行添加操作
		for(int i=0;i<rightIdArray.length;i++){
			System.out.println(rightIdArray[i]);
			int count=0;
			for (RoleRight r :roleRightList){
				int oldId=r.getRightId();
				if(rightIdArray[i]==oldId){//新的权限已经存在，无需操作
					count=1;
				}			
			}
			if(count==0){//新的权限不存在，进行添加操作
				RoleRight roleRightNew=new RoleRight();
				roleRightNew.setRoleId(id);
				roleRightNew.setRightId(rightIdArray[i]);
				roleRightService.add(roleRightNew);
			}
		}
		return "redirect:/role/list";
	}
	//ajax查看详情
	@RequestMapping("detail/{id}")
	@ResponseBody
	public Role detail(@PathVariable int id){
		Role role = roleService.findById(id);
		role.setRightList(rightService.findByRoleId(role.getId()));
		return role;
	}
	//进行删除操作
	@RequestMapping("delete/{id}")
	public String delete(@PathVariable int id){
		//首先删除该角色的权限
		int num1=roleRightService.deleteAll(id);
		//然后删除该角色
		int num2=roleService.delete(id);
		if(num1+num2>1){//成功
			return "redirect:/role/list";
		}else{
			return "forward:/error.jsp";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
