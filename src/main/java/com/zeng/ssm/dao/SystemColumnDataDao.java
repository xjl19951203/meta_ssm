package com.zeng.ssm.dao;

import com.zeng.ssm.common.ModelDao;
import com.zeng.ssm.model.SystemColumnData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SystemColumnDataDao extends ModelDao{

    /**
     * 查找tableName所有的列
     */
    List<SystemColumnData> selectListByTableName (String tableName);

}
