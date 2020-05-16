package com.sxt.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sxt.mapper.StockOutMapper;
import com.sxt.pojo.GoodsView;
import com.sxt.pojo.PageUtil;
import com.sxt.pojo.StockOut;
import com.sxt.service.StockOutService;

@Service
public class StockOutServiceImpl implements StockOutService{
	@Resource
	private StockOutMapper stockOutMapper;
	//分页查询
	@Override
	public PageUtil findByPage(StockOut stockOut, PageUtil pageUtil) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("startNum",pageUtil.getStartNum());
		map.put("pageSize",pageUtil.getPageSize());
		map.put("stockOutName",stockOut.getStockOutName());
		map.put("goodsName",stockOut.getGoodsName());
		map.put("status",stockOut.getStatus());
		map.put("startTime",stockOut.getStartTime());
		map.put("endTime",stockOut.getEndTime());
		pageUtil.setTotalNum(stockOutMapper.findCount(stockOut));
		pageUtil.setPageList(stockOutMapper.findByPage(map));
		return pageUtil;
	}
	//查询总的记录数
	@Override
	public int findCount(StockOut stockOut) {
		// TODO Auto-generated method stub
		return stockOutMapper.findCount(stockOut);
	}
	@Override
	public int add(StockOut stockOut) {
		// TODO Auto-generated method stub
		return stockOutMapper.add(stockOut);
	}
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return stockOutMapper.delete(id);
	}
	@Override
	public int update(StockOut stockOut) {
		// TODO Auto-generated method stub
		return stockOutMapper.update(stockOut);
	}
	@Override
	public StockOut findById(int id) {
		// TODO Auto-generated method stub
		return stockOutMapper.findById(id);
	}
	//修改状态
	@Override
	public int updateStatus(int status, int id) {
		// TODO Auto-generated method stub
		return stockOutMapper.updateStatus(status, id);
	}
	//统计
	@Override
	public List<GoodsView> tongjiByGoodsName() {
		// TODO Auto-generated method stub
		return stockOutMapper.tongjiByGoodsName();
	}

}
