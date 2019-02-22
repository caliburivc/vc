package com.qfedu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qfedu.dao.SysRightMapper;
import com.qfedu.pojo.SysRight;
import com.qfedu.service.SysRightService;
import com.qfedu.vo.VMenuInfo;

@Service
public class SysRightServiceImpl implements SysRightService{
	
	@Autowired
	private SysRightMapper rightDao;
	
	@Override
	public List<VMenuInfo> findRightByRid(Integer rid) {
		// TODO Auto-generated method stub
		
		//根据角色id查权限
		List<SysRight> rightList = rightDao.selectByRoleId(rid);
		
		
		//封装成list<VMenuInfo>对象
		List<VMenuInfo> menuList = new ArrayList<>();
		
		for (SysRight right : rightList) {
			Integer ParentCode = right.getRightParentCode();
			if (ParentCode == null) {
				int flag = 0;
				for (VMenuInfo menuInfo : menuList) {
					if (menuInfo.getMenuName().equals(right.getRightName())) {
						flag = 1;
						break;
					}
				}
				if (flag == 0) {
					VMenuInfo mInfo = new VMenuInfo();
					mInfo.setId(right.getRightCode());
					mInfo.setMenuName(right.getRightName());
					mInfo.setUrl(right.getRightUrl());
					
					List<VMenuInfo> cList = new ArrayList<>();
					mInfo.setcMenuList(cList);
					
					menuList.add(mInfo);
				}
			} else {//子菜单
				for (VMenuInfo menuInfo : menuList) {
					//如找到子菜单对应的父菜单项
					if (right.getRightParentCode() == menuInfo.getId()) {
						VMenuInfo cMenu = new VMenuInfo();
						cMenu.setId(right.getRightCode());
						cMenu.setMenuName(right.getRightName());
						cMenu.setUrl(right.getRightUrl());
						
						//添加到父菜单项里
						menuInfo.getcMenuList().add(cMenu);
						
						break;
					}
				}
			}
			
		}
		
		return menuList;
	}

	
}
