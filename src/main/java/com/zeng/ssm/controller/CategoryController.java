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
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/category")
public class CategoryController {

    @Resource
    CategoryDao categoryDao;

    @RequestMapping(value = "/{pk}", method = RequestMethod.GET)
    public PageResult get(@PathVariable Integer pk, @RequestParam(defaultValue="1") Integer currentPage, @RequestParam(defaultValue="5") Integer pageSize) {
        Category category;
        PageResult pageResult = new PageResult();
        List<SceneData> list = new ArrayList<>();
//        category.getSceneDataList();
        if (pk==0) {
//            category = (Category)this.categoryDao.selectByPrimaryKey(1);
            list.addAll(((Category) this.categoryDao.selectByPrimaryKey(1)).getSceneDataList());
            list.addAll(((Category) this.categoryDao.selectByPrimaryKey(2)).getSceneDataList());
            list.addAll(((Category) this.categoryDao.selectByPrimaryKey(3)).getSceneDataList());
            list.addAll(((Category) this.categoryDao.selectByPrimaryKey(4)).getSceneDataList());
        }else {
            category = (Category)this.categoryDao.selectByPrimaryKey(pk);
            list = category.getSceneDataList();
        }

        int size = list.size();
        if (size%pageSize!=0) {
            pageResult.setPages(size/pageSize+1);
            if (currentPage==size/pageSize+1) {
                pageResult.setPageSize(size%pageSize);
            }else {
                pageResult.setPageSize(pageSize);
            }
        }else {
            pageResult.setPages(size/pageSize);
            pageResult.setPageSize(pageSize);
        }
        pageResult.setCurrentPage(currentPage);
        List<AbstractModel> list1 = new ArrayList<>();
        for (int i=pageSize*(currentPage-1);i<pageSize*currentPage&&i<size;i++) {
            list1.add(list.get(i));
        }
        pageResult.setData(list1);
        return pageResult;
    }
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<AbstractModel> getLists() {
        return this.categoryDao.selectAll();
    }
}
