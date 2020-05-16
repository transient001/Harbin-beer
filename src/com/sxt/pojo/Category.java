package com.sxt.pojo;

import java.util.List;

public class Category {
	private int id;
	private String categoryName;
	private int parentId;
	private Category category;
	private List<Category> childList;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<Category> getChildList() {
		return childList;
	}
	public void setChildList(List<Category> childList) {
		this.childList = childList;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", categoryName=" + categoryName
				+ ", parentId=" + parentId + ", category=" + category
				+ ", childList=" + childList + "]";
	}
	public Category(int id, String categoryName, int parentId,
			Category category, List<Category> childList) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.parentId = parentId;
		this.category = category;
		this.childList = childList;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
