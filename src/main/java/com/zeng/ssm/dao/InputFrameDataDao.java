package com.zeng.ssm.dao;

import com.zeng.ssm.common.AbstractModel;
import com.zeng.ssm.common.ModelDao;
import com.zeng.ssm.model.InputFrameData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InputFrameDataDao extends ModelDao {

    List<InputFrameData> selectInputFrameDataListBySceneDataId (Integer pk);

//    AbstractModel selectInputFrameDataByPrimaryKey(Integer pk);
}
