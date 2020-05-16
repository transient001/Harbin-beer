package com.sxt.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sxt.pojo.Goods;
import com.sxt.pojo.GoodsView;
import com.sxt.pojo.PageUtil;

public interface GoodsService {
	//查询全部
	List<Goods> findAll();
	//分页查询
	PageUtil findByPage(Goods goods,PageUtil pageUtil);
	//查询总的记录数
	int findCount(Goods goods);
	//添加
	int add(Goods goods);
	//删除
	int delete(int id);
	//修改
	int update(Goods goods);
	//根据id查询详情
	Goods findById(int id);
	//统计
	List<GoodsView> tongjiByGoodsName();
	//商品入库
	int addTotalNum(int totalNum,int id);
	//商品出库
	int reduceTotalNum(int totalNum,int id);	
}
