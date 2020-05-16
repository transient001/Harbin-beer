package com.sxt.controller;
 
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxt.pojo.PageUtil;
import com.sxt.pojo.StockIn;
import com.sxt.pojo.Supplier;
import com.sxt.service.SupplierService;

@Controller
@RequestMapping("supplier/")
public class SupplierController {
	@Resource
	private SupplierService supplierService;
	
	@RequestMapping("list")
	public String findSuppliers(HttpServletRequest request,Supplier supplier,@RequestParam(defaultValue="1") int currPage,@RequestParam(defaultValue="3") int pageSize){
		PageUtil pageUtil=new PageUtil();
		pageUtil.setCurrPage(currPage);
		pageUtil.setPageSize(pageSize);
		pageUtil = supplierService.findByPage(supplier, pageUtil);
		request.setAttribute("pageUtil",pageUtil);
		return "supplier/supplierList";
	}
	@RequestMapping("add")
	public String addSupplier(){
		return "supplier/addSupplier";
	}
	@RequestMapping("addUpdate")
	public String addUpdateSupplier(Supplier supplier){
		int num=0;
		if(supplier.getId()==0){//添加
			supplier.setStatus("1");
			num = supplierService.add(supplier);			
		}else{//修改
			num=supplierService.update(supplier);
		}
		if(num>0){//成功
			return "forward:/supplier/list";
		}
		return "forward:/error.jsp";
	}
	//修改
	@RequestMapping("load/{id}")
	public String load(@PathVariable int id,HttpServletRequest request){
		Supplier supplier = supplierService.findById(id);
		System.out.println(supplier);
		request.setAttribute("sp",supplier);
		return "supplier/addSupplier";
	}
	//删除
	@RequestMapping("delete/{id}")
	public String delete(@PathVariable int id){
		int num = supplierService.delete(id);
		if(num>0){//删除成功
			return "redirect:/supplier/list";
		}else{
			return "forward:/error.jsp";
		}
	}
	//查询详情
	@RequestMapping("detail/{id}")
	@ResponseBody
	public Supplier detailSupplier(@PathVariable int id){
		Supplier supplier=supplierService.findById(id);
		return supplier;
	}	
	
}
