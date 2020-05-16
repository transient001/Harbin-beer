package com.sxt.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sxt.mapper.SupplierMapper;
import com.sxt.pojo.PageUtil;
import com.sxt.pojo.Supplier;
import com.sxt.service.SupplierService;
@Service
public class SupplierServiceImpl implements SupplierService{
	@Resource
	private SupplierMapper supplierMapper;
	
	//分页查询
	@Override
	public PageUtil findByPage(Supplier supplier, PageUtil pageUtil) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("startNum",pageUtil.getStartNum());
		map.put("pageSize",pageUtil.getPageSize());
		map.put("supplierName",supplier.getSupplierName());
		pageUtil.setPageList(supplierMapper.findByPage(map));
		pageUtil.setTotalNum(supplierMapper.findCount(supplier));
		return pageUtil;
				
	}
	//查询总的记录数
	@Override
	public int findCount(Supplier supplier) {
		// TODO Auto-generated method stub
		return supplierMapper.findCount(supplier);
	}
	//添加
	@Override
	public int add(Supplier supplier) {
		// TODO Auto-generated method stub
		return supplierMapper.add(supplier);
	}
	//删除
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return supplierMapper.delete(id);
	}
	//根据id查询详情
	@Override
	public Supplier findById(int id) {
		// TODO Auto-generated method stub
		return supplierMapper.findById(id);
	}
	//修改
	@Override
	public int update(Supplier supplier) {
		// TODO Auto-generated method stub
		return supplierMapper.update(supplier);
	}
	//查询全部
	@Override
	public List<Supplier> findAll() {
		// TODO Auto-generated method stub
		return supplierMapper.findAll();
	}

}
