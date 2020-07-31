package com.zeng.ssm.common;

import org.springframework.stereotype.Service;

import java.util.List;

@Service("modelDao")
public class ModelImpl implements ModelDao{

    private static String tableName;

    public static void setTableName(String tableName) {
        ModelImpl.tableName = tableName;
    }

    //根据id号删除数据
    @Override
    public int deleteByPrimaryKey(Integer pk) {
        return ModelHandler.getModelDaoInstance(tableName).deleteByPrimaryKey(pk);
    }

    //新增数据
    @Override
    public int insert(AbstractModel record) {
        ModelHandler.getModelDaoInstance(tableName).insert(record);
        return record.getId();
    }

    //新增多条数据（传入的是一个list）
    @Override
    public int insert(List<AbstractModel> records) {
        return 0;
    }

    //新增选择的数据
    @Override
    public int insertSelective(AbstractModel record) {
        return 0;
    }

    //查找与参数相关的所有model
    @Override
    public List<AbstractModel> selectByContent(String content) {
        return null;
    }

//    @Override
//    public List<AbstractModel> selectBySelectivePrimaryKey(Integer pk) {
//        ModelHandler.getModelDaoInstance(tableName)
//        return ;
//    }

    //查询某张表中的所有数据
    @Override
    public List<AbstractModel> selectAll() {
        return ModelHandler.getModelDaoInstance(tableName).selectAll();
    }

//    @Override
//    public List selectAllUnlimited() {
//        return ModelHandler.getModelDaoInstance(tableName).selectAllUnlimited();
//    }

//    @Override
//    public List<AbstractModel> selectByPage(Integer page,Integer size) {
//        return ModelHandler.getModelDaoInstance(tableName).selectByPage(page,size);
//    }

    //按传进来的id号查询表中的数据
    @Override
    public AbstractModel selectByPrimaryKey(Integer pk) {
        return ModelHandler.getModelDaoInstance(tableName).selectByPrimaryKey(pk);
    }

    //根据传进来的对象查询表中的重复对象
    @Override
    public List<AbstractModel> selectRepeatItem(AbstractModel model) {
        return ModelHandler.getModelDaoInstance(tableName).selectRepeatItem(model);
    }

    //根据选中的id号更新数据
    @Override
    public int updateByPrimaryKeySelective(AbstractModel record) {
        return 0;
    }

    //根据id号更新数据
    @Override
    public int updateByPrimaryKey(AbstractModel record) {
        return ModelHandler.getModelDaoInstance(tableName).updateByPrimaryKey(record);
    }


}
