package com.zeng.ssm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zeng.ssm.common.AbstractModel;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class DeviceData extends AbstractModel {

//    private Integer sceneDataId;
    private Integer inputFrameDataId;
//    private InputFrameData inputFrameData;
    private float workTime;
    private Integer deviceId;
    private Device device;

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

//    public InputFrame getInputFrameData() {
//        return inputFrameData;
//    }
//
//    public void setInputFrame(InputFrame inputFrame) {
//        this.inputFrameData = inputFrameData;
//    }

    public float getWorkTime() {
        return workTime;
    }

    public void setWorkTime(float workTime) {
        this.workTime = workTime;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
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
