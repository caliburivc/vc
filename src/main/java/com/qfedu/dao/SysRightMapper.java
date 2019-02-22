package com.qfedu.dao;

import java.util.List;

import com.qfedu.pojo.SysRight;
import com.qfedu.vo.VMenuInfo;

public interface SysRightMapper {
    int deleteByPrimaryKey(Integer rightCode);

    int insert(SysRight record);

    int insertSelective(SysRight record);

    SysRight selectByPrimaryKey(Integer rightCode);

    int updateByPrimaryKeySelective(SysRight record);

    int updateByPrimaryKey(SysRight record);
    
    //跟角色id查询其所拥有的权限数据
    public List<SysRight> selectByRoleId(Integer rid);
    
    public List<VMenuInfo> selectByRid(Integer rid);
    
}