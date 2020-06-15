package com.zeng.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zeng.ssm.common.AbstractModel;
import com.zeng.ssm.dao.CategoryDao;
import com.zeng.ssm.dao.SceneDataDao;
import com.zeng.ssm.model.Category;
import com.zeng.ssm.model.PageResult;
import com.zeng.ssm.model.SceneData;
import com.zeng.ssm.model.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/category")
public class CategoryController {

    @Resource
    CategoryDao categoryDao;

    @RequestMapping(value = "/{pk}", method = RequestMethod.GET)
    public PageResult get(@PathVariable Integer pk, @RequestParam(defaultValue="1") Integer CurrentPage, @RequestParam(defaultValue="5") Integer pageSize) {

        PageHelper.startPage(CurrentPage,pageSize);
        Category category = (Category)this.categoryDao.selectByPrimaryKey(pk);
        List<SceneData> list = category.getSceneDataList();
        int size = list.size();
//        if ()
        PageResult pageResult = new PageResult();
//        pageResult.
//
//        return pageResult;

        return null;

    }
}
