package com.zeng.ssm.model;

import com.zeng.ssm.common.AbstractModel;
import com.zeng.ssm.common.Searchable;

import java.util.List;

public class Material extends Searchable{

    private String title;
    private String description;
    private String type;
    private String origin;
    private String source;
    private List<MaterialLoad> materialLoadList;


    public List<MaterialLoad> getMaterialLoadList() {
        return materialLoadList;
    }

    public void setMaterialLoadList(List<MaterialLoad> materialLoadList) {
        this.materialLoadList = materialLoadList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getModelType() {
        return "material";
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
