package com.qfedu.controller;

import java.util.Iterator;

import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qfedu.common.JsonBean;
import com.qfedu.pojo.SysUser;
import com.qfedu.service.SysUserService;
import com.qfedu.utils.JsonUtils;

@Controller
@Validated
public class LoginController {

	@Autowired
	private SysUserService userService;
	
	@RequestMapping("/login.do")
	@ResponseBody
	public JsonBean login(String name, String password, HttpSession session) {
		JsonBean bean = null;
		try {
			SysUser user = userService.login(name, password);
			session.setAttribute("user", user);
			bean = JsonUtils.createJsonBean(1, null);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean = JsonUtils.createJsonBean(0, e.getMessage());
			
		}
		return bean;
	}
	
	
	public JsonBean exception(ConstraintViolationException e) {
		String expInfo = null;
		
		Iterator<ConstraintViolation<?>> iterator = e.getConstraintViolations().iterator();
		
		while(iterator.hasNext()){
			ConstraintViolation<?> next = iterator.next();
			// 获取验证不通过的信息
			System.out.println(next.getMessage());
			expInfo += next.getMessage() + ";";
		}
		System.out.println("exception method");
		return JsonUtils.createJsonBean(0, expInfo);
		
	}
	
}
