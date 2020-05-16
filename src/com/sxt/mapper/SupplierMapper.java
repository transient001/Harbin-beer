package com.sxt.mapper;

import java.util.List;
import java.util.Map;

import com.sxt.pojo.Supplier;

public interface SupplierMapper {
	//查询全部
	List<Supplier> findAll();
	//分页查询
	List<Supplier> findByPage(Map<String,Object> map);
	//查询总的记录数
	int findCount(Supplier supplier);
	//根据id查询详情
	Supplier findById(int id);
	//添加
	int add(Supplier supplier);
	//删除
	int delete(int id);
	//修改
	int update(Supplier supplier);
}
