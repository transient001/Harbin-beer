package com.sxt.service;

import java.util.List;
import java.util.Map;

import com.sxt.pojo.PageUtil;
import com.sxt.pojo.Supplier;

public interface SupplierService {
	//查询全部
	List<Supplier> findAll();
	//分页查询
	PageUtil findByPage(Supplier supplier, PageUtil pageUtil);
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
