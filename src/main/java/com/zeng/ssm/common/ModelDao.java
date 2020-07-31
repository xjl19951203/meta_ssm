package com.zeng.ssm.common;


import java.util.List;

public interface ModelDao {

    int deleteByPrimaryKey(Integer pk);

    int insert(AbstractModel record);

    int insert(List<AbstractModel> records);

    int insertSelective(AbstractModel record);

    List<AbstractModel> selectByContent(String content);

//    List<AbstractModel> selectByPage(Integer page,Integer size);

//    List<AbstractModel> selectAllBySearch(QueryMap queryMap);

    List<AbstractModel> selectAll();

//    List selectAllUnlimited();

    AbstractModel selectByPrimaryKey(Integer pk);

    List<AbstractModel> selectRepeatItem(AbstractModel model);

    int updateByPrimaryKeySelective(AbstractModel record);

    int updateByPrimaryKey(AbstractModel record);

}