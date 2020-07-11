package com.zeng.ssm.dao;

import com.zeng.ssm.common.ModelDao;
import com.zeng.ssm.model.MaterialDataCategory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MaterialDataCategoryDao extends ModelDao{
    MaterialDataCategory selectByMaterialCategoryName(String materialCategoryName);
}
