package com.zeng.ssm.dao;

import com.zeng.ssm.common.ModelDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ParameterDataDao extends ModelDao{
    List<ParameterData> selectParameterDataListBySceneDataId(Integer pk);
}
