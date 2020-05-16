package com.sxt.pojo;

import java.util.List;

public class Right {
	private int id;
	private String rightName;
	private int parentId;
	private String rightUrl;
	private int level;
	private List<Right> childRight;
	private Right right;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRightName() {
		return rightName;
	}
	public void setRightName(String rightName) {
		this.rightName = rightName;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getRightUrl() {
		return rightUrl;
	}
	public void setRightUrl(String rightUrl) {
		this.rightUrl = rightUrl;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public List<Right> getChildRight() {
		return childRight;
	}
	public void setChildRight(List<Right> childRight) {
		this.childRight = childRight;
	}
	public Right getRight() {
		return right;
	}
	public void setRight(Right right) {
		this.right = right;
	}
	public Right(int id, String rightName, int parentId, String rightUrl,
			int level, List<Right> childRight, Right right) {
		super();
		this.id = id;
		this.rightName = rightName;
		this.parentId = parentId;
		this.rightUrl = rightUrl;
		this.level = level;
		this.childRight = childRight;
		this.right = right;
	}
	public Right() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Right [id=" + id + ", rightName=" + rightName + ", parentId="
				+ parentId + ", rightUrl=" + rightUrl + ", level=" + level
				+ ", childRight=" + childRight + ", right=" + right + "]";
	}
	

}
