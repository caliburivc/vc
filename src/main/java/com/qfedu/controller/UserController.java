package com.qfedu.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qfedu.common.JsonBean;
import com.qfedu.pojo.SysUser;
import com.qfedu.service.SysUserService;
import com.qfedu.utils.JsonUtils;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private SysUserService userService;
	
	@RequestMapping("/list.do")
	@ResponseBody
	public JsonBean findUserByPage(int page) {
		
		JsonBean bean = null;
		
		try {
			Map<String, Object> map = userService.findByPage(page);
			bean = JsonUtils.createJsonBean(1, map);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean = JsonUtils.createJsonBean(0, e.getMessage());
		}
		
		return bean;
	} 
	
	@RequestMapping("/add.do")
	@ResponseBody
	public JsonBean addSysUser(SysUser user) {
		JsonBean bean = null;
		
		try {
			userService.addUser(user);
			bean = JsonUtils.createJsonBean(1, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean = JsonUtils.createJsonBean(0, e.getMessage());
		}
		
		return bean;
	}
	
	@RequestMapping("/delete.do")
	@ResponseBody
	public JsonBean deleteUserById(int id) {
		JsonBean bean = null;
		
		try {
			userService.deleteUserByUid(id);
			bean = JsonUtils.createJsonBean(1, null);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean = JsonUtils.createJsonBean(0, e.getMessage());
		}
		return bean;
	}

	@RequestMapping("/userselect.do")
	@ResponseBody
	public JsonBean selectByName(int page, String usrName){
		JsonBean bean = null;

		try {
			Map<String, Object> map = userService.searchByName(page,usrName);

			bean = JsonUtils.createJsonBean(1, map);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean = JsonUtils.createJsonBean(0, e.getMessage());
		}

		return bean;
	}
	
}
