package com.zeng.ssm.dao;

import com.zeng.ssm.common.AbstractModel;
import com.zeng.ssm.common.ModelDao;
import com.zeng.ssm.model.Category;
import com.zeng.ssm.model.SceneData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryDao extends ModelDao{
//
    List<Category> selectCategoryTree();

    Category selectSimpleByPrimaryKey(Integer pk);

    List<Category> selectCategoriesByCategoryId(Integer id);

    List<Category> selectBySelectivePrimaryKey(Integer pk);

    List<Category> selectBySearchPrimaryKey(Integer pk);
}
