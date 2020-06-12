package com.zeng.ssm.dao;

import com.zeng.ssm.common.ModelDao;
import com.zeng.ssm.model.InputFrame;

import java.util.List;

public interface InputFrameDao extends ModelDao {

    List<InputFrame> selectInputFrameListBySceneDataId (Integer pk);

}
