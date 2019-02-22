package com.qfedu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qfedu.common.JsonBean;
import com.qfedu.pojo.SysUser;
import com.qfedu.service.SysRightService;
import com.qfedu.utils.JsonUtils;
import com.qfedu.vo.VMenuInfo;

@Controller
public class MenuController {

	@Autowired
	private SysRightService rightService;
	
	@RequestMapping("/menu.do")
	@ResponseBody
	public JsonBean menuInfo(HttpSession session) {
		JsonBean bean = null;
		SysUser user = (SysUser) session.getAttribute("user");
		if (user != null) {
			try {
				List<VMenuInfo> list = rightService.findRightByRid(user.getUsrRoleId());
				bean = JsonUtils.createJsonBean(1, list);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				bean = JsonUtils.createJsonBean(0, e.getMessage());
			}
		} else {
			bean = JsonUtils.createJsonBean(0, "无法获取菜单信息");
		}
		
		return bean;
	
	
	
	
	
	
	
	
	
	}
	
	
	
}
