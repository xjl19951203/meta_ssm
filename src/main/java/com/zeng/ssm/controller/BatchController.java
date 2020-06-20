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
    SceneDataDao sceneDataDao;
    @Resource
    InputFrameDataDao inputFrameDataDao;
    @Resource
    MaterialDataDao materialDataDao;
    @Resource
    EnergyDataDao energyDataDao;
    @Resource
    DeviceDataDao deviceDataDao;
    @Resource
    KeyParameterDataDao keyParameterDataDao;
    @Resource
    FunctionUnitDataDao functionUnitDataDao;
    @Resource
    OutputFrameDataDao outputFrameDataDao;
    @Resource
    EnvLoadDataDao envLoadDataDao;
    @Resource
    OutputPartDataDao outputPartDataDao;
    @Resource
    MaterialDao materialDao;
    @Resource
    EnergyDao energyDao;
    @Resource
    DeviceDao deviceDao;
    @Resource
    EnvLoadDao envLoadDao;

    @RequestMapping(value="/sceneData", method = RequestMethod.POST)
    public int sceneDataBatch (@RequestBody SceneData record) {
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
    public int sceneDataListBatch (@RequestBody List<SceneData> record) {
        try {
            for (SceneData sceneData:record) {
                this.sceneDataDao.insert(sceneData);
                List<InputFrameData> inputFrameDatalist = sceneData.getInputFrameDataList();
                for (InputFrameData inputFrameData :inputFrameDatalist) {
                    inputFrameData.setSceneDataId(sceneData.getId());
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
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @RequestMapping(value="/inputFrameDataList", method = RequestMethod.POST)
    public int inputFrameDataBatch (@RequestParam(defaultValue="-1") Integer sceneDataId, @RequestBody List<InputFrameData> record) {
        if (sceneDataId==-1) {
            return 0;
        }
        try {
            for (InputFrameData inputFrameData :record) {
                inputFrameData.setSceneDataId(sceneDataId);
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

    @RequestMapping(value="/outputFrameDataList", method = RequestMethod.POST)
    public int outputFrameDataBatch (@RequestParam(defaultValue="-1") Integer inputFrameDataId, @RequestBody List<OutputFrameData> record) {
        if (inputFrameDataId==-1) {
            return 0;
        }
        try {
            for (OutputFrameData outputFrameData :record) {
                outputFrameData.setInputFrameDataId(inputFrameDataId);
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
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @RequestMapping(value="/materialList", method = RequestMethod.POST)
    public int materialBatch (@RequestBody List<Material> materials) {
        try {
            for (Material material:materials) {
                this.materialDao.insert(material);
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @RequestMapping(value="/energyList", method = RequestMethod.POST)
    public int energyBatch (@RequestBody List<Energy> energys) {
        try {
            for (Energy energy:energys) {
                this.energyDao.insert(energy);
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @RequestMapping(value="/deviceList", method = RequestMethod.POST)
    public int deviceBatch (@RequestBody List<Device> devices) {
        try {
            for (Device device:devices) {
                this.deviceDao.insert(device);
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @RequestMapping(value="/envLoadList", method = RequestMethod.POST)
    public int envLoadBatch (@RequestBody List<EnvLoad> envLoads) {
        try {
            for (EnvLoad envLoad:envLoads) {
                this.envLoadDao.insert(envLoad);
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
