package com.sxt.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sxt.pojo.Goods;
import com.sxt.pojo.GoodsView;
import com.sxt.pojo.PageUtil;
import com.sxt.pojo.StockIn;
import com.sxt.pojo.Supplier;

public interface StockInService {
	//分页查询
	PageUtil findByPage(StockIn stockIn,PageUtil pageUtil);
	//查询总的记录数
	int findCount(StockIn stockIn);
	//添加
	int add(StockIn stockIn);
	//删除
	int delete(int id);
	//修改
	int update(StockIn stockIn);
	//根据id查询详情
	StockIn findById(int id);
	//修改状态
	int updateStatus(int status,int id);
	//统计
	List<GoodsView> tongjiByGoodsName();	
}
