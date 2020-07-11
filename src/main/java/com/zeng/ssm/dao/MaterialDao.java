package com.zeng.ssm.dao;

import com.zeng.ssm.common.ModelDao;
import com.zeng.ssm.model.Material;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MaterialDao extends ModelDao{
    Material selectByMaterialName(String materialName);
}
