package com.zeng.ssm.controller;

import com.zeng.ssm.common.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/manage/{tableName}")
public class ManageController{

    @Resource
    ModelDao modelDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<AbstractModel> getList(@PathVariable String tableName) {
        ModelImpl.setTableName(tableName);
        return this.modelDao.selectAll();
    }

//    @RequestMapping(value = "", method = RequestMethod.GET)
//    public List<List<AbstractModel>> getLists(@PathVariable String tableName) {
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
        ModelImpl.setTableName(tableName);
        AbstractModel model = ModelHandler.newModelInstance(tableName, record);
        return this.modelDao.insert(model);
    }

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
