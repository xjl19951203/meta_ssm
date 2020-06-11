package com.zeng.ssm.dao;

import com.zeng.ssm.common.ModelDao;

import java.util.List;

public interface KeyParameterDataDao extends ModelDao {
    List<KeyParameter> selectKeyParameterDataListBySceneDataId (Integer pk);
}
