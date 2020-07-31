package com.zeng.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zeng.ssm.common.*;
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
//
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
            //将数据表单
            JSONObject jsonObject= JSON.parseObject(record);
            String sceneData = jsonObject.getString("sceneData");
            String materialDataIdList = jsonObject.getString("materialDataList").substring(1,jsonObject.getString("materialDataList").length()-1);
            String[] temp = materialDataIdList.split(",");
            String deviceDataIdList = jsonObject.getString("deviceDataList").substring(1,jsonObject.getString("deviceDataList").length()-1);
            String[] temp1 = deviceDataIdList.split(",");
            SceneData scene = (SceneData)ModelHandler.newModelInstance("sceneData", sceneData);
            AbstractModel repeatScene = this.sceneDataDao.selectRepeatItem(scene);
            if (repeatScene!=null) {
                List<InputFrameData> inputFrameDataList =this.inputFrameDataDao.selectInputFrameDataListBySceneDataId(repeatScene.getId());
                if (inputFrameDataList.size()==0) {
                    if (materialDataIdList.equals("")&&deviceDataIdList.equals("")) {
                        return repeatScene.getId();
                    } else {
                        return this.sceneDataDao.insert(scene);
                    }
                } else {
                    List<MaterialData> materialDataList = this.materialDataDao.selectMaterialDataListByInputFrameDataId(inputFrameDataList.get(0).getId());
                    if ((materialDataList.size()==0&&temp.length==1&&temp[0].equals(""))||(materialDataList.size()!=0&&materialDataList.size()==temp.length)) {
                        if (materialDataList.size()!=0) {
                            List<Integer> tempList = new ArrayList<>();
                            for (String t:temp) {
                                tempList.add(Integer.parseInt(t));
                            }
                            for (MaterialData e:materialDataList) {
                                if (tempList.contains(e.getMaterialId())) {
                                    continue;
                                } else {
                                    return this.sceneDataDao.insert(scene);
                                }
                            }
                        }
                    } else {
                        return this.sceneDataDao.insert(scene);
                    }
                    List<DeviceData> deviceDataList = this.deviceDataDao.selectDeviceDataListByInputFrameDataId(inputFrameDataList.get(0).getId());
                    if ((deviceDataList.size()==0&&temp1.length==1&&temp1[0].equals(""))||(deviceDataList.size()!=0&&deviceDataList.size()==temp1.length)) {
                        if (deviceDataList.size()!=0) {
                            List<Integer> tempList1 = new ArrayList<>();
                            for (String t:temp1) {
                                tempList1.add(Integer.parseInt(t));
                            }
                            for (DeviceData e:deviceDataList) {
                                if (tempList1.contains(e.getDeviceId())) {
                                    continue;
                                } else {
                                    return this.sceneDataDao.insert(scene);
                                }
                            }
                        }
                        return repeatScene.getId();
                    } else {
                        return this.sceneDataDao.insert(scene);
                    }
                }
            } else {
                return this.sceneDataDao.insert(scene);
            }
        } else {
            ModelImpl.setTableName(tableName);
            AbstractModel model = ModelHandler.newModelInstance(tableName, record);
            AbstractModel repeatModel = this.modelDao.selectRepeatItem(model);
            if (repeatModel != null) {
                return 0;
            } else {
                return this.modelDao.insert(model);
            }
//            ModelImpl.setTableName(tableName);
//            AbstractModel model = ModelHandler.newModelInstance(tableName, record);
//            return this.modelDao.insert(model);
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
