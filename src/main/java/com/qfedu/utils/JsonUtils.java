package com.qfedu.utils;

import com.qfedu.common.JsonBean;

public class JsonUtils {

	public static JsonBean createJsonBean(int code,Object info) {
		JsonBean bean = new JsonBean();
		
		bean.setCode(code);
		bean.setInfo(info);
		
		return bean;
	}
}
