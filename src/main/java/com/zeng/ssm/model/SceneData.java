package com.zeng.ssm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zeng.ssm.common.Searchable;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class SceneData extends Searchable {

    private String title;
    private Integer categoryId;
    private Integer categoryRootId; // 标识分类大类，便于按大类查询
    private Category category;
    private String description;
    private String functionUnit;

    private List<MaterialData> materialDataList;
    private List<EnergyData> energyDataList;
    private List<DeviceData> deviceDataList;
    private List<EnvLoadData> envLoadDataList;
    private List<KeyParameterData> keyParameterDataList;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date updatedAt;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getCategoryRootId() {
        return categoryRootId;
    }

    public void setCategoryRootId(Integer categoryRootId) {
        this.categoryRootId = categoryRootId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFunctionUnit() {
        return functionUnit;
    }

    public void setFunctionUnit(String functionUnit) {
        this.functionUnit = functionUnit;
    }

    public List<MaterialData> getMaterialDataList() {
        return materialDataList;
    }

    public void setMaterialDataList(List<MaterialData> materialDataList) {
        this.materialDataList = materialDataList;
    }

    public List<EnergyData> getEnergyDataList() {
        return energyDataList;
    }

    public void setEnergyDataList(List<EnergyData> energyDataList) {
        this.energyDataList = energyDataList;
    }

    public List<DeviceData> getDeviceDataList() {
        return deviceDataList;
    }

    public void setDeviceDataList(List<DeviceData> deviceDataList) {
        this.deviceDataList = deviceDataList;
    }

    public List<EnvLoadData> getEnvLoadDataList() {
        return envLoadDataList;
    }

    public void setEnvLoadDataList(List<EnvLoadData> envLoadDataList) {
        this.envLoadDataList = envLoadDataList;
    }

    public List<KeyParameterData> getKeyParameterDataList() {
        return keyParameterDataList;
    }

    public void setKeyParameterDataList(List<KeyParameterData> keyParameterDataList) {
        this.keyParameterDataList = keyParameterDataList;
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

    @Override
    public String getModelType() {
        return "scene";
    }
}
