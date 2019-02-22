package com.qfedu.common;

import java.util.List;

public class PageBean<T> {
	
	private Integer currentPage; //当前页
	private Integer totalPage; //总页数
	private Integer pageSize = 5;//每页显示数据数
	private List<T> pageInfos;//每页显示的数据列表
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getPageInfos() {
		return pageInfos;
	}
	public void setPageInfos(List<T> pageInfos) {
		this.pageInfos = pageInfos;
	}
	
	
}
