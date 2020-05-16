package com.sxt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sxt.pojo.GoodsView;
import com.sxt.pojo.StockOut;

public interface StockOutMapper {
	//分页查询
	List<StockOut> findByPage(Map<String,Object> map);
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
	int updateStatus(@Param("status") int status,@Param("id") int id);
	//统计
	List<GoodsView> tongjiByGoodsName();	
}
