package com.qfedu.controller;

import java.util.Map;

import com.qfedu.pojo.BasDict;
import com.qfedu.pojo.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qfedu.common.JsonBean;
import com.qfedu.service.BasDictService;
import com.qfedu.utils.JsonUtils;

@Controller
@RequestMapping("/dict")
public class DictController {

	@Autowired
	private BasDictService dictService;
	
	
	@RequestMapping("/list.do")
	@ResponseBody
	public JsonBean findInfoByPage(int page) {
		JsonBean bean = null;
		
		try {
			Map<String, Object> map = dictService.findByPage(page);
			bean = JsonUtils.createJsonBean(1, map);
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean = JsonUtils.createJsonBean(0, e.getMessage());
		}
		return bean;
	}

	@RequestMapping("/adddict.do")
	@ResponseBody
	public JsonBean addBasDict(BasDict basDict) {
		JsonBean bean = null;

		try {
			dictService.addBasDict(basDict);
			bean = JsonUtils.createJsonBean(1, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean = JsonUtils.createJsonBean(0, e.getMessage());
		}

		return bean;
	}
	
}
