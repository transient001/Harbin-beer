package com.sxt.service;

import java.util.List;

import com.sxt.pojo.Category;
import com.sxt.pojo.PageUtil;

public interface CategoryService {
	//查询所有一级商品分类
	List<Category> findByLevelOne();	
	//查询所有二级商品分类
	List<Category> findByLevel();
	//分页查询   查询所有的一级菜单
	PageUtil findByPage(Category category,PageUtil pageUtil);
	//查询总的记录数   查询所有的一级菜单
	int findCount(Category category);
	//添加 一级分类
	int addLevelOne(Category category);
	//添加 二级分类
	int addLevelTwo(Category category);
	//修改 一级分类
	int updateLevelOne(Category category);
	//修改 二级分类
	int updateLevelTwo(Category category);
	//根据id查询 	一级分类的详情
	Category  findByIdOne(int id);
	//根据一级id查询所有详情
	List<Category> findById(int id);
	
}
