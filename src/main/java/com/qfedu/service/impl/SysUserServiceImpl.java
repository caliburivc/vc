package com.qfedu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qfedu.dao.SysUserMapper;
import com.qfedu.pojo.SysUser;
import com.qfedu.service.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService{

	@Autowired
	private SysUserMapper userDao;
	
	@Override
	public SysUser login(String name, String password) {
		// TODO Auto-generated method stub
		
		SysUser user = userDao.selectByName(name);
		if(user == null) {
			throw new RuntimeException("用户名错误");
		}
		
		if (user.getUsrFlag().equals("0")) {
			throw new RuntimeException("用户已禁用");
		}
		
		if (!user.getUsrPassword().equals(password)) {
			throw new RuntimeException("密码错误");
		}
		return user;
		
	}

	@Override
	public Map<String, Object> findByPage(int page) {
		// TODO Auto-generated method stub
		/*
		DEBUG - ==>  Preparing: SELECT count(0) FROM sys_user 
				DEBUG - ==> Parameters: 
				DEBUG - <==      Total: 1
				DEBUG - ==>  Preparing: select usr_id, usr_name, usr_password, urs_role_id, usr_flag from sys_user LIMIT ? 
				DEBUG - ==> Parameters: 10(Integer)
				DEBUG - <==      Total: 1
		*/
		// pageHelper插件中提供方法，后面一定要紧跟着一个执行查询操作的方法
		// 第一个参数，页码；第二个参数，每页显示的记录
//		Page<Object> startPage = PageHelper.startPage(page, 10);
		PageHelper.startPage(page, 5);
		// list中是分页后的数据
		List<SysUser> list = userDao.selectAll();
		
		Map<String, Object> map = new HashMap<>();
		map.put("total", ((Page)list).getTotal());// 总记录个数
		map.put("rows", list);// 分页的数据
		
		return map;
	}
	
	@Override
	public void addUser(SysUser user) {
		
		//判断用户名是否存在
		SysUser user2 = userDao.selectByName(user.getUsrName());
		if (user2 == null) {
			userDao.insertSelective(user);
		} else {
			throw new RuntimeException("用户已存在");
		}
	}
	
	@Override
	public void deleteUserByUid(int id) {
		SysUser user = new SysUser();
		user.setUsrId(id);
		user.setUsrFlag("0");
		
		userDao.updateByPrimaryKeySelective(user);
	}

	@Override
	public void addMultiUser(List<SysUser> list) {
		// TODO Auto-generated method stub
		userDao.insertMultiInfo(list);
	}

	@Override
	public Map<String, Object> searchByName(int page, String usrName) {

		PageHelper.startPage(page, 5);
		// list中是分页后的数据
		List<SysUser> list = userDao.searchAll(usrName);

		Map<String, Object> map = new HashMap<>();
		map.put("total", ((Page)list).getTotal());// 总记录个数
		map.put("rows", list);// 分页的数据

		return map;
	}
}
