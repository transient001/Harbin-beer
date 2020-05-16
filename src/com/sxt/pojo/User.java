package com.sxt.pojo;

import java.util.Date;

public class User {
	private int id;
	private String userName;
	private String realName;
	private String password;
	private String sex;
	private String email;
	private Date hiredate;
	private int roleId;
	
	private String roleName;
	private Role role;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", realName="
				+ realName + ", password=" + password + ", sex=" + sex
				+ ", email=" + email + ", hiredate=" + hiredate + ", roleId="
				+ roleId + ", roleName=" + roleName + ", role=" + role + "]";
	}
	public User(int id, String userName, String realName, String password,
			String sex, String email, Date hiredate, int roleId,
			String roleName, Role role) {
		super();
		this.id = id;
		this.userName = userName;
		this.realName = realName;
		this.password = password;
		this.sex = sex;
		this.email = email;
		this.hiredate = hiredate;
		this.roleId = roleId;
		this.roleName = roleName;
		this.role = role;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
