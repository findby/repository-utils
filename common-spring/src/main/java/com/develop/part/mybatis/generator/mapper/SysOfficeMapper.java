package com.develop.part.mybatis.generator.mapper;

import com.develop.part.mybatis.generator.pojo.SysOffice;

public interface SysOfficeMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(SysOffice record);

    int insertSelective(SysOffice record);

    SysOffice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysOffice record);

    int updateByPrimaryKey(SysOffice record);
}