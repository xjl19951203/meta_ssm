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
    }


}
