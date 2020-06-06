package com.zeng.ssm.dao;

import com.zeng.ssm.common.ModelDao;
import com.zeng.ssm.model.OutputPartData;

import java.util.List;

public interface OutputPartDataDao extends ModelDao {
    List<OutputPartData> selectOutputPartDataListBySceneDataId (Integer pk);
}
