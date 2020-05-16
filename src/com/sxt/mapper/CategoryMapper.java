package com.sxt.mapper;

import java.util.List;
import java.util.Map;

import com.sxt.pojo.Category;

public interface CategoryMapper{
	//查询所有一级商品分类
	List<Category> findByLevelOne();
	//查询所有二级商品分类
	List<Category> findByLevel();
	//分页查询   查询所有的一级分类
	List<Category> findByPage(Map<String,Object> map);
	//查询总的记录数   查询所有的一级分类
	int findCount(Category category);
	//根据一级分类id查询所有的二级分类
	List<Category> findChild(int parentId);
	//添加 一级分类
	int addLevelOne(Category category);
	//添加 二级分类
	int addLevelTwo(Category category);
	//删除
	int delete(int id);
	//修改 一级分类
	int updateLevelOne(Category category);
	//修改 二级分类
	int updateLevelTwo(Category category);	
	//根据一级id查询所有详情  
	List<Category> findById(int id);
	//根据id查询 	一级分类的详情
	Category  findByIdOne(int id);
}
