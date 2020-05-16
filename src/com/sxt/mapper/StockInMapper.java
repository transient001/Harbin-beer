package com.sxt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sxt.pojo.GoodsView;
import com.sxt.pojo.StockIn;

public interface StockInMapper {
	//分页查询
	List<StockIn> findByPage(Map<String,Object> map);
	//查询总的记录数
	int findCount(StockIn stockIn);
	//根据id查询详情
	StockIn findById(int id);
	//添加
	int add(StockIn stockIn);
	//删除
	int delete(int id);
	//修改
	int update(StockIn stockIn);
	//修改状态
	int updateStatus(@Param("status") int status,@Param("id") int id);
	//统计
	List<GoodsView> tongjiByGoodsName();
}
