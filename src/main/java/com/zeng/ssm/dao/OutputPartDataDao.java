package com.zeng.ssm.dao;

import com.zeng.ssm.common.ModelDao;
import com.zeng.ssm.model.OutputPartData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OutputPartDataDao extends ModelDao {
    List<OutputPartData> selectOutputPartDataListByOutputFrameDataId (Integer pk);
}
