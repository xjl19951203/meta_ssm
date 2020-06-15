package com.zeng.ssm.dao;

import com.zeng.ssm.common.ModelDao;
import com.zeng.ssm.model.KeyParameterData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface KeyParameterDataDao extends ModelDao {
    List<KeyParameterData> selectKeyParameterDataListByInputFrameDataId (Integer pk);
}
