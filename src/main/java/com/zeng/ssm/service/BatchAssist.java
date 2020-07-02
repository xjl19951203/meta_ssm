package com.zeng.ssm.service;

import com.zeng.ssm.common.AbstractModel;
import com.zeng.ssm.common.Configuration;
import com.zeng.ssm.common.ModelDao;
import com.zeng.ssm.common.ModelHandler;

import java.util.HashMap;
import java.util.List;

public class BatchAssist {

    //根据表名获取数据表中的字段信息列表
    public static List getRemarksFromBaseTable (String tableName) throws ClassNotFoundException {
        //根据表名获取类对象
        String className = tableName.substring(0, 1).toUpperCase().concat(tableName.substring(1));
        Class<AbstractModel> cc = (Class<AbstractModel>) Class.forName(ModelHandler.getModelName(className));
        String daoName = className+"Dao";
        Class<ModelDao> cl = (Class<ModelDao>) Class.forName(ModelHandler.getDaoName(daoName));

        return null;

    }
}
