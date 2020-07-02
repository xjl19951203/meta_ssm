package com.zeng.ssm.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BatchAssistDao {
    List<String> selectColumnsByTableName (String tableName);
}
