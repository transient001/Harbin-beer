package com.sxt.pojo;

import java.util.Date;

public class StockIn {
	private int id;
	private String stockInName;
	private Date stockInDate;
	private int stockInNum;
	private int goodsId;
	private int supplierId;
	private int userId;
	private String status;
	
	private String startTime;
	private String endTime;
	private String goodsName;
	private String supplierName;
	private Goods goods;
	private Supplier supplier;
	private User user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStockInName() {
		return stockInName;
	}
	public void setStockInName(String stockInName) {
		this.stockInName = stockInName;
	}
	public Date getStockInDate() {
		return stockInDate;
	}
	public void setStockInDate(Date stockInDate) {
		this.stockInDate = stockInDate;
	}
	public int getStockInNum() {
		return stockInNum;
	}
	public void setStockInNum(int stockInNum) {
		this.stockInNum = stockInNum;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "StockIn [id=" + id + ", stockInName=" + stockInName
				+ ", stockInDate=" + stockInDate + ", stockInNum=" + stockInNum
				+ ", goodsId=" + goodsId + ", supplierId=" + supplierId
				+ ", userId=" + userId + ", status=" + status + ", startTime="
				+ startTime + ", endTime=" + endTime + ", goodsName="
				+ goodsName + ", supplierName=" + supplierName + ", goods="
				+ goods + ", supplier=" + supplier + ", user=" + user + "]";
	}
	public StockIn(int id, String stockInName, Date stockInDate,
			int stockInNum, int goodsId, int supplierId, int userId,
			String status, String startTime, String endTime, String goodsName,
			String supplierName, Goods goods, Supplier supplier, User user) {
		super();
		this.id = id;
		this.stockInName = stockInName;
		this.stockInDate = stockInDate;
		this.stockInNum = stockInNum;
		this.goodsId = goodsId;
		this.supplierId = supplierId;
		this.userId = userId;
		this.status = status;
		this.startTime = startTime;
		this.endTime = endTime;
		this.goodsName = goodsName;
		this.supplierName = supplierName;
		this.goods = goods;
		this.supplier = supplier;
		this.user = user;
	}
	public StockIn() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
