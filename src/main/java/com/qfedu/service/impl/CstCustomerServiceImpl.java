package com.qfedu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qfedu.dao.CstCustomerMapper;
import com.qfedu.pojo.CstCustomer;
import com.qfedu.service.CstCustomerService;

@Service
public class CstCustomerServiceImpl implements CstCustomerService{

	@Autowired
	private CstCustomerMapper cstDao;
	
	@Override
	public Map<String, Object> findByPage(int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 5);
		
		List<CstCustomer> list = cstDao.selectAll();
		
		Map<String, Object> map = new HashMap<>();
		map.put("total", ((Page)list).getTotal());
		map.put("rows", list);
		
		return map;
	}

}
