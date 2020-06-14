package com.zeng.ssm.dao;

import com.zeng.ssm.common.AbstractModel;
import com.zeng.ssm.common.ModelDao;
import com.zeng.ssm.model.InputFrame;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InputFrameDao extends ModelDao {

    List<InputFrame> selectInputFrameListBySceneDataId (Integer pk);

    AbstractModel selectInputFrameByPrimaryKey(Integer pk);
}
