package com.zeng.ssm.dao;

import com.zeng.ssm.common.ModelDao;
import com.zeng.ssm.model.KeyParameter;

import java.util.List;

public interface KeyParameterDataDao extends ModelDao {
    List<KeyParameter> selectKeyParameterDataListBySceneDataId (Integer pk);
}
