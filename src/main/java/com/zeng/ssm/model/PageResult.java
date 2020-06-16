package com.zeng.ssm.model;

import com.zeng.ssm.common.AbstractModel;

import java.io.Serializable;
import java.util.List;

public class PageResult implements Serializable {

    private Long count;		//总共有多少记录数
    private Integer currentPage;	//当前页数(从1开始)
    private Integer currentPageSize; //当前页的记录数
    private Integer pages;		//总共页数
    private Integer pageSize;  //设定每页的记录数
    private List<AbstractModel> data;	//数据

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getCurrentPageSize() {
        return currentPageSize;
    }

    public void setCurrentPageSize(Integer currentPageSize) {
        this.currentPageSize = currentPageSize;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer size) {
        this.pageSize = size;
    }

    public List<AbstractModel> getData() {
        return data;
    }

    public void setData(List<AbstractModel> data) {
        this.data = data;
    }
}
