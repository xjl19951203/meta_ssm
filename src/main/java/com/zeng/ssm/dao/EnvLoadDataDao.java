package com.zeng.ssm.dao;

import com.zeng.ssm.common.ModelDao;
import com.zeng.ssm.model.EnvLoadData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EnvLoadDataDao extends ModelDao{
    List<EnvLoadData> selectEnvLoadDataListByOutputFrameDataId (Integer pk);
}
