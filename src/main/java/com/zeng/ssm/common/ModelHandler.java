package com.zeng.ssm.common;

import com.alibaba.fastjson.JSON;
import com.zeng.ssm.model.SystemColumnData;
import com.zeng.ssm.model.SystemTableData;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

/**
 * 不加component，得不到上下文信息
  */
@Component
public class ModelHandler implements ApplicationContextAware {

    /**
     * 上下文对象实例
     */
    private static ApplicationContext applicationContext;

    /**
     * 设置当前SSM环境的上下文实例
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ModelHandler.applicationContext = applicationContext;
    }

    /**
     * 通过表名拼接成 Model完整的名字
     * 例如： envLoadData => com.zeng.ssm.model.EnvLoadData
     */
    //substring参数左闭右开，将表名的驼峰命名法修改成类名的所有单词首字母大写的类名
    public static String getModelName(String tableName) {
        tableName = tableName.substring(0, 1).toUpperCase().concat(tableName.substring(1));
        return Configuration.modelRoot + tableName;
    }

    /**
     * 根据 (1)表名 (2) json格式的表单字符串，构建实例化后的相应 Model实例
     */
    public static AbstractModel newModelInstance(String tableName, String json) {
        String className = getModelName(tableName);
        try {
            Class<AbstractModel> c1 = (Class<AbstractModel>) Class.forName(className);
            return JSON.parseObject(json, c1.getDeclaredConstructor().newInstance().getClass());
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过表名拼接成 Dao完整的名字
     * 例如： envLoadData => com.zeng.ssm.dao.EnvLoadDataDao
     */
    public static String getDaoName(String tableName) {
        tableName = tableName.substring(0, 1).toUpperCase().concat(tableName.substring(1));
        return Configuration.daoRoot + tableName + "Dao";
    }

    /**
     * 根据表名从spring bean容器中，得到 ModelDao对应的实例
     */
    public static ModelDao getModelDaoInstance(String tableName) {
        String daoName = getDaoName(tableName);
        try {
            Class<ModelDao> cl = (Class<ModelDao>) Class.forName(daoName);
            // 通过class获取Bean.
            return applicationContext.getBean(cl);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取当前数据库中，所有表的数据（除去数据表，即涵盖基础表、辅助表等）
     * 目的是用于：为前端增添/编辑外键字段时，提供下拉框选项
     * 设计说明：为方便前端的外键字段快速获取与其应用的数据，所以此处将外键的字段名称和其数据集合组成键值对，构造成 HashMap
     * 例如：外键字段名称为 envLoad，其表名为env_load, 那么键值对为 <envLoad, List<EnvLoad>>
     */
    synchronized public static HashMap<String, List<AbstractModel>> getAllTableData() {
        HashMap<String, List<AbstractModel>> map = new HashMap<>();
        //根据systemTableData表名获取systemTableDataDao的实例，并调用selectAll方法，将获取到的AbstractModel类型的数据放在list中
        List<AbstractModel> tableList = getModelDaoInstance("systemTableData").selectAll();
        for (AbstractModel table : tableList) {
//            System.out.println(table.getTableName());
            String regex = ".*Data$";
            // 滤过数据表，只处理基础表
            if (table.getTableName().matches(regex)) {
                continue;
            }
//            System.out.println(table.getTableName());
            //强制类型转换，将AbstrModel类型的table转换为SystemTableData类型
            SystemTableData tableData = (SystemTableData) table;
            // 构造外键字段与其数据的键值对之前，先将外键对应表名转成驼峰法
            tableData.setTableName(formatTableName(tableData.getTableName(), tableData.getSystemColumnList()));
            // i从1开始，略过第一个转换
            map.put(table.getTableName(), getModelDaoInstance(table.getTableName()).selectAll());
        }
        return map;
    }

    /**
     * tableName是MySQL数据表命名规则，以_分割单词
     * 该函数将_分割的写法，转换为驼峰法，以便数据表名称和字段名称匹配
     * 例如：将表明由 "env_load_data"设置为"envLoadData"
     *
     * @param tableName 为 SystemTableData 的 tableName字段
     * @param columnDataList 为 SystemTableData 的 columnDataList 集合字段
     * @return 可获取SystemTableData格式化后的 tableName，并且将columnDataList的tableName也一并格式化了
     */
    public synchronized static String formatTableName(String tableName, List<SystemColumnData> columnDataList) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] arr = tableName.split("_");
        stringBuilder.setLength(0);
        stringBuilder.append(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            //
            stringBuilder.append(arr[i].substring(0,1).toUpperCase().concat(arr[i].substring(1)));
        }
        if (columnDataList != null) {
            for (SystemColumnData columnData : columnDataList) {
                columnData.setTableName(formatTableName(columnData.getTableName(), null));
            }
        }
        return stringBuilder.toString();
    }
}
