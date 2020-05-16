package com.sxt.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sxt.mapper.CategoryMapper;
import com.sxt.pojo.Category;
import com.sxt.pojo.PageUtil;
import com.sxt.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService{
	@Resource
	private CategoryMapper categoryMapper;
	
	//查询所有二级商品分类
	@Override
	public List<Category> findByLevel() {
		// TODO Auto-generated method stub
		return categoryMapper.findByLevel();
	}
	//分页查询   查询所有的一级菜单
	@Override
	public PageUtil findByPage(Category category,PageUtil pageUtil) {
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("startNum",pageUtil.getStartNum());
		map.put("pageSize",pageUtil.getPageSize());
		map.put("categoryName",category.getCategoryName());
		pageUtil.setTotalNum(categoryMapper.findCount(category));
	
		List<Category> categoryList = categoryMapper.findByPage(map);
		for(Category c:categoryList){
			c.setChildList(categoryMapper.findChild(c.getId()));
		}
		pageUtil.setPageList(categoryList);
		return pageUtil;
	}
	//查询总的记录数   查询所有的一级菜单
	@Override
	public int findCount(Category category) {
		// TODO Auto-generated method stub
		return categoryMapper.findCount(category);
	}
	//添加一级分类
	@Override
	public int addLevelOne(Category category) {
		// TODO Auto-generated method stub
		return categoryMapper.addLevelOne(category);
	}
	//添加二级分类
	@Override
	public int addLevelTwo(Category category) {
		// TODO Auto-generated method stub
		return categoryMapper.addLevelTwo(category);
	}
	//修改一级分类
	@Override
	public int updateLevelOne(Category category) {
		// TODO Auto-generated method stub
		return categoryMapper.updateLevelOne(category);
	}
	//修改二级分类
	@Override
	public int updateLevelTwo(Category category) {
		// TODO Auto-generated method stub
		return categoryMapper.updateLevelTwo(category);
	}
	//根据一级id查询所有详情
	@Override
	public List<Category> findById(int id) {
		// TODO Auto-generated method stub
		return categoryMapper.findById(id);
	}
	//查询所有的一级商品分类
	@Override
	public List<Category> findByLevelOne() {
		// TODO Auto-generated method stub
		return categoryMapper.findByLevelOne();
	}
	//根据id查询 	一级分类的详情
	public Category findByIdOne(int id) {
		// TODO Auto-generated method stub
		return categoryMapper.findByIdOne(id);
	}
	
	
}
