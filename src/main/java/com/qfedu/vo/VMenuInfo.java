package com.qfedu.vo;

import java.util.List;

public class VMenuInfo {

	private String menuName;
	
	private String url;
	
	private List<VMenuInfo> cMenuList;
	
	private Integer id;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<VMenuInfo> getcMenuList() {
		return cMenuList;
	}

	public void setcMenuList(List<VMenuInfo> cMenuList) {
		this.cMenuList = cMenuList;
	}
	
	
	
	
}
