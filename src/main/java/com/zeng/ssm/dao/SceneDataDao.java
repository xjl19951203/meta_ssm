package com.zeng.ssm.dao;

import com.zeng.ssm.common.AbstractModel;
import com.zeng.ssm.common.ModelDao;
import com.zeng.ssm.model.SceneData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SceneDataDao extends ModelDao{

    List<SceneData> selectAll(Integer categoryRootId);

    List<SceneData> selectListByCategoryId(Integer categoryId);

//    AbstractModel selectRepeatItem(SceneData sceneData);

    AbstractModel selectSimpleByPrimaryKey(Integer pk);

    List<SceneData> selectBySearch(SceneData scenedata);

}
