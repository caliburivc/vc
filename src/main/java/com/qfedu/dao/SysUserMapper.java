package com.qfedu.dao;

import java.util.List;
import java.util.Map;

import com.qfedu.pojo.SysUser;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer usrId);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer usrId);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUser selectByName(String usrName);

    List<SysUser> searchAll(String usrName);

    Map<String, Object> searchByName(int page, String usrName);

    List<SysUser> selectAll();
    
    void insertMultiInfo(List<SysUser> list);
}