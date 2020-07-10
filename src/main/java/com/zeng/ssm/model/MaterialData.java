package com.zeng.ssm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zeng.ssm.common.AbstractModel;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class MaterialData extends AbstractModel {

//    private Integer sceneDataId;
//    private SceneData sceneData;
    private Integer inputFrameDataId;
//    private InputFrameData inputFrameData;
    private Integer materialId;
    private Material material;
    private Integer materialDataCategoryId;
    private MaterialDataCategory materialDataCategory;
    private float value;
    private Integer unitId;
    private Unit unit;
    private Integer dataSourceId;
    private DataSource dataSource;
    private String time;
    private String reliability;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date updatedAt;

    public Integer getInputFrameDataId() {
        return inputFrameDataId;
    }

    public void setInputFrameDataId(Integer inputFrameDataId) {
        this.inputFrameDataId = inputFrameDataId;
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Integer getMaterialDataCategoryId() {
        return materialDataCategoryId;
    }

    public void setMaterialDataCategoryId(Integer materialDataCategoryId) {
        this.materialDataCategoryId = materialDataCategoryId;
    }

    public MaterialDataCategory getMaterialDataCategory() {
        return materialDataCategory;
    }

    public void setMaterialDataCategory(MaterialDataCategory materialDataCategory) {
        this.materialDataCategory = materialDataCategory;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Integer getDataSourceId() {
        return dataSourceId;
    }

    public void setDataSourceId(Integer dataSourceId) {
        this.dataSourceId = dataSourceId;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getReliability() {
        return reliability;
    }

    public void setReliability(String reliability) {
        this.reliability = reliability;
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
