package com.zeng.ssm.service;

import com.zeng.ssm.common.AbstractModel;
import com.zeng.ssm.dao.*;
import com.zeng.ssm.model.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.streaming.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
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

    @RequestMapping(value="/baseTable/{tableName}", method = RequestMethod.GET)
    public void downloadFile (@PathVariable String tableName, HttpServletResponse response) throws Exception {

//        System.out.println(filePath);
//        创建Excel对象
        SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook();
//        创建Excel中的sheet对象
        SXSSFSheet sxssfSheet = sxssfWorkbook.createSheet(tableName+"表");
//        设置sheet中的默认列宽
        sxssfSheet.setDefaultColumnWidth(15);
//        创建sheet中的第一行
        SXSSFRow row = sxssfSheet.createRow(0);
//        通过传入的表名生成相应的类
        Class<AbstractModel> cc = (Class<AbstractModel>) Class.forName("com.zeng.ssm.model."+tableName);
//        System.out.println(cc.toString());
//        利用构造器获取类的对象
//        AbstractModel model = cc.getDeclaredConstructor().newInstance();
//        List<String> list = new ArrayList<>();
        Field[] fs=cc.getDeclaredFields();
        //设置私有属性的访问权限
//        Field.setAccessible(true);
        int i=0; //单元格计数器
        for(Field f:fs){
            //f为单个属性
//           设置不可见的属性为可见的
            f.setAccessible(true);
//           创建单元格
            Cell cell = row.createCell(i++);
//            将属性名放到上面创建的单元格中
            cell.setCellValue(f.getName());//获取属性名
        }
//        设定编码格式
//        response.setCharacterEncoding("utf-8");
////        编辑导出的表名
//        String encode = URLEncoder.encode(tableName,"utf-8");
//        System.out.println(encode);
////        获得输出流
//        ServletOutputStream out = response.getOutputStream();
////        设置下载响应头
////        response.setHeader("content-Type","attachment/fileName="+encode+".xlsx");
////        将生成的文件写入输出流,提供下载
//        sxssfWorkbook.write(out);
//        System.out.println(sxssfWorkbook);
        ServletOutputStream out;
        try {
            //构造输出流
            out = response.getOutputStream();
            //构建文件名
            String fileName = tableName+".xlsx";
            response.reset();
            response.setContentType("application/msexcel");
            response.setHeader("Content-disposition", "attachment; filename="+fileName);
            sxssfWorkbook.write(out);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
