package com.zeng.ssm.model;

import com.zeng.ssm.common.AbstractModel;

import java.util.List;

public class SystemTableData extends AbstractModel {

    private String tableName;
    private String tableComment;
    private List<SystemColumnData> systemColumnList;


    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableComment() {
        return tableComment;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    public List<SystemColumnData> getSystemColumnList() {
        return systemColumnList;
    }

    public void setSystemColumnList(List<SystemColumnData> systemColumnList) {
        this.systemColumnList = systemColumnList;
    }
}
