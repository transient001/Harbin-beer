package com.sxt.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sxt.mapper.StockInMapper;
import com.sxt.pojo.Goods;
import com.sxt.pojo.GoodsView;
import com.sxt.pojo.PageUtil;
import com.sxt.pojo.StockIn;
import com.sxt.pojo.Supplier;
import com.sxt.service.StockInService;
@Service
public class StockInServiceImpl implements StockInService{
	@Resource
	private StockInMapper stockInMapper;
	//分页查询
	@Override
	public PageUtil findByPage(StockIn stockIn,PageUtil pageUtil) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("startNum",pageUtil.getStartNum());
		map.put("pageSize",pageUtil.getPageSize());
		map.put("stockInName",stockIn.getStockInName());
		map.put("goodsName",stockIn.getGoods().getGoodsName());
		map.put("supplierName",stockIn.getSupplier().getSupplierName());
		map.put("startTime",stockIn.getStartTime());
		map.put("endTime",stockIn.getEndTime());
		pageUtil.setPageList(stockInMapper.findByPage(map));
		pageUtil.setTotalNum(stockInMapper.findCount(stockIn));
		return pageUtil;
	}
	//查询总的记录数
	@Override
	public int findCount(StockIn stockIn) {
		// TODO Auto-generated method stub
		return stockInMapper.findCount(stockIn);
	}
	//添加
	@Override
	public int add(StockIn stockIn) {
		// TODO Auto-generated method stub
		return stockInMapper.add(stockIn);
	}
	//删除
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return stockInMapper.delete(id);
	}
	//修改
	@Override
	public int update(StockIn stockIn) {
		// TODO Auto-generated method stub
		return stockInMapper.update(stockIn);
	}
	//根据id查询详情
	@Override
	public StockIn findById(int id) {
		// TODO Auto-generated method stub
		return stockInMapper.findById(id);
	}
	//修改状态
	@Override
	public int updateStatus(int status, int id) {
		// TODO Auto-generated method stub
		return stockInMapper.updateStatus(status, id);
	}
	//统计
	@Override
	public List<GoodsView> tongjiByGoodsName() {
		// TODO Auto-generated method stub
		return stockInMapper.tongjiByGoodsName();
	}

	
	
}
