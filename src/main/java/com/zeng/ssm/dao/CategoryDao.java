package com.zeng.ssm.dao;

import com.zeng.ssm.common.ModelDao;
import com.zeng.ssm.model.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryDao extends ModelDao{

    List<Category> selectCategoryTree();

    List<Category> selectCategoriesByCategoryId(Integer id);

}
