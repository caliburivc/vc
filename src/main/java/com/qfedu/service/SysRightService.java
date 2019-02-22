package com.qfedu.service;

import java.util.List;

import com.qfedu.vo.VMenuInfo;

public interface SysRightService {

	public List<VMenuInfo> findRightByRid(Integer rid);
}
