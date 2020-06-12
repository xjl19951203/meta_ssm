package com.zeng.ssm.dao;

import com.zeng.ssm.common.ModelDao;
import com.zeng.ssm.model.FunctionUnitData;
import java.util.List;

public interface FunctionUnitDataDao extends ModelDao {
    List<FunctionUnitData> selectFunctionUnitDataListByInputFrameId(Integer pk);
}
