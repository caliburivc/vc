package com.qfedu.dao;

import java.util.List;

import com.qfedu.pojo.CstCustomer;

public interface CstCustomerMapper {
    int deleteByPrimaryKey(Integer custId);

    int insert(CstCustomer record);

    int insertSelective(CstCustomer record);

    CstCustomer selectByPrimaryKey(Integer custId);

    int updateByPrimaryKeySelective(CstCustomer record);

    int updateByPrimaryKey(CstCustomer record);
    
    List<CstCustomer> selectAll();
}