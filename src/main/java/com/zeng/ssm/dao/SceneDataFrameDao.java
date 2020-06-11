package com.zeng.ssm.dao;

import com.zeng.ssm.common.AbstractModel;
import com.zeng.ssm.common.ModelDao;

import java.util.List;

public interface SceneDataFrameDao extends ModelDao {

    List<SceneDataFrame> selectSceneDataFrameListBySceneDataId(Integer pk);

    List<AbstractModel> selectSimpleSceneDataFrameListBySceneDataId(Integer pk);
}
