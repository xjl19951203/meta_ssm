package com.zeng.ssm.dao;

import com.zeng.ssm.common.ModelDao;
import com.zeng.ssm.model.KeyParameterData;

import java.util.List;

public interface KeyParameterDataDao extends ModelDao {
    List<KeyParameterData> selectKeyParameterDataListByInputFrameId (Integer pk);
}
