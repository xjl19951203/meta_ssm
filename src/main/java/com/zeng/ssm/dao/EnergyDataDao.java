package com.zeng.ssm.dao;

import com.zeng.ssm.common.ModelDao;
import com.zeng.ssm.model.EnergyData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EnergyDataDao extends ModelDao{
    List<EnergyData> selectEnergyDataListByInputFrameDataId (Integer pk);
}
