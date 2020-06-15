package com.zeng.ssm.dao;

import com.zeng.ssm.common.ModelDao;
import com.zeng.ssm.model.OutputFrameData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OutputFrameDataDao extends ModelDao {

    List<OutputFrameData> selectOutputFrameDataListByInputFrameDataId (Integer pk);

}
