package com.zeng.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zeng.ssm.common.AbstractModel;
import com.zeng.ssm.common.ModelDao;
import com.zeng.ssm.common.ModelHandler;
import com.zeng.ssm.common.ModelImpl;
import com.zeng.ssm.dao.*;
import com.zeng.ssm.model.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/manage/{tableName}")
public class ManageController{

    @Resource
    ModelDao modelDao;
    @Resource
    SceneDataDao sceneDataDao;
    @Resource
    InputFrameDataDao inputFrameDataDao;
    @Resource
    MaterialDataDao materialDataDao;
    @Resource
    DeviceDataDao deviceDataDao;
    @Resource
    KeyParameterDataDao keyParameterDataDao;

   /*
   查询的时候就只查询单页数据，不查询其他数据
    */
//    @RequestMapping(value = "", method = RequestMethod.GET)
//    public PageResult getList(@PathVariable String tableName,@RequestParam(defaultValue="-100") Integer page,@RequestParam(defaultValue="-100") Integer size) {
//        ModelImpl.setTableName(tableName);
//        if (page == -100||size ==-100) {
//            List list=this.modelDao.selectAll();
//            PageResult pageResult = new PageResult();
//            pageResult.setCurrentPage(1);
//            pageResult.setCount((long)list.size());//总条数
//            pageResult.setData(list);//显示的数据
//            return pageResult;
//        }else {
//            PageHelper.startPage(page, size);
//            List list=this.modelDao.selectByPage((page-1)*size,size);
//            PageInfo pageInfo = new PageInfo(list);
//            PageResult pageResult = new PageResult();
//            pageResult.setCurrentPage(page);
//            pageResult.setCount(pageInfo.getTotal());//总条数
//            pageResult.setData(pageInfo.getList());//显示的数据
//            return pageResult;
//        }
//    }
    /*
    将所有的数据全部查询到了之后进行分页操作一次性打包
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public PageResult getLists(@PathVariable String tableName,@RequestParam(defaultValue="1") Integer currentPage,@RequestParam(defaultValue="7") Integer pageSize) {
        ModelImpl.setTableName(tableName);
        PageHelper.startPage(currentPage,pageSize);
        List<AbstractModel> list = this.modelDao.selectAll();
        PageInfo<AbstractModel> pageInfo = new PageInfo<>(list);
//        System.out.println("PageSize: "+pageInfo.getPageSize()); //3  每页包含的条数
        PageResult pageResult = new PageResult();
        pageResult.setCurrentPage(pageInfo.getPageNum());//当前页
        pageResult.setCurrentPageSize(pageInfo.getSize());
        pageResult.setPageSize(pageSize);//设定页的数目
        pageResult.setPages(pageInfo.getPages());//总页数
        pageResult.setCount(pageInfo.getTotal());//总条数
        pageResult.setData(pageInfo.getList());//显示的数据
        return pageResult;

    }

//    @RequestMapping(value = "", method = RequestMethod.GET)
//    public List<AbstractModel> getLists(@PathVariable String tableName) {
//        ModelImpl.setTableName(tableName);
//        return this.modelDao.selectAll();
//    }

    @RequestMapping(value = "/{pk}", method = RequestMethod.GET)
    public AbstractModel get(@PathVariable String tableName, @PathVariable Integer pk){
        ModelImpl.setTableName(tableName);
        return this.modelDao.selectByPrimaryKey(pk);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public int post(@PathVariable String tableName, @RequestBody String record){
        if (tableName.equals("sceneData")) {
            JSONObject jsonObject= JSON.parseObject(record);
            String sceneData = jsonObject.getString("sceneData");
//            System.out.println(sceneData);
            String materialDataIdList = jsonObject.getString("materialDataList").substring(1,jsonObject.getString("materialDataList").length()-1);
            String[] temp = materialDataIdList.split(",");
            String deviceDataIdList = jsonObject.getString("deviceDataList").substring(1,jsonObject.getString("deviceDataList").length()-1);
            String[] temp1 = deviceDataIdList.split(",");
            String keyParameterDataList = jsonObject.getString("keyParameterDataList").substring(1,jsonObject.getString("keyParameterDataList").length()-1);
            String[] temp2 = keyParameterDataList.split(",");
            SceneData scene = (SceneData)ModelHandler.newModelInstance("sceneData", sceneData);
//            AbstractModel repeatScene = this.sceneDataDao.selectRepeatItem(scene);
//            if (repeatScene!=null) {
//                System.out.println(repeatScene.getId());
//                List<InputFrameData> inputFrameDataList =this.inputFrameDataDao.selectInputFrameDataListBySceneDataId(repeatScene.getId());
//                if (inputFrameDataList.size()==0) {
//                    if (materialDataIdList.equals("")&&deviceDataIdList.equals("")) {
//                        return repeatScene.getId();
//                    } else {
//                        System.out.println(1);
//                        this.sceneDataDao.insert(scene);
//                        return scene.getId();
//                    }
//                } else {
//                    List<MaterialData> materialDataList = this.materialDataDao.selectMaterialDataListByInputFrameDataId(inputFrameDataList.get(0).getId());
//                    if ((materialDataList.size()==0&&temp.length==1&&temp[0].equals(""))||(materialDataList.size()!=0&&materialDataList.size()==temp.length)) {
//                        if (materialDataList.size()!=0) {
//                            List<Integer> tempList = new ArrayList<>();
//                            for (String t:temp) {
//                                tempList.add(Integer.parseInt(t));
//                            }
//                            for (MaterialData e:materialDataList) {
//                                if (tempList.contains(e.getMaterialId())) {
//                                    continue;
//                                } else {
//                                    System.out.println(2);
//                                    this.sceneDataDao.insert(scene);
//                                    return scene.getId();
//                                }
//                            }
//                        }
//                    } else {
//                        System.out.println(3);
//                        this.sceneDataDao.insert(scene);
//                        return scene.getId();
//                    }
//                    List<DeviceData> deviceDataList = this.deviceDataDao.selectDeviceDataListByInputFrameDataId(inputFrameDataList.get(0).getId());
//                    if ((deviceDataList.size()==0&&temp1.length==1&&temp1[0].equals(""))||(deviceDataList.size()!=0&&deviceDataList.size()==temp1.length)) {
//                        if (deviceDataList.size()!=0) {
//                            List<Integer> tempList1 = new ArrayList<>();
//                            for (String t:temp1) {
//                                tempList1.add(Integer.parseInt(t));
//                            }
//                            for (DeviceData e:deviceDataList) {
//                                if (tempList1.contains(e.getDeviceId())) {
//                                    continue;
//                                } else {
//                                    System.out.println(4);
//                                    this.sceneDataDao.insert(scene);
//                                    return scene.getId();
//                                }
//                            }
//                        }
//                        System.out.println(5);
//                        return repeatScene.getId();
//                    } else {
//                        System.out.println(6);
//                        this.sceneDataDao.insert(scene);
//                        return scene.getId();
//                    }
//                }
//            } else {
//                System.out.println(7);
//                this.sceneDataDao.insert(scene);
//                return scene.getId();
//            }
            //查询所有基本信息相同的场景
            List<AbstractModel> repeatSceneList = this.sceneDataDao.selectRepeatItem(scene);
            //如果场景没有找到就直接新建场景，返回场景编号
            if (repeatSceneList.size()==0) {
//                this.sceneDataDao.insert(scene);
//                InputFrameData inputFrameData = new InputFrameData();
//                inputFrameData.setSceneDataId(scene.getId());
//                this.inputFrameDataDao.insert(inputFrameData);
//                int[] materialNumber = new int[temp.length];
//                for (int i=0;i<materialNumber.length;i++) {
//                    materialNumber[i] = Integer.parseInt(temp[i]);
//                }
//                for (int i=0;i<materialNumber.length;i++) {
//                    MaterialData materialData = new MaterialData();
//                    materialData.setInputFrameDataId(inputFrameData.getId());
//                    materialData.setMaterialId(materialNumber[i]);
//                    this.materialDataDao.insert(materialData);
//                }
//                int[] deviceNumber = new int[temp1.length];
//                for (int i=0;i<deviceNumber.length;i++) {
//                    deviceNumber[i] = Integer.parseInt(temp1[i]);
//                }
//                for (int i=0;i<deviceNumber.length;i++) {
//                    DeviceData deviceData = new DeviceData();
//                    deviceData.setInputFrameDataId(inputFrameData.getId());
//                    deviceData.setDeviceId(deviceNumber[i]);
//                    this.deviceDataDao.insert(deviceData);
//                }
//                for (String keyParam :temp2) {
//                    KeyParameterData keyParameterData = new KeyParameterData();
//                    keyParameterData.setInputFrameDataId(inputFrameData.getId());
//                    keyParameterData.setTitle(keyParam);
//                }
                this.insertData(scene, temp, temp1, temp2);
                return scene.getId();
            }
            //对于每一个基本信息相同的场景，对场景的输入帧信息进行对比
            for (AbstractModel repeatScene: repeatSceneList) {
                List<InputFrameData> inputFrameDataList =this.inputFrameDataDao.selectInputFrameDataListBySceneDataId(repeatScene.getId());
                //输入帧信息为空
                if (inputFrameDataList.size()==0) {
                    // 如果新增的物料信息和设备信息都为空，则场景重复，返回重复场景的ID，否则判断下一个场景
                    if (materialDataIdList.equals("")&&deviceDataIdList.equals("")) {
                        return repeatScene.getId();
                    } else {
                        continue;
                    }
                } else {
                    //如果输入帧信息不为空，依次比较物料数据信息和设备数据信息，一旦不符立刻停止比对，进入下一个场景的比对。
                    List<MaterialData> materialDataList = this.materialDataDao.selectMaterialDataListByInputFrameDataId(inputFrameDataList.get(0).getId());
                    if ((materialDataList.size()==0&&temp.length==1&&temp[0].equals(""))||(materialDataList.size()!=0&&materialDataList.size()==temp.length)) {
                        if (materialDataList.size()!=0) {
                            List<Integer> tempList = new ArrayList<>();
                            for (String t:temp) {
                                tempList.add(Integer.parseInt(t));
                            }
                            boolean material = true;
                            for (MaterialData e:materialDataList) {
                                if (tempList.contains(e.getMaterialId())) {
                                    continue;
                                } else {
                                    material = false;
                                    break;
                                }
                            }
                            if (!material) {
                                continue;
                            }
                        }
                    } else {
                        continue;
                    }
                    List<DeviceData> deviceDataList = this.deviceDataDao.selectDeviceDataListByInputFrameDataId(inputFrameDataList.get(0).getId());
                    if ((deviceDataList.size()==0&&temp1.length==1&&temp1[0].equals(""))||(deviceDataList.size()!=0&&deviceDataList.size()==temp1.length)) {
                        if (deviceDataList.size()!=0) {
                            List<Integer> tempList1 = new ArrayList<>();
                            for (String t:temp1) {
                                tempList1.add(Integer.parseInt(t));
                            }
                            boolean device = true;
                            for (DeviceData e:deviceDataList) {
                                if (tempList1.contains(e.getDeviceId())) {
                                    continue;
                                } else {
                                    device = false;
                                }
                            }
                            if (!device) {
                                continue;
                            }
                        }
                    } else {
                        continue;
                    }
                    //如果数据比对全部通过，则找到了重复场景，返回重复场景的Id
                    return repeatScene.getId();
                }
            }
//            全部比对完毕依然没有找到重复场景，新建场景
//            this.sceneDataDao.insert(scene);
            this.insertData(scene, temp, temp1, temp2);
            return scene.getId();
        } else if(tableName.equals("inputFrameData")) {
            JSONObject jsonObject= JSON.parseObject(record);
            int sceneDataId = Integer.parseInt(jsonObject.getString("sceneDataId"));
//            System.out.println(jsonObject.getString("materialDataList"));
            String materialDataIdList = jsonObject.getString("materialDataList").substring(1,jsonObject.getString("materialDataList").length()-1);
            String[] temp = materialDataIdList.split(",");
//            System.out.println(jsonObject.getString("deviceDataList"));
            String deviceDataIdList = jsonObject.getString("deviceDataList").substring(1,jsonObject.getString("deviceDataList").length()-1);
            String[] temp1 = deviceDataIdList.split(",");
//            System.out.println(jsonObject.getString("keyParameterDataList"));
            String keyParameterDataList = jsonObject.getString("keyParameterDataList").substring(1,jsonObject.getString("keyParameterDataList").length()-1);
            String[] temp2 = keyParameterDataList.split(",");
            if (temp.equals("") && temp1.equals("") && temp2.equals("") ) {
                InputFrameData inputFrameData = new InputFrameData();
                inputFrameData.setSceneDataId(sceneDataId);
                this.inputFrameDataDao.insert(inputFrameData);
                return inputFrameData.getId();
            } else {
                InputFrameData inputFrameData = new InputFrameData();
                inputFrameData.setSceneDataId(sceneDataId);
                this.inputFrameDataDao.insert(inputFrameData);
                if (!(temp.length==1&&temp[0].equals(""))) {
                    int[] materialNumber = new int[temp.length];
                    for (int i=0;i<materialNumber.length;i++) {
                        materialNumber[i] = Integer.parseInt(temp[i]);
                        System.out.println(materialNumber[i]);
                    }
                    for (int i=0;i<materialNumber.length;i++) {
                        MaterialData materialData = new MaterialData();
                        materialData.setInputFrameDataId(inputFrameData.getId());
                        materialData.setMaterialId(materialNumber[i]);
                        this.materialDataDao.insert(materialData);
                    }
                }
                if (!(temp1.length==1&&temp1[0].equals(""))) {
                    int[] deviceNumber = new int[temp1.length];
                    for (int i=0;i<deviceNumber.length;i++) {
                        deviceNumber[i] = Integer.parseInt(temp1[i]);
                    }
                    for (int i=0;i<deviceNumber.length;i++) {
                        DeviceData deviceData = new DeviceData();
                        deviceData.setInputFrameDataId(inputFrameData.getId());
                        deviceData.setDeviceId(deviceNumber[i]);
                        this.deviceDataDao.insert(deviceData);
                    }
                }
                if(!(temp2.length==1&&temp2[0].equals(""))) {
                    for (String keyParam :temp2) {
                        KeyParameterData keyParameterData = new KeyParameterData();
                        keyParameterData.setInputFrameDataId(inputFrameData.getId());
                        keyParameterData.setTitle(keyParam.substring(1,keyParam.length()-1));
                        this.keyParameterDataDao.insert(keyParameterData);
                    }
                }
                return inputFrameData.getId();
            }
        } else {
            if (record==null|| record.equals("")) {
                return 0;
            }
            ModelImpl.setTableName(tableName);
            AbstractModel model = ModelHandler.newModelInstance(tableName, record);
//            AbstractModel repeatModel = this.modelDao.selectRepeatItem(model);
//            if (repeatModel != null) {
//                return repeatModel.getId();
//            } else {
//                System.out.println(8);
//                this.modelDao.insert(model);
//                return model.getId();
//            }
//            ModelImpl.setTableName(tableName);
//            AbstractModel model = ModelHandler.newModelInstance(tableName, record);
            return this.modelDao.insert(model);
        }
    }

    public void insertData (SceneData scene, String[] materialList, String[] DeviceList, String[] keyParameterList) {
        this.sceneDataDao.insert(scene);
        InputFrameData inputFrameData = new InputFrameData();
        inputFrameData.setSceneDataId(scene.getId());
        this.inputFrameDataDao.insert(inputFrameData);
        int[] materialNumber = new int[materialList.length];
        for (int i=0;i<materialNumber.length;i++) {
            materialNumber[i] = Integer.parseInt(materialList[i]);
            System.out.println(materialNumber[i]);
        }
        for (int i=0;i<materialNumber.length;i++) {
            MaterialData materialData = new MaterialData();
            materialData.setInputFrameDataId(inputFrameData.getId());
            materialData.setMaterialId(materialNumber[i]);
//            System.out.println(1);
            this.materialDataDao.insert(materialData);
        }
        int[] deviceNumber = new int[DeviceList.length];
        for (int i=0;i<deviceNumber.length;i++) {
            deviceNumber[i] = Integer.parseInt(DeviceList[i]);
        }
        for (int i=0;i<deviceNumber.length;i++) {
            DeviceData deviceData = new DeviceData();
            deviceData.setInputFrameDataId(inputFrameData.getId());
            deviceData.setDeviceId(deviceNumber[i]);
//            System.out.println(2);
            this.deviceDataDao.insert(deviceData);
        }
        for (String keyParam :keyParameterList) {
            KeyParameterData keyParameterData = new KeyParameterData();
            keyParameterData.setInputFrameDataId(inputFrameData.getId());
            keyParameterData.setTitle(keyParam.substring(1,keyParam.length()-1));
//            System.out.println(3);
            this.keyParameterDataDao.insert(keyParameterData);
        }
    }
//    @RequestMapping(value = "", method = RequestMethod.POST)
//    public int post(@PathVariable String tableName, @RequestBody String record){
//        ModelImpl.setTableName(tableName);
//        AbstractModel model = ModelHandler.newModelInstance(tableName, record);
//        return this.modelDao.insert(model);
//    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public int put(@PathVariable String tableName, @RequestBody String record){
        ModelImpl.setTableName(tableName);
        AbstractModel model = ModelHandler.newModelInstance(tableName, record);
        return this.modelDao.updateByPrimaryKey(model);
    }

    @RequestMapping(value = "/{pk}", method = RequestMethod.DELETE)
    public  int delete(@PathVariable String tableName, @PathVariable Integer pk){
        ModelImpl.setTableName(tableName);
        return this.modelDao.deleteByPrimaryKey(pk);
    }
}
