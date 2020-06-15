package com.zeng.ssm.dao;

import com.zeng.ssm.common.ModelDao;
import com.zeng.ssm.model.MaterialData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MaterialDataDao extends ModelDao{
    List<MaterialData> selectMaterialDataListByInputFrameDataId (Integer pk);
}
