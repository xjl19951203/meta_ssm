package com.zeng.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zeng.ssm.common.AbstractModel;
import com.zeng.ssm.dao.CategoryDao;
import com.zeng.ssm.dao.SceneDataDao;
import com.zeng.ssm.model.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/category")
public class CategoryController {

    @Resource
    CategoryDao categoryDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
//    public CategoryPageResult get(@PathVariable Integer pk, @RequestParam(defaultValue="1") Integer currentPage, @RequestParam(defaultValue="5") Integer pageSize) {
    public CategoryPageResult get(@RequestParam(defaultValue="1") Integer categoryId, @RequestParam(defaultValue="1") Integer currentPage, @RequestParam(defaultValue="5") Integer pageSize) {

        CategoryPageResult categoryPageResult = new CategoryPageResult();
        categoryPageResult.setCategory((Category)this.categoryDao.selectByPrimaryKey(categoryId));
        List<Category> lists;
        List<SceneData> list = new ArrayList<>();
        if (categoryId==1) {
            lists = this.categoryDao.selectBySelectivePrimaryKey(2);
            for (Category temp:lists) {
                list.addAll(temp.getSceneDataList());
            }
            lists = this.categoryDao.selectBySelectivePrimaryKey(3);
            for (Category temp:lists) {
                list.addAll(temp.getSceneDataList());
            }
            lists = this.categoryDao.selectBySelectivePrimaryKey(4);
            for (Category temp:lists) {
                list.addAll(temp.getSceneDataList());
            }
            lists = this.categoryDao.selectBySelectivePrimaryKey(5);
            for (Category temp:lists) {
                list.addAll(temp.getSceneDataList());
            }
        }else {
            lists = this.categoryDao.selectBySelectivePrimaryKey(categoryId);
            for (Category temp:lists) {
                list.addAll(temp.getSceneDataList());
            }
        }

        int size = list.size();
        if (size%pageSize!=0) {
            categoryPageResult.setPages(size/pageSize+1);
            if (currentPage==size/pageSize+1) {
                categoryPageResult.setCurrentPageSize(size%pageSize);
            }else if (currentPage<=size/pageSize){
                categoryPageResult.setCurrentPageSize(pageSize);
            }else {
                categoryPageResult.setCurrentPageSize(0);
            }
        }else {
            categoryPageResult.setPages(size/pageSize);
            if (currentPage<=size/pageSize) {
                categoryPageResult.setCurrentPageSize(pageSize);
            }else {
                categoryPageResult.setCurrentPageSize(0);
            }
        }
        categoryPageResult.setCurrentPage(currentPage);
        categoryPageResult.setPageSize(pageSize);
        categoryPageResult.setCount((long)size);
        List<AbstractModel> list1 = new ArrayList<>();
        for (int i=pageSize*(currentPage-1);i<pageSize*currentPage&&i<size;i++) {
            list1.add(list.get(i));
        }
        categoryPageResult.setData(list1);
        return categoryPageResult;
    }

//    @RequestMapping(value = "", method = RequestMethod.GET)
//    public List<AbstractModel> getLists() {
//        return this.categoryDao.selectAll();
//    }
}
