package com.zeng.ssm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zeng.ssm.common.AbstractModel;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class FunctionUnitData extends AbstractModel {

//    private Integer sceneDataId;
//    private SceneData sceneData;
    private Integer inputFrameDataId;
//    private InputFrameData inputFrameData;
    private float functionValue;
    private String functionUnit;
    private String functionDescription;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date updatedAt;

//    public Integer getSceneDataId() {
//        return sceneDataId;
//    }
//
//    public void setSceneDataId(Integer sceneDataId) {
//        this.sceneDataId = sceneDataId;
//    }

    public Integer getInputFrameDataId() {
        return inputFrameDataId;
    }

    public void setInputFrameDataId(Integer inputFrameDataId) {
        this.inputFrameDataId = inputFrameDataId;
    }

    public float getFunctionValue() {
        return functionValue;
    }

    public void setFunctionValue(float functionValue) {
        this.functionValue = functionValue;
    }

    public String getFunctionUnit() {
        return functionUnit;
    }

    public void setFunctionUnit(String functionUnit) {
        this.functionUnit = functionUnit;
    }

    public String getFunctionDescription() {
        return functionDescription;
    }

    public void setFunctionDescription(String functionDescription) {
        this.functionDescription = functionDescription;
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
