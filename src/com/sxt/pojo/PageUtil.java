package com.sxt.pojo;

import java.util.List;

public class PageUtil {
	private int pageSize;
	private int currPage;
	private int totalNum;
	private int totalPage;
	private int startNum;
	private List<?> pageList;
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	public int getTotalPage() {
		if(totalNum%pageSize==0){
			return totalNum/pageSize;
		}
		return totalNum/pageSize+1;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getStartNum() {
		return (currPage-1)*pageSize;
	}
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	public List<?> getPageList() {
		return pageList;
	}
	public void setPageList(List<?> pageList) {
		this.pageList = pageList;
	}
	@Override
	public String toString() {
		return "PageUtil [pageSize=" + pageSize + ", currPage=" + currPage
				+ ", totalNum=" + totalNum + ", totalPage=" + totalPage
				+ ", startNum=" + startNum + ", pageList=" + pageList + "]";
	}
	public PageUtil(int pageSize, int currPage, int totalNum, int totalPage,
			int startNum, List<?> pageList) {
		super();
		this.pageSize = pageSize;
		this.currPage = currPage;
		this.totalNum = totalNum;
		this.totalPage = totalPage;
		this.startNum = startNum;
		this.pageList = pageList;
	}
	public PageUtil() {
		super();
		// TODO Auto-generated constructor stub
	}

}
