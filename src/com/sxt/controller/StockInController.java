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
import com.sxt.pojo.StockIn;
import com.sxt.pojo.Supplier;
import com.sxt.service.GoodsService;
import com.sxt.service.StockInService;
import com.sxt.service.SupplierService;
import com.sxt.util.ViewUtil;

@Controller
@RequestMapping("stockIn/")
public class StockInController {
	@Resource
	private StockInService stockInService;
	@Resource
	private SupplierService supplierService;
	@Resource
	private GoodsService goodsService;
	
	@RequestMapping("list")
	public String findStockIns(HttpServletRequest request,StockIn stockIn,Goods goods,Supplier supplier,@RequestParam(defaultValue="1") int currPage,@RequestParam(defaultValue="3") int pageSize){
		PageUtil pageUtil=new PageUtil();
		pageUtil.setCurrPage(currPage);
		pageUtil.setPageSize(pageSize);
		
		stockIn.setGoods(goods);
		stockIn.setSupplier(supplier);
		pageUtil=stockInService.findByPage(stockIn, pageUtil);
		
		request.setAttribute("pageUtil", pageUtil);
		return "stockIn/stockInList";
	}
	@RequestMapping("add")
	public String addStockIn(HttpServletRequest request){
		List<Supplier> supplierList = supplierService.findAll();
		List<Goods> goodsList = goodsService.findAll();
		
		request.setAttribute("supplierList",supplierList);
		request.setAttribute("goodsList",goodsList);
		return "stockIn/addStockIn";
	}
	@RequestMapping("load/{id}")
	public String load(HttpServletRequest request,@PathVariable int id){
		//查询供应商和商品
		List<Supplier> supplierList = supplierService.findAll();
		List<Goods> goodsList = goodsService.findAll();
		
		request.setAttribute("supplierList",supplierList);
		request.setAttribute("goodsList",goodsList);		
		
		StockIn stockIn=stockInService.findById(id);
		request.setAttribute("stockIn", stockIn);
		return "stockIn/addStockIn";
	}
	
	@RequestMapping("addUpdate")
	public String addUpdateStockIn(HttpServletRequest request,StockIn stockIn){
		int num=0;
		
		if(stockIn.getId()==0){//添加
			stockIn.setStockInDate(new Date());
			stockIn.setStatus("1");
			num=stockInService.add(stockIn);
		}else{//修改
			num=stockInService.update(stockIn);
		}
		
		if(num>0){//成功
			return "redirect:/stockIn/list";
		}
		return "forward:/error.jsp";
	}
	@RequestMapping("delete/{id}")
	public String deleteStockIn(@PathVariable int id){
		int num=stockInService.delete(id);
		if(num>0){//成功
			return "redirect:/stockIn/list";
		}
		return "forward:/error.jsp";		
	}
	//查询详情
	@RequestMapping("detail/{id}")
	@ResponseBody
	public StockIn detailStockIn(@PathVariable int id){
		StockIn stockIn=stockInService.findById(id);
		return stockIn;
	}
	//修改状态
	@RequestMapping("updateStatus")
	public String updateStatus(int status,int id){
		int num=stockInService.updateStatus(status, id);
		if(num>0){//成功
			return "redirect:/stockIn/list";
		}
		return "forward:/error.jsp";		
	}
	//商品入库
	@RequestMapping("ruku")
	public String ruku(int status,int id,int goodsId,int stockInNum){
		//修改入库单状态
		int num1=stockInService.updateStatus(status, id);
		//添加商品库存数量
		int num2=goodsService.addTotalNum(stockInNum, goodsId);
		if(num1+num2>1){//成功
			return "redirect:/goods/list";
		}
		return "forward:/error.jsp";		
		
	}
	//统计
	@RequestMapping("tongji")
	public String tongji(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		//按商品名称统计入库单
		List<GoodsView> stockInView=stockInService.tongjiByGoodsName();
		//生成饼状图
		ViewUtil.pieChar(request,response,stockInView);
		
		//生成柱状图
		ViewUtil.barChar(request,response,stockInView);
		
		//跳转页面显示
		return "stockIn/tongji";
					
		
	}
	
	
	
}
