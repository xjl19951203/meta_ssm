package com.zeng.ssm.dao;

import com.zeng.ssm.common.ModelDao;
import com.zeng.ssm.model.FunctionUnitData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FunctionUnitDataDao extends ModelDao {

    List<FunctionUnitData> selectFunctionUnitDataListByInputFrameDataId(Integer pk);
}
