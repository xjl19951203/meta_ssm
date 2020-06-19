package com.zeng.ssm.model;
import com.zeng.ssm.common.Searchable;

import java.util.List;

public class InputFrameData extends Searchable {

    private Integer id;
    private Integer sceneDataId;
    private SceneData sceneData;

    private List<MaterialData> materialDataList;
    private List<DeviceData> deviceDataList;
    private List<EnergyData> energyDataList;
    private List<FunctionUnitData> functionUnitDataList;
    private List<KeyParameterData> keyParameterDataList;
    private List<OutputFrameData> outputFrameDataList;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
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

    public List<MaterialData> getMaterialDataList() {
        return materialDataList;
    }

    public void setMaterialDataList(List<MaterialData> materialDataList) {
        this.materialDataList = materialDataList;
    }

    public List<DeviceData> getDeviceDataList() {
        return deviceDataList;
    }

    public void setDeviceDataList(List<DeviceData> deviceDataList) {
        this.deviceDataList = deviceDataList;
    }

    public List<EnergyData> getEnergyDataList() {
        return energyDataList;
    }

    public void setEnergyDataList(List<EnergyData> energyDataList) {
        this.energyDataList = energyDataList;
    }

    public List<FunctionUnitData> getFunctionUnitDataList() {
        return functionUnitDataList;
    }

    public void setFunctionUnitDataList(List<FunctionUnitData> functionUnitDataList) {
        this.functionUnitDataList = functionUnitDataList;
    }

    public List<KeyParameterData> getKeyParameterDataList() {
        return keyParameterDataList;
    }

    public void setKeyParameterDataList(List<KeyParameterData> keyParameterDataList) {
        this.keyParameterDataList = keyParameterDataList;
    }

    public List<OutputFrameData> getOutputFrameDataList() {
        return outputFrameDataList;
    }

    public void setOutputFrameDataList(List<OutputFrameData> outputFrameDataList) {
        this.outputFrameDataList = outputFrameDataList;
    }
}
