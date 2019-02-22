package com.qfedu.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qfedu.common.JsonBean;
import com.qfedu.service.CstCustomerService;
import com.qfedu.utils.JsonUtils;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CstCustomerService customerService;
	
	@RequestMapping("/custlist.do")
	@ResponseBody
	public JsonBean findInfoByPage(int page) {
		JsonBean bean = null;
		
		try {
			Map<String, Object> map = customerService.findByPage(page);
			bean = JsonUtils.createJsonBean(1, map);
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean = JsonUtils.createJsonBean(0, e.getMessage());
		}
		return bean;
	}
	
	
}
