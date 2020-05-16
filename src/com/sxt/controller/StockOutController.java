package com.sxt.controller;

import java.io.IOException;
import java.util.Date;
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

import com.sxt.pojo.Goods;
import com.sxt.pojo.GoodsView;
import com.sxt.pojo.PageUtil;
import com.sxt.pojo.StockOut;
import com.sxt.service.GoodsService;
import com.sxt.service.StockOutService;
import com.sxt.util.ViewUtil;
@Controller
@RequestMapping("stockOut/")
public class StockOutController {
	@Resource
	private StockOutService stockOutService;
	@Resource
	private GoodsService goodsService;
	
	//分页查询
	@RequestMapping("list")
	public String findStockOuts(HttpServletRequest request,StockOut stockOut,@RequestParam(defaultValue="1") int currPage,@RequestParam(defaultValue="3") int pageSize){
		PageUtil pageUtil=new PageUtil();
		pageUtil.setCurrPage(currPage);
		pageUtil.setPageSize(pageSize);
		pageUtil=stockOutService.findByPage(stockOut, pageUtil);
		
		request.setAttribute("pageUtil", pageUtil);
		return "stockOut/stockOutList";
	}
	//添加 跳转添加页面
	@RequestMapping("add")
	public String addStockOut(HttpServletRequest request){
		List<Goods> goodsList = goodsService.findAll();
		request.setAttribute("goodsList", goodsList);
		return "stockOut/addStockOut";
	}
	//修改 跳转修改界面
	@RequestMapping("load/{id}")
	public String load(HttpServletRequest request,@PathVariable int id){
		List<Goods> goodsList = goodsService.findAll();
		request.setAttribute("goodsList", goodsList);
		
		StockOut stockOut=stockOutService.findById(id);
		request.setAttribute("stockOut",stockOut);
		return "stockOut/addStockOut";
	}
	//进行添加 修改 操作
	@RequestMapping("addUpdate")
	public String addUpdateStockOut(HttpServletRequest request,StockOut stockOut){
		int num=0;
		if(stockOut.getId()==0){//添加
			stockOut.setStockOutDate(new Date());
			stockOut.setStatus("1");
			num=stockOutService.add(stockOut);
		}else{//修改
			num=stockOutService.update(stockOut);
		}
		if(num>0){//成功
			return "redirect:/stockOut/list";
		}else{//失败
			return "forwar:/error.jsp";
		}
	}
	//删除
	@RequestMapping("delete/{id}")
	public String deleteStockOut(@PathVariable int id){
		int num=stockOutService.delete(id);
		if(num>0){//成功
			return "redirect:/stockOut/list";
		}else{//失败
			return "forwar:/error.jsp";
		}		
	}
	//查看详情
	@RequestMapping("detail/{id}")
	@ResponseBody
	public StockOut detailStockOut(@PathVariable int id){
		StockOut stockOut=stockOutService.findById(id);
		return stockOut;
	}
	//修改状态
	@RequestMapping("updateStatus")
	public String updateStatus(int status,int id){
		int num=stockOutService.updateStatus(status, id);
		if(num>0){//成功
			return "redirect:/stockOut/list";
		}else{//失败
			return "forwar:/error.jsp";
		}		
	}
	//出库
	@RequestMapping("chuku")
	public String chuku(int status,int id,int stockOutNum,int goodsId){
		//修改状态
		int num1=stockOutService.updateStatus(status, id);
		//商品出库操作
		int num2=goodsService.reduceTotalNum(stockOutNum,goodsId);
		if(num1+num2>1){//成功
			return "redirect:/goods/list";
		}else{//失败
			return "forward:/error.jsp";
		}
	}
	//统计
	@RequestMapping("tongji")
	public String tongji(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		//按商品名称统计入库单
		List<GoodsView> stockOutView=stockOutService.tongjiByGoodsName();
		//生成饼状图
		ViewUtil.pieChar(request,response,stockOutView);
		
		//生成柱状图
		ViewUtil.barChar(request,response,stockOutView);
		
		//跳转页面显示
		return "stockOut/tongji";
					
		
	}	
	
	
	
	
	
	
	
	
}
