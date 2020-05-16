package com.sxt.pojo;

public class RoleRight {
	private int roleId;
	private int rightId;
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getRightId() {
		return rightId;
	}
	public void setRightId(int rightId) {
		this.rightId = rightId;
	}
	@Override
	public String toString() {
		return "RoleRight [roleId=" + roleId + ", rightId=" + rightId + "]";
	}
	public RoleRight(int roleId, int rightId) {
		super();
		this.roleId = roleId;
		this.rightId = rightId;
	}
	public RoleRight() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
