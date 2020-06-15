package com.zeng.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zeng.ssm.common.*;
import com.zeng.ssm.model.PageResult;
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
    public PageResult getLists(@PathVariable String tableName,@RequestParam(defaultValue="1") Integer CurrentPage,@RequestParam(defaultValue="5") Integer pageSize) {
        ModelImpl.setTableName(tableName);
        PageHelper.startPage(CurrentPage,pageSize);
        List<AbstractModel> list = this.modelDao.selectAll();
        PageInfo<AbstractModel> pageInfo = new PageInfo<>(list);
//        System.out.println("PageSize: "+pageInfo.getPageSize()); //3  每页包含的条数
        PageResult pageResult = new PageResult();
        pageResult.setCurrentPage(pageInfo.getPageNum());//当前页
        pageResult.setPageSize(pageInfo.getSize());//当前页的数目
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
