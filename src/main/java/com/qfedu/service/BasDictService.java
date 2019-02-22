package com.qfedu.service;

import com.qfedu.pojo.BasDict;

import java.util.Map;

public interface BasDictService {

	public Map<String, Object> findByPage(int page);

	public void addBasDict(BasDict basDict);
}
