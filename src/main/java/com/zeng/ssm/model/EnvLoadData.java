package com.zeng.ssm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zeng.ssm.common.AbstractModel;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class EnvLoadData extends  AbstractModel {

//    private Integer sceneDataId;
//    private SceneData sceneData;
//    private Integer inputFrameDataId;
//    private InputFrameData inputFrameData;
    private Integer outputFrameDataId;
//    private OutputFrameData outputFrameData;
    private Integer envLoadId;
    private EnvLoad envLoad;
    private float value;
    private Integer unitId;
    private Unit unit;
    private String description;
    private int deviceId;
    private Device device;
    private int collectReasonId;
    private CollectReason collectReason;
    private int monitorRangeId;
    private MonitorRange monitorRange;
    private String frequency;
    private String location;
    private int collectMethodId;
    private CollectMethod collectMethod;
    private String time;
    private String reliability;
    private int calculateMethodId;
    private CalculateMethod calculateMethod;
    private String treatment;
    private int monitorMethodId;
    private MonitorMethod monitorMethod;
    private int collectProblemId;
    private CollectProblem collectProblem;
    private int dataSourceId;
    private DataSource dataSource;

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

//    public Integer getInputFrameDataId() {
//        return inputFrameDataId;
//    }
//
//    public void setInputFrameId(Integer inputFrameId) {
//        this.inputFrameDataId = inputFrameDataId;
//    }

    public Integer getOutputFrameDataId() {
        return outputFrameDataId;
    }

    public void setOutputFrameDataId(Integer outputFrameDataId) {
        this.outputFrameDataId = outputFrameDataId;
    }

    public Integer getEnvLoadId() {
        return envLoadId;
    }

    public void setEnvLoadId(Integer envLoadId) {
        this.envLoadId = envLoadId;
    }

    public EnvLoad getEnvLoad() {
        return envLoad;
    }

    public void setEnvLoad(EnvLoad envLoad) {
        this.envLoad = envLoad;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getCollectReasonId() {
        return collectReasonId;
    }

    public void setCollectReasonId(int collectReasonId) {
        this.collectReasonId = collectReasonId;
    }

    public CollectReason getCollectReason() {
        return collectReason;
    }

    public void setCollectReason(CollectReason collectReason) {
        this.collectReason = collectReason;
    }

    public int getMonitorRangeId() {
        return monitorRangeId;
    }

    public void setMonitorRangeId(int monitorRangeId) {
        this.monitorRangeId = monitorRangeId;
    }

    public MonitorRange getMonitorRange() {
        return monitorRange;
    }

    public void setMonitorRange(MonitorRange monitorRange) {
        this.monitorRange = monitorRange;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCollectMethodId() {
        return collectMethodId;
    }

    public void setCollectMethodId(int collectMethodId) {
        this.collectMethodId = collectMethodId;
    }

    public CollectMethod getCollectMethod() {
        return collectMethod;
    }

    public void setCollectMethod(CollectMethod collectMethod) {
        this.collectMethod = collectMethod;
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

    public int getCalculateMethodId() {
        return calculateMethodId;
    }

    public void setCalculateMethodId(int calculateMethodId) {
        this.calculateMethodId = calculateMethodId;
    }

    public CalculateMethod getCalculateMethod() {
        return calculateMethod;
    }

    public void setCalculateMethod(CalculateMethod calculateMethod) {
        this.calculateMethod = calculateMethod;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public int getMonitorMethodId() {
        return monitorMethodId;
    }

    public void setMonitorMethodId(int monitorMethodId) {
        this.monitorMethodId = monitorMethodId;
    }

    public MonitorMethod getMonitorMethod() {
        return monitorMethod;
    }

    public void setMonitorMethod(MonitorMethod monitorMethod) {
        this.monitorMethod = monitorMethod;
    }

    public int getCollectProblemId() {
        return collectProblemId;
    }

    public void setCollectProblemId(int collectProblemId) {
        this.collectProblemId = collectProblemId;
    }

    public CollectProblem getCollectProblem() {
        return collectProblem;
    }

    public void setCollectProblem(CollectProblem collectProblem) {
        this.collectProblem = collectProblem;
    }

    public int getDataSourceId() {
        return dataSourceId;
    }

    public void setDataSourceId(int dataSourceId) {
        this.dataSourceId = dataSourceId;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
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
