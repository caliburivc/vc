package com.qfedu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qfedu.common.JsonBean;
import com.qfedu.pojo.SysRole;
import com.qfedu.service.SysRoleService;
import com.qfedu.utils.JsonUtils;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private SysRoleService roleService;
	
	@RequestMapping("/list.do")
	@ResponseBody
	public JsonBean findAllRole() {
		
		JsonBean bean = null;
		
		try {
			List<SysRole> list = roleService.findAllRole();
			bean = JsonUtils.createJsonBean(1, list);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean = JsonUtils.createJsonBean(0, e.getMessage());
		}
		return bean;
	}
	
	
}
