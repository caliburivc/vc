package com.qfedu.dao;

import java.util.List;

import com.qfedu.pojo.BasDict;

public interface BasDictMapper {
    int deleteByPrimaryKey(Integer dictId);

    int insert(BasDict record);

    int insertSelective(BasDict record);

    BasDict selectByPrimaryKey(Integer dictId);

    int updateByPrimaryKeySelective(BasDict record);

    int updateByPrimaryKey(BasDict record);
    
    List<BasDict> selectAll();



   // BasDict select 
}