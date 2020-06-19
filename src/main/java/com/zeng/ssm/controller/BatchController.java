package com.zeng.ssm.controller;

import com.zeng.ssm.dao.*;
import com.zeng.ssm.model.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/batch")
public class BatchController {
    @Resource
//    BatchDao batchDao;
    SceneDataDao sceneDataDao;
    InputFrameDataDao inputFrameDataDao;
    MaterialDataDao materialDataDao;
    EnergyDataDao energyDataDao;
    DeviceDataDao deviceDataDao;
    KeyParameterDataDao keyParameterDataDao;
    FunctionUnitDataDao functionUnitDataDao;
    OutputFrameDataDao outputFrameDataDao;
    EnvLoadDataDao envLoadDataDao;
    OutputPartDataDao outputPartDataDao;

    @RequestMapping(value="/sceneData", method = RequestMethod.POST)
    public int sceneDataPost (@RequestBody SceneData record) {
        try {
            this.sceneDataDao.insert(record);
            List<InputFrameData> inputFrameDatalist = record.getInputFrameDataList();
            for (InputFrameData inputFrameData :inputFrameDatalist) {
                inputFrameData.setSceneDataId(record.getId());
                this.inputFrameDataDao.insert(inputFrameData);
                List<MaterialData> materialDataList = inputFrameData.getMaterialDataList();
                for (MaterialData materialData:materialDataList) {
                    materialData.setInputFrameDataId(inputFrameData.getId());
                    this.materialDataDao.insert(materialData);
                }
                List<EnergyData> energyDataList = inputFrameData.getEnergyDataList();
                for (EnergyData energyData:energyDataList) {
                    energyData.setInputFrameDataId(inputFrameData.getId());
                    this.energyDataDao.insert(energyData);
                }
                List<DeviceData> deviceDataList = inputFrameData.getDeviceDataList();
                for (DeviceData deviceData:deviceDataList) {
                    deviceData.setInputFrameDataId(inputFrameData.getId());
                    this.deviceDataDao.insert(deviceData);
                }
                List<KeyParameterData> keyParameterDataList = inputFrameData.getKeyParameterDataList();
                for (KeyParameterData keyParameterData:keyParameterDataList) {
                    keyParameterData.setInputFrameDataId(inputFrameData.getId());
                    this.keyParameterDataDao.insert(keyParameterData);
                }
                List<FunctionUnitData> functionUnitDataList = inputFrameData.getFunctionUnitDataList();
                for (FunctionUnitData functionUnitData:functionUnitDataList) {
                    functionUnitData.setInputFrameDataId(inputFrameData.getId());
                    this.functionUnitDataDao.insert(functionUnitData);
                }
                List<OutputFrameData> outputFrameDataList = inputFrameData.getOutputFrameDataList();
                for (OutputFrameData outputFrameData:outputFrameDataList) {
                    outputFrameData.setInputFrameDataId(inputFrameData.getId());
                    this.outputFrameDataDao.insert(outputFrameData);
                    List<EnvLoadData> envLoadDataList = outputFrameData.getEnvLoadDataList();
                    for (EnvLoadData envLoadData:envLoadDataList) {
                        envLoadData.setOutputFrameDataId(outputFrameData.getId());
                        this.envLoadDataDao.insert(envLoadData);
                    }
                    List<OutputPartData> outputPartDataList = outputFrameData.getOutputPartDataList();
                    for (OutputPartData outputPartData:outputPartDataList) {
                        outputPartData.setOutputFrameDataId(outputFrameData.getId());
                        this.outputPartDataDao.insert(outputPartData);
                    }
                }
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }
    @RequestMapping(value="/sceneDataList", method = RequestMethod.POST)
    public int sceneDataListPost (@RequestBody List<SceneData> record) {
        for (SceneData sceneData:record) {
            this.sceneDataDao.insert(sceneData);
            List<InputFrameData> inputFrameDatalist = sceneData.getInputFrameDataList();
            for (InputFrameData inputFrameData :inputFrameDatalist) {
                inputFrameData.setSceneDataId(sceneData.getId());
                this.inputFrameDataDao.insert(inputFrameData);
                List<MaterialData> materialDataList = inputFrameData.getMaterialDataList();
                for (MaterialData materialData:materialDataList) {
                    this.materialDataDao.insert(materialData);
                }
                List<EnergyData> energyDataList = inputFrameData.getEnergyDataList();
                for (EnergyData energyData:energyDataList) {
                    this.energyDataDao.insert(energyData);
                }
                List<DeviceData> deviceDataList = inputFrameData.getDeviceDataList();
                for (DeviceData deviceData:deviceDataList) {
                    this.deviceDataDao.insert(deviceData);
                }
                List<KeyParameterData> keyParameterDataList = inputFrameData.getKeyParameterDataList();
                for (KeyParameterData keyParameterData:keyParameterDataList) {
                    this.keyParameterDataDao.insert(keyParameterData);
                }
                List<FunctionUnitData> functionUnitDataList = inputFrameData.getFunctionUnitDataList();
                for (FunctionUnitData functionUnitData:functionUnitDataList) {
                    this.functionUnitDataDao.insert(functionUnitData);
                }
//                List<FunctionUnitData> functionUnitDataList = inputFrameData.getFunctionUnitDataList();
//                for (FunctionUnitData functionUnitData:functionUnitDataList) {
//                    this.functionUnitDataDao.insert(functionUnitData);
//                }

            }

        }
        return 0;
    }


}
