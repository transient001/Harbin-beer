package com.sxt.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sxt.pojo.GoodsView;
import com.sxt.pojo.PageUtil;
import com.sxt.pojo.StockOut;

public interface StockOutService {
	//分页查询
	PageUtil findByPage(StockOut stockOut,PageUtil pageUtil);
	//查询总的记录数
	int findCount(StockOut stockOut);
	//添加
	int add(StockOut stockOut);
	//删除
	int delete(int id);
	//修改
	int update(StockOut stockOut);
	//根据id查询详情
	StockOut findById(int id);
	//修改状态
	int updateStatus(int status,int id);
	//统计
	List<GoodsView> tongjiByGoodsName();	
}
