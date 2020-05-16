package com.sxt.controller;

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
import com.sxt.pojo.Right;
import com.sxt.pojo.User;
import com.sxt.service.RightService;

@Controller
@RequestMapping("right/")
public class RightController {
	@Resource
	private RightService rightService;
	//菜单
	@RequestMapping("list")
	public String findRights(HttpSession session){
		User user=(User)session.getAttribute("userLogin");
		List<Right> rightList = rightService.findByRoleId(user.getRoleId());
		session.setAttribute("rights", rightList);
		return "forward:/main.jsp";
	}
	
	//分页查询
	@RequestMapping("fenye")
	public String fenye(HttpServletRequest request,Right right,@RequestParam(defaultValue="1") int currPage,@RequestParam(defaultValue="3") int pageSize){
		PageUtil pageUtil=new PageUtil();
		pageUtil.setCurrPage(currPage);
		pageUtil.setPageSize(pageSize);
		pageUtil=rightService.findByPage(right, pageUtil);
		request.setAttribute("pageUtil", pageUtil);
		return "right/rightList";
	}
	
	//ajax查看详情
	@RequestMapping("detail/{id}")
	@ResponseBody
	public Right detail(@PathVariable int id){
		Right right=rightService.findById(id);
		right.setChildRight(rightService.findLevelTwoById(right.getId()));
		return right;
	}
	
	//跳转添加页面
	@RequestMapping("add")
	public String add(HttpServletRequest request){
		//查询所有的一级权限
		List<Right> rightList = rightService.findByLevel();
		request.setAttribute("rightList", rightList);
		return "right/addRight";
	}
	//进行添加操作
	@RequestMapping("addRight")
	public String addRight(int parentId,String rightName){
		System.out.println("parentId:"+parentId);
		System.out.println("rightName:"+rightName);
		Right right=new Right();
		int num=0;
		if(parentId==0){//添加一级权限		
			right.setRightName(rightName);
			right.setLevel(1);
			num=rightService.addLevel1(right);
		}else{//给已有权限添加二级权限
			right.setRightName(rightName);
			right.setParentId(parentId);
			right.setLevel(2);
			num=rightService.addLevel2(right);
		}
		if(num>0){//添加成功
			return "redirect:/right/fenye";
		}else{
			return "forward:/error.jsp";
		}
		
	}
	//进行删除操作
	@RequestMapping("delete/{id}")
	public String delete(@PathVariable int id){
		//首先删除所有的子权限
		int num1=rightService.deleteByParentId(id);
		//然后删除权限本身
		int num2=rightService.delete(id);

		return "redirect:/right/fenye";		

	}
	//跳转到修改页面
	@RequestMapping("load/{id}")
	public String load(HttpServletRequest request,@PathVariable int id){
		//根据id查询到所有的全部子权限
		List<Right> childList = rightService.findByParentId(id);
		request.setAttribute("childList", childList);
		//根据id查询详情
		Right right=rightService.findById(id);
		request.setAttribute("right", right);
		return "right/updateRight";
	}
	//进行修改权限操作
	@RequestMapping("updateRight")
	public String updateRight(int id,String rightName,int [] childIdArray){
		//修改一级权限的名称
		int num1=rightService.updateLevel1(id, rightName);
		//修改相关权限  （如果复选框取消勾中，进行删除操作，删除该子权限）
		//根据父Id查询出所有子权限,将子权限的id封装成一个数组
		List<Right> rightList = rightService.findByParentId(id);
		for(Right r:rightList){
			int count=0;
			System.out.println(r.getId());
			for(int i=0;i<childIdArray.length;i++){
				if(r.getId()==childIdArray[i]){
					count=1;//旧的权限继续存在，无需进行任何操作
				}
			}
			if(count==0){//旧权限被取消，进行相关的删除操作
				rightService.delete(r.getId());
			}			
		}
		
		return "redirect:/right/fenye";
	}
	
	
	
	
	
	
}
