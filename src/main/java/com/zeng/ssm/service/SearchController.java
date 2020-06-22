package com.zeng.ssm.service;

import com.zeng.ssm.common.AbstractModel;
import com.zeng.ssm.dao.*;
import com.zeng.ssm.model.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/search")
public class SearchController {
    @Resource
    SceneDataDao sceneDataDao;
    @Resource
    CategoryDao categoryDao;

    //页面查询，每个工艺分类中根据名称和描述进行搜索
    @RequestMapping(value="/{categoryId}",method = RequestMethod.GET)
    public PageResult pageSearch (@PathVariable int categoryId,@RequestParam(defaultValue="1") Integer currentPage, @RequestParam(defaultValue="5") Integer pageSize, @RequestBody SceneData sceneData  ) {
        List<Category> lists = new ArrayList<>();
        List<SceneData> list = new ArrayList<>();
        //首先根据categoryId将当前页面的category对象全部找出来
        if (categoryId == 1) {
            lists.addAll(this.categoryDao.selectBySearchPrimaryKey(2));
            lists.addAll(this.categoryDao.selectBySearchPrimaryKey(3));
            lists.addAll(this.categoryDao.selectBySearchPrimaryKey(4));
            lists.addAll(this.categoryDao.selectBySearchPrimaryKey(5));
        } else {
            lists = this.categoryDao.selectBySelectivePrimaryKey(categoryId);
        }
        //对集合中的每一个category对象，将其参数传给入参中的sceneData，然后根据入参查询工艺场景的详情
        for (Category category : lists) {
            sceneData.setCategoryId(category.getId());
            list.addAll(this.sceneDataDao.selectBySearch(sceneData));
        }
        //做个假的分页
        PageResult pageResult = new PageResult();
        int size = list.size();
        if (size % pageSize != 0) {
            pageResult.setPages(size / pageSize + 1);
            if (currentPage == size / pageSize + 1) {
                pageResult.setCurrentPageSize(size % pageSize);
            } else if (currentPage <= size / pageSize) {
                pageResult.setCurrentPageSize(pageSize);
            } else {
                pageResult.setCurrentPageSize(0);
            }
        } else {
            pageResult.setPages(size / pageSize);
            if (currentPage <= size / pageSize) {
                pageResult.setCurrentPageSize(pageSize);
            } else {
                pageResult.setCurrentPageSize(0);
            }
        }
        pageResult.setCurrentPage(currentPage);
        pageResult.setPageSize(pageSize);
        pageResult.setCount((long) size);
        List<AbstractModel> list1 = new ArrayList<>();
        for (int i = pageSize * (currentPage - 1); i < pageSize * currentPage && i < size; i++) {
            list1.add(list.get(i));
        }
        pageResult.setData(list1);
        return pageResult;
    }
    //模块查询，一框式搜索
    @RequestMapping(value = "",method = RequestMethod.GET)
    public HashMap<String,ArrayList> allSearch(@RequestBody String record) {
        ArrayList arrayList = new ArrayList();
        
        return null;
    }

}
