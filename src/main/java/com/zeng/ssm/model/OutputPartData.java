package com.zeng.ssm.model;

import com.zeng.ssm.common.AbstractModel;

public class OutputPartData extends AbstractModel {

    private String title;
    private Integer sceneDataId;
    private SceneData sceneData;
    private float yieldRate;
    private String description;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSceneDataId() {
        return sceneDataId;
    }

    public void setSceneDataId(Integer sceneDataId) {
        this.sceneDataId = sceneDataId;
    }

    public SceneData getSceneData() {
        return sceneData;
    }

    public void setSceneData(SceneData sceneData) {
        this.sceneData = sceneData;
    }

    public float getYieldRate() {
        return yieldRate;
    }

    public void setYieldRate(float yieldRate) {
        this.yieldRate = yieldRate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
