package com.qfedu.service;

import java.util.List;
import java.util.Map;

import com.qfedu.pojo.SysUser;

public interface SysUserService {

	public SysUser login(String name, String password);

	public Map<String, Object> findByPage(int page);

	public void addUser(SysUser user);
	
	public void deleteUserByUid(int id);
	
	public void addMultiUser(List<SysUser> list);

	//public SysUser findByName(String name);

	public Map<String, Object> searchByName(int page, String usrName);

}
