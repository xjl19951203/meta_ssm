package com.zeng.ssm.service;

import com.zeng.ssm.dao.*;
import com.zeng.ssm.model.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

import java.util.List;

@CrossOrigin
@RestController
@EnableAutoConfiguration
//@RequestMapping("/api/batch")
@RequestMapping("/api/batch/json")
public class BatchJsonController {
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

//    @RequestMapping(value="/sceneData", method = RequestMethod.POST)
    @RequestMapping(value="/sceneData", method = RequestMethod.POST)
    public int sceneDataBatch (@RequestBody SceneData sceneData) {
        try {
            if (sceneData!=null) {
                this.sceneDataDao.insert(sceneData);
                List<InputFrameData> inputFrameDataList = sceneData.getInputFrameDataList();
                if (inputFrameDataList!=null) {
                    for (InputFrameData inputFrameData :inputFrameDataList) {
                        inputFrameData.setSceneDataId(sceneData.getId());
                        this.inputFrameDataDao.insert(inputFrameData);
                        List<MaterialData> materialDataList = inputFrameData.getMaterialDataList();
                        if (materialDataList!=null) {
                            for (MaterialData materialData:materialDataList) {
                                materialData.setInputFrameDataId(inputFrameData.getId());
                                this.materialDataDao.insert(materialData);
                            }
                        }
                        List<EnergyData> energyDataList = inputFrameData.getEnergyDataList();
                        if (energyDataList!=null) {
                            for (EnergyData energyData:energyDataList) {
                                energyData.setInputFrameDataId(inputFrameData.getId());
                                this.energyDataDao.insert(energyData);
                            }
                        }
                        List<DeviceData> deviceDataList = inputFrameData.getDeviceDataList();
                        if (deviceDataList!=null) {
                            for (DeviceData deviceData : deviceDataList) {
                                deviceData.setInputFrameDataId(inputFrameData.getId());
                                this.deviceDataDao.insert(deviceData);
                            }
                        }
                        List<KeyParameterData> keyParameterDataList = inputFrameData.getKeyParameterDataList();
                        if (keyParameterDataList!=null) {
                            for (KeyParameterData keyParameterData : keyParameterDataList) {
                                keyParameterData.setInputFrameDataId(inputFrameData.getId());
                                this.keyParameterDataDao.insert(keyParameterData);
                            }
                        }
                        List<FunctionUnitData> functionUnitDataList = inputFrameData.getFunctionUnitDataList();
                        if (functionUnitDataList!=null) {
                            for (FunctionUnitData functionUnitData : functionUnitDataList) {
                                functionUnitData.setInputFrameDataId(inputFrameData.getId());
                                this.functionUnitDataDao.insert(functionUnitData);
                            }
                        }
                        List<OutputFrameData> outputFrameDataList = inputFrameData.getOutputFrameDataList();
                        if (outputFrameDataList!=null) {
                            for (OutputFrameData outputFrameData : outputFrameDataList) {
                                outputFrameData.setInputFrameDataId(inputFrameData.getId());
                                this.outputFrameDataDao.insert(outputFrameData);
                                List<EnvLoadData> envLoadDataList = outputFrameData.getEnvLoadDataList();
                                if (envLoadDataList!=null) {
                                    for (EnvLoadData envLoadData : envLoadDataList) {
                                        envLoadData.setOutputFrameDataId(outputFrameData.getId());
                                        this.envLoadDataDao.insert(envLoadData);
                                    }
                                }
                                List<OutputPartData> outputPartDataList = outputFrameData.getOutputPartDataList();
                                if (outputPartDataList!=null) {
                                    for (OutputPartData outputPartData : outputPartDataList) {
                                        outputPartData.setOutputFrameDataId(outputFrameData.getId());
                                        this.outputPartDataDao.insert(outputPartData);
                                    }
                                }
                            }
                        }
                    }
                }
                return sceneData.getId();
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

//    @RequestMapping(value="/sceneDataList", method = RequestMethod.POST)
    @RequestMapping(value="/sceneDataList", method = RequestMethod.POST)
    public List<SceneData> sceneDataListBatch (@RequestBody List<SceneData> record) {
        try {
            if (record!=null) {
                for (SceneData sceneData:record) {
                    if (sceneData!=null) {
                        this.sceneDataDao.insert(sceneData);
                        List<InputFrameData> inputFrameDataList = sceneData.getInputFrameDataList();
                        if (inputFrameDataList!=null) {
                            for (InputFrameData inputFrameData :inputFrameDataList) {
                                inputFrameData.setSceneDataId(sceneData.getId());
                                this.inputFrameDataDao.insert(inputFrameData);
                                List<MaterialData> materialDataList = inputFrameData.getMaterialDataList();
                                if (materialDataList!=null) {
                                    for (MaterialData materialData:materialDataList) {
                                        materialData.setInputFrameDataId(inputFrameData.getId());
                                        this.materialDataDao.insert(materialData);
                                    }
                                }
                                List<EnergyData> energyDataList = inputFrameData.getEnergyDataList();
                                if (energyDataList!=null) {
                                    for (EnergyData energyData:energyDataList) {
                                        energyData.setInputFrameDataId(inputFrameData.getId());
                                        this.energyDataDao.insert(energyData);
                                    }
                                }
                                List<DeviceData> deviceDataList = inputFrameData.getDeviceDataList();
                                if (deviceDataList!=null) {
                                    for (DeviceData deviceData : deviceDataList) {
                                        deviceData.setInputFrameDataId(inputFrameData.getId());
                                        this.deviceDataDao.insert(deviceData);
                                    }
                                }
                                List<KeyParameterData> keyParameterDataList = inputFrameData.getKeyParameterDataList();
                                if (keyParameterDataList!=null) {
                                    for (KeyParameterData keyParameterData : keyParameterDataList) {
                                        keyParameterData.setInputFrameDataId(inputFrameData.getId());
                                        this.keyParameterDataDao.insert(keyParameterData);
                                    }
                                }
                                List<FunctionUnitData> functionUnitDataList = inputFrameData.getFunctionUnitDataList();
                                if (functionUnitDataList!=null) {
                                    for (FunctionUnitData functionUnitData : functionUnitDataList) {
                                        functionUnitData.setInputFrameDataId(inputFrameData.getId());
                                        this.functionUnitDataDao.insert(functionUnitData);
                                    }
                                }
                                List<OutputFrameData> outputFrameDataList = inputFrameData.getOutputFrameDataList();
                                if (outputFrameDataList!=null) {
                                    for (OutputFrameData outputFrameData : outputFrameDataList) {
                                        outputFrameData.setInputFrameDataId(inputFrameData.getId());
                                        this.outputFrameDataDao.insert(outputFrameData);
                                        List<EnvLoadData> envLoadDataList = outputFrameData.getEnvLoadDataList();
                                        if (envLoadDataList!=null) {
                                            for (EnvLoadData envLoadData : envLoadDataList) {
                                                envLoadData.setOutputFrameDataId(outputFrameData.getId());
                                                this.envLoadDataDao.insert(envLoadData);
                                            }
                                        }
                                        List<OutputPartData> outputPartDataList = outputFrameData.getOutputPartDataList();
                                        if (outputPartDataList!=null) {
                                            for (OutputPartData outputPartData : outputPartDataList) {
                                                outputPartData.setOutputFrameDataId(outputFrameData.getId());
                                                this.outputPartDataDao.insert(outputPartData);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return record;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//    @RequestMapping(value="/inputFrameDataList", method = RequestMethod.POST)
    @RequestMapping(value="/inputFrameDataList", method = RequestMethod.POST)
    public List<InputFrameData> inputFrameDataBatch (@RequestParam(defaultValue="-1") Integer sceneDataId, @RequestBody List<InputFrameData> record) {
        if (sceneDataId==-1) {
            return null;
        }
        try {
            if (record!=null) {
                for (InputFrameData inputFrameData :record) {
                    inputFrameData.setSceneDataId(sceneDataId);
                    this.inputFrameDataDao.insert(inputFrameData);
                    List<MaterialData> materialDataList = inputFrameData.getMaterialDataList();
                    if (materialDataList!=null) {
                        for (MaterialData materialData:materialDataList) {
                            materialData.setInputFrameDataId(inputFrameData.getId());
                            this.materialDataDao.insert(materialData);
                        }
                    }
                    List<EnergyData> energyDataList = inputFrameData.getEnergyDataList();
                    if (energyDataList!=null) {
                        for (EnergyData energyData:energyDataList) {
                            energyData.setInputFrameDataId(inputFrameData.getId());
                            this.energyDataDao.insert(energyData);
                        }
                    }
                    List<DeviceData> deviceDataList = inputFrameData.getDeviceDataList();
                    if (deviceDataList!=null) {
                        for (DeviceData deviceData : deviceDataList) {
                            deviceData.setInputFrameDataId(inputFrameData.getId());
                            this.deviceDataDao.insert(deviceData);
                        }
                    }
                    List<KeyParameterData> keyParameterDataList = inputFrameData.getKeyParameterDataList();
                    if (keyParameterDataList!=null) {
                        for (KeyParameterData keyParameterData : keyParameterDataList) {
                            keyParameterData.setInputFrameDataId(inputFrameData.getId());
                            this.keyParameterDataDao.insert(keyParameterData);
                        }
                    }
                    List<FunctionUnitData> functionUnitDataList = inputFrameData.getFunctionUnitDataList();
                    if (functionUnitDataList!=null) {
                        for (FunctionUnitData functionUnitData : functionUnitDataList) {
                            functionUnitData.setInputFrameDataId(inputFrameData.getId());
                            this.functionUnitDataDao.insert(functionUnitData);
                        }
                    }
                    List<OutputFrameData> outputFrameDataList = inputFrameData.getOutputFrameDataList();
                    if (outputFrameDataList!=null) {
                        for (OutputFrameData outputFrameData : outputFrameDataList) {
                            outputFrameData.setInputFrameDataId(inputFrameData.getId());
                            this.outputFrameDataDao.insert(outputFrameData);
                            List<EnvLoadData> envLoadDataList = outputFrameData.getEnvLoadDataList();
                            if (envLoadDataList!=null) {
                                for (EnvLoadData envLoadData : envLoadDataList) {
                                    envLoadData.setOutputFrameDataId(outputFrameData.getId());
                                    this.envLoadDataDao.insert(envLoadData);
                                }
                            }
                            List<OutputPartData> outputPartDataList = outputFrameData.getOutputPartDataList();
                            if (outputPartDataList!=null) {
                                for (OutputPartData outputPartData : outputPartDataList) {
                                    outputPartData.setOutputFrameDataId(outputFrameData.getId());
                                    this.outputPartDataDao.insert(outputPartData);
                                }
                            }
                        }
                    }
                }
                return record;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//    @RequestMapping(value="/outputFrameDataList", method = RequestMethod.POST)
    @RequestMapping(value="/outputFrameDataList", method = RequestMethod.POST)
    public List<OutputFrameData> outputFrameDataBatch (@RequestParam(defaultValue="-1") Integer inputFrameDataId, @RequestBody List<OutputFrameData> record) {
        if (inputFrameDataId==-1) {
            return null;
        }
        try {
            if (record!=null) {
                for (OutputFrameData outputFrameData : record) {
                    outputFrameData.setInputFrameDataId(inputFrameDataId);
                    this.outputFrameDataDao.insert(outputFrameData);
                    List<EnvLoadData> envLoadDataList = outputFrameData.getEnvLoadDataList();
                    if (envLoadDataList!=null) {
                        for (EnvLoadData envLoadData : envLoadDataList) {
                            envLoadData.setOutputFrameDataId(outputFrameData.getId());
                            this.envLoadDataDao.insert(envLoadData);
                        }
                    }
                    List<OutputPartData> outputPartDataList = outputFrameData.getOutputPartDataList();
                    if (outputPartDataList!=null) {
                        for (OutputPartData outputPartData : outputPartDataList) {
                            outputPartData.setOutputFrameDataId(outputFrameData.getId());
                            this.outputPartDataDao.insert(outputPartData);
                        }
                    }
                }
                return record;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//    @RequestMapping(value="/materialList", method = RequestMethod.POST)
    @RequestMapping(value="/materialList", method = RequestMethod.POST)
    public List<Material> materialBatch (@RequestBody List<Material> materials) {
        try {
            if (materials!=null) {
                for (Material material:materials) {
                    this.materialDao.insert(material);
                }
                return materials;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//    @RequestMapping(value="/energyList", method = RequestMethod.POST)
    @RequestMapping(value="/energyList", method = RequestMethod.POST)
    public List<Energy> energyBatch (@RequestBody List<Energy> energys) {
        try {
            if (energys!=null) {
                for (Energy energy:energys) {
                    this.energyDao.insert(energy);
                }
                return energys;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//    @RequestMapping(value="/deviceList", method = RequestMethod.POST)
    @RequestMapping(value="/deviceList", method = RequestMethod.POST)
    public List<Device> deviceBatch (@RequestBody List<Device> devices) {
        try {
            if (devices!=null) {
                for (Device device:devices) {
                    this.deviceDao.insert(device);
                }
                return devices;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//    @RequestMapping(value="/envLoadList", method = RequestMethod.POST)
    @RequestMapping(value="/envLoadList", method = RequestMethod.POST)
    public List<EnvLoad> envLoadBatch (@RequestBody List<EnvLoad> envLoads) {
        try {
            if (envLoads!=null) {
                for (EnvLoad envLoad:envLoads) {
                    this.envLoadDao.insert(envLoad);
                }
                return envLoads;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
