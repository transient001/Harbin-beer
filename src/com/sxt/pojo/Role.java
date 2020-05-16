package com.sxt.pojo;

import java.util.List;

public class Role {
	private int id;
	private String roleName;
	
	private Right right;
	private List<Right> rightList;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Right getRight() {
		return right;
	}
	public void setRight(Right right) {
		this.right = right;
	}
	public List<Right> getRightList() {
		return rightList;
	}
	public void setRightList(List<Right> rightList) {
		this.rightList = rightList;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + ", right=" + right
				+ ", rightList=" + rightList + "]";
	}
	public Role(int id, String roleName, Right right, List<Right> rightList) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.right = right;
		this.rightList = rightList;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
