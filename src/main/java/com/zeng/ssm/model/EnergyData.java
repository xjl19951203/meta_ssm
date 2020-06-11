package com.zeng.ssm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zeng.ssm.common.AbstractModel;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class EnergyData extends AbstractModel {

    private Integer sceneDataId;
    private Integer sceneDataFrameId;
    private SceneDataFrame sceneDataFrame;
    private Integer energyId;
    private Energy energy;
    private Integer unitId;
    private Unit unit;
    private String value;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date updatedAt;

    private String origin;
    private int deviceId;
    private Device device;

    public Integer getSceneDataId() {
        return sceneDataId;
    }

    public void setSceneDataId(Integer sceneDataId) {
        this.sceneDataId = sceneDataId;
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

    public Integer getEnergyId() {
        return energyId;
    }

    public void setEnergyId(Integer energyId) {
        this.energyId = energyId;
    }

    public Energy getEnergy() {
        return energy;
    }

    public void setEnergy(Energy energy) {
        this.energy = energy;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
}
