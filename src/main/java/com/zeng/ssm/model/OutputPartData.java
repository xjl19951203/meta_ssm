package com.zeng.ssm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zeng.ssm.common.AbstractModel;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class OutputPartData extends AbstractModel {

    private String title;
    private Integer sceneDataId;
    private SceneData sceneData;
    private Integer sceneDataFrameId;
    private SceneDataFrame sceneDataFrame;
    private boolean category;
    private float yieldRate;
    private String description;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date updatedAt;

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

    public Integer getSceneDataFrameId() {
        return sceneDataFrameId;
    }

    public void setSceneDataFrameId(Integer sceneDataFrameId) {
        this.sceneDataFrameId = sceneDataFrameId;
    }

    public SceneDataFrame getSceneDataFrame() {
        return sceneDataFrame;
    }

    public void setSceneDataFrame(SceneDataFrame sceneDataFrame) {
        this.sceneDataFrame = sceneDataFrame;
    }

    public boolean isCategory() {
        return category;
    }

    public void setCategory(boolean category) {
        this.category = category;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
