package com.sxt.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxt.pojo.Category;
import com.sxt.pojo.PageUtil;
import com.sxt.service.CategoryService;

@Controller
@RequestMapping("category")
public class CategoryController {
	@Resource
	private CategoryService categoryService;
	
	@RequestMapping("list")
	public String findCategorys(HttpServletRequest request,Category category,@RequestParam(defaultValue="1") int currPage,@RequestParam(defaultValue="3") int pageSize){
		PageUtil pageUtil=new PageUtil();
		pageUtil.setCurrPage(currPage);
		pageUtil.setPageSize(pageSize);
		
		pageUtil=categoryService.findByPage(category, pageUtil);
		request.setAttribute("pageUtil", pageUtil);
		return "category/categoryList";		
	}
	
	//添加一级分类	跳转页面
	@RequestMapping("add")
	public String addLevelOne(){
		return "category/addCategoryOne";		
	}
	//添加修改 一级分类 操作
	@RequestMapping("addUpdateLevelOne")
	public String addUpdateLevelOne(Category category){
		int num=0;
		if(category.getId()==0){//添加
			num=categoryService.addLevelOne(category);
		}else{//修改
			num=categoryService.updateLevelOne(category);
		}
		if(num>0){//成功
			return "redirect:/category/list";
		}else{
			return "forward:/error.jsp";
		}	
	}
	//修改一级菜单加载
	@RequestMapping("loadOne/{id}")
	public String loadOne(HttpServletRequest request,@PathVariable int id){
		Category category=categoryService.findByIdOne(id);
		request.setAttribute("category", category);
		return "category/addCategoryOne";
	}
	//添加二级分类 跳转页面
	@RequestMapping("addTwo")
	public String addLevelTwo(HttpServletRequest request){
		//查询一级分类数据
		List<Category> categoryList = categoryService.findByLevelOne();
		//存放到域中
		request.setAttribute("categoryList", categoryList);
		return "category/addCategoryTwo";		
	}
	//添加二级菜单操作
	@RequestMapping("addUpdateTwo")
	public String addUpdateLevelTwo(Category category){
		int num=categoryService.addLevelTwo(category);
		if(num>0){//成功
			return "redirect:/category/list";
		}else{
			return "forward:/error.jsp";
		}		
	}
	//根据id查询详情
	@RequestMapping("detail/{id}")
	@ResponseBody
	public List<Category> detailCategory(@PathVariable int id){
		List<Category> categoryList=categoryService.findById(id);
		return categoryList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
