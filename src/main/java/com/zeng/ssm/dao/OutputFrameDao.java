package com.zeng.ssm.dao;

import com.zeng.ssm.common.ModelDao;
import com.zeng.ssm.model.OutputFrame;

import java.util.List;

public interface OutputFrameDao extends ModelDao {

    List<OutputFrame> selectOutputFrameListByInputFrameId (Integer pk);

}
