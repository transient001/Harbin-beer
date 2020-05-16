package com.sxt.pojo;

public class Goods {
	private int id;
	private String goodsName;
	private double price;
	private int totalNum;
	private int categoryId;
	private int level;
	
	private Category category;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", goodsName=" + goodsName + ", price="
				+ price + ", totalNum=" + totalNum + ", categoryId="
				+ categoryId + ", level=" + level + ", category=" + category
				+ "]";
	}

	public Goods(int id, String goodsName, double price, int totalNum,
			int categoryId, int level, Category category) {
		super();
		this.id = id;
		this.goodsName = goodsName;
		this.price = price;
		this.totalNum = totalNum;
		this.categoryId = categoryId;
		this.level = level;
		this.category = category;
	}

	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}


}
