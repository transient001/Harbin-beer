package com.sxt.pojo;

public class Supplier {
	private int id;
	private String supplierName;
	private String address;
	private String mobile;
	private String userName;
	private String phone;
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Supplier [id=" + id + ", supplierName=" + supplierName
				+ ", address=" + address + ", mobile=" + mobile + ", userName="
				+ userName + ", phone=" + phone + ", status=" + status + "]";
	}
	public Supplier(int id, String supplierName, String address, String mobile,
			String userName, String phone, String status) {
		super();
		this.id = id;
		this.supplierName = supplierName;
		this.address = address;
		this.mobile = mobile;
		this.userName = userName;
		this.phone = phone;
		this.status = status;
	}
	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
