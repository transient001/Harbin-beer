package com.sxt.pojo;

import java.util.Date;

public class StockOut {
	private int id;
	private String stockOutName;
	private Date stockOutDate;
	private int stockOutNum;
	private int goodsId;
	private int userId;
	private String status;	
	private String startTime;
	private String endTime;
	private String goodsName;
	private Goods goods;
	private User user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStockOutName() {
		return stockOutName;
	}
	public void setStockOutName(String stockOutName) {
		this.stockOutName = stockOutName;
	}
	public Date getStockOutDate() {
		return stockOutDate;
	}
	public void setStockOutDate(Date stockOutDate) {
		this.stockOutDate = stockOutDate;
	}
	public int getStockOutNum() {
		return stockOutNum;
	}
	public void setStockOutNum(int stockOutNum) {
		this.stockOutNum = stockOutNum;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
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
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "StockOut [id=" + id + ", stockOutName=" + stockOutName
				+ ", stockOutDate=" + stockOutDate + ", stockOutNum="
				+ stockOutNum + ", goodsId=" + goodsId + ", userId=" + userId
				+ ", status=" + status + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", goodsName=" + goodsName
				+ ", goods=" + goods + ", user=" + user + "]";
	}
	public StockOut(int id, String stockOutName, Date stockOutDate,
			int stockOutNum, int goodsId, int userId, String status,
			String startTime, String endTime, String goodsName, Goods goods,
			User user) {
		super();
		this.id = id;
		this.stockOutName = stockOutName;
		this.stockOutDate = stockOutDate;
		this.stockOutNum = stockOutNum;
		this.goodsId = goodsId;
		this.userId = userId;
		this.status = status;
		this.startTime = startTime;
		this.endTime = endTime;
		this.goodsName = goodsName;
		this.goods = goods;
		this.user = user;
	}
	public StockOut() {
		super();
		// TODO Auto-generated constructor stub
	}


}