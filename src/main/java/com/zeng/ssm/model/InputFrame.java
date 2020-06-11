package com.zeng.ssm.model;
import com.zeng.ssm.common.Searchable;

import java.util.List;

public class InputFrame extends Searchable {
    private Integer sceneDataId;
//    private SceneData sceneData;

    private List<MaterialData> materialDataList;
    private List<DeviceData> deviceDataList;
    private List<EnergyData> energyDataList;
    private List<FunctionUnit> functionUnitList;
    private List<KeyParameterData> keyParameterDataList;

    public Integer getSceneDataId() {
        return sceneDataId;
    }

    public void setSceneDataId(Integer sceneDataId) {
        this.sceneDataId = sceneDataId;
    }

//    public SceneData getSceneData() {
//        return sceneData;
//    }
//
//    public void setSceneData(SceneData sceneData) {
//        this.sceneData = sceneData;
//    }

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

    public List<FunctionUnit> getFunctionUnitList() {
        return functionUnitList;
    }

    public void setFunctionUnitList(List<FunctionUnit> functionUnitList) {
        this.functionUnitList = functionUnitList;
    }

    public List<KeyParameterData> getKeyParameterDataList() {
        return keyParameterDataList;
    }

    public void setKeyParameterDataList(List<KeyParameterData> keyParameterDataList) {
        this.keyParameterDataList = keyParameterDataList;
    }
}
