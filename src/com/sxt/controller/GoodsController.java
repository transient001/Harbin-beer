package com.sxt.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxt.pojo.Category;
import com.sxt.pojo.Goods;
import com.sxt.pojo.GoodsView;
import com.sxt.pojo.PageUtil;
import com.sxt.service.CategoryService;
import com.sxt.service.GoodsService;
import com.sxt.util.ViewUtil;

@Controller
@RequestMapping("goods")
public class GoodsController {
	@Resource
	private GoodsService goodsService;
	@Resource
	private CategoryService categoryService;
	
	@RequestMapping("list")
	public String findGoodss(HttpServletRequest request,Goods goods,@RequestParam(defaultValue="1") int currPage,@RequestParam(defaultValue="3") int pageSize){
		PageUtil pageUtil=new PageUtil();
		pageUtil.setCurrPage(currPage);
		pageUtil.setPageSize(pageSize);
		
		pageUtil = goodsService.findByPage(goods, pageUtil);
		
		request.setAttribute("pageUtil", pageUtil);
		//跳转页面
		return "goods/goodsList";
	}
	@RequestMapping("add")
	public String addGoods(HttpServletRequest request){
		List<Category> categoryList = categoryService.findByLevel();
		request.setAttribute("categoryList", categoryList);
		return "goods/addGoods";
	}
	@RequestMapping("load/{id}")
	public String load(HttpServletRequest request,@PathVariable int id){
		List<Category> categoryList = categoryService.findByLevel();
		request.setAttribute("categoryList", categoryList);
		
		Goods goods = goodsService.findById(id);
		request.setAttribute("goods", goods);
		return "goods/addGoods";
	}
	@RequestMapping("addUpdate")
	public String addUpdateGoods(Goods goods){
		int num=0;
		if(goods.getId()==0){//添加
			num=goodsService.add(goods);
		}else{//修改
			num=goodsService.update(goods);
		}
		if(num>0){//成功
			return "redirect:/goods/list";
		}else{
			return "forward:/error.jsp";
		}
		
	}
	@RequestMapping("delete/{id}")
	public String delete(@PathVariable int id){
		int num = goodsService.delete(id);
		if(num>0){//成功
			return "redirect:/goods/list";
		}else{
			return "forward:/error.jsp";
		}
	}
	@RequestMapping("detail/{id}")
	@ResponseBody
	public Goods detail(@PathVariable int id){
		Goods goods=goodsService.findById(id);
		return goods;
	}
	@RequestMapping("tongji")
	public String tongji(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		//按商品名称统计入库单
		List<GoodsView> goodsViews=goodsService.tongjiByGoodsName();
		//生成饼状图
		ViewUtil.pieChar(request,response,goodsViews);
		
		//生成柱状图
		ViewUtil.barChar(request,response,goodsViews);
		
		//跳转页面显示
		return "goods/tongji";
			
	}
	
	
	
	
	
	
	
}
