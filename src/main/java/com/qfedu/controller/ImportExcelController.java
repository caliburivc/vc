package com.qfedu.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qfedu.common.JsonBean;
import com.qfedu.pojo.SysUser;
import com.qfedu.service.SysUserService;
import com.qfedu.utils.ExcelUtils;
import com.qfedu.utils.JsonUtils;

@Controller
public class ImportExcelController {

	@Autowired
	private SysUserService userService;
	
	// web方式下导入excel数据，要借助文件上传的操作，但是不用保存文件
	@RequestMapping("/importExcel.do")
	@ResponseBody
	public JsonBean importExcel(@RequestParam MultipartFile excelFile){
		JsonBean bean = null;
		// 获取上传的文件名
		String fileName = excelFile.getOriginalFilename();
		// 获取上传文件的输入流
		InputStream inputStream = null;
		try {
			inputStream = excelFile.getInputStream();
			List<Map<String, Object>> list = ExcelUtils.readExcel2(fileName, inputStream);
			//System.out.println(list);
			
			// jackson中将对象转字符串，json字符串转为对象
			ObjectMapper objMapper = new ObjectMapper();
			//对象转字符串
			String jsonStr = objMapper.writeValueAsString(list);
			// json字符串转为指定对象
			List<SysUser> userList = objMapper.readValue(jsonStr, new TypeReference<List<SysUser>>(){});
			
			userService.addMultiUser(userList);
			
			bean = JsonUtils.createJsonBean(1, "导入成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean = JsonUtils.createJsonBean(0, "导入失败");
		}
		
		return bean;
	}
	
	@RequestMapping("/exportExcel.do")
	public void exportExcel(HttpServletResponse response){
		String file = "aa.xlsx";
		// 如果文件名包含中文，需要进行转换
		try {
			file = URLEncoder.encode(file, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					
		// 设置Content-Disposition响应头
		response.setHeader("Content-Disposition", "attachment;filename=" + file);
		
		// 获取响应的输出流
		try {
			ServletOutputStream outputStream = response.getOutputStream();
			
			ExcelUtils.exportExcel(outputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
