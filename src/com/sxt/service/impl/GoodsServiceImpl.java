package com.sxt.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sxt.mapper.GoodsMapper;
import com.sxt.pojo.Goods;
import com.sxt.pojo.GoodsView;
import com.sxt.pojo.PageUtil;
import com.sxt.service.GoodsService;
@Service
public class GoodsServiceImpl implements GoodsService{
	@Resource
	private GoodsMapper goodsMapper;
	
	//查询全部
	@Override
	public List<Goods> findAll() {
		// TODO Auto-generated method stub
		return goodsMapper.findAll();
	}

	@Override
	public PageUtil findByPage(Goods goods, PageUtil pageUtil) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("startNum",pageUtil.getStartNum());
		map.put("pageSize",pageUtil.getPageSize());
		map.put("goodsName",goods.getGoodsName());
		
		pageUtil.setTotalNum(goodsMapper.findCount(goods));
		pageUtil.setPageList(goodsMapper.findByPage(map));
		
		return pageUtil;
	}

	@Override
	public int findCount(Goods goods) {
		// TODO Auto-generated method stub
		return goodsMapper.findCount(goods);
	}

	@Override
	public int add(Goods goods) {
		// TODO Auto-generated method stub
		return goodsMapper.add(goods);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return goodsMapper.delete(id);
	}

	@Override
	public int update(Goods goods) {
		// TODO Auto-generated method stub
		return goodsMapper.update(goods);
	}

	@Override
	public Goods findById(int id) {
		// TODO Auto-generated method stub
		return goodsMapper.findById(id);
	}

	@Override
	public List<GoodsView> tongjiByGoodsName() {
		// TODO Auto-generated method stub
		return goodsMapper.tongjiByGoodsName();
	}
	//商品入库
	@Override
	public int addTotalNum(int totalNum, int id) {
		// TODO Auto-generated method stub
		return goodsMapper.addTotalNum(totalNum, id);
	}
	//商品出库
	@Override
	public int reduceTotalNum(int totalNum, int id) {
		// TODO Auto-generated method stub
		return goodsMapper.reduceTotalNum(totalNum, id);
	}
	
}
