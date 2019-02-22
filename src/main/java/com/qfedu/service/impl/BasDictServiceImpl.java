package com.qfedu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qfedu.pojo.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qfedu.dao.BasDictMapper;
import com.qfedu.pojo.BasDict;
import com.qfedu.service.BasDictService;

@Service
public class BasDictServiceImpl implements BasDictService{

	@Autowired
	private BasDictMapper dictDao;
	
	@Override
	public Map<String, Object> findByPage(int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 5);
		// list中是分页后的数据
		List<BasDict> list = dictDao.selectAll();
		
		Map<String, Object> map = new HashMap<>();
		map.put("total", ((Page)list).getTotal());// 总记录个数
		map.put("rows", list);// 分页的数据
		
		return map;
	}

	@Override
	public void addBasDict(BasDict basDict) {

		dictDao.insertSelective(basDict);

	}

}
