package com.zeng.ssm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zeng.ssm.common.Searchable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
@Component
public class SceneData extends Searchable {

    private Integer id;
    private String title;
    private Integer categoryId;
    private Integer categoryRootId; // 标识分类大类，便于按大类查询
    private Category category;
    private Integer userId;
    private User user;
    private String description;

    private List<InputFrameData> inputFrameDataList;
//    private List<OutputFrameData> outputFrameDataList;
//    private List<MaterialData> materialDataList;
//    private List<EnergyData> energyDataList;
//    private List<DeviceData> deviceDataList;
//    private List<EnvLoadData> envLoadDataList;
//    private List<OutputPartData> outputPartDataList;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date updatedAt;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getCategoryRootId() {
        return categoryRootId;
    }

    public void setCategoryRootId(Integer categoryRootId) {
        this.categoryRootId = categoryRootId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<InputFrameData> getInputFrameDataList() {
        return inputFrameDataList;
    }

    public void setInputFrameDataList(List<InputFrameData> inputFrameDataList) {
        this.inputFrameDataList = inputFrameDataList;
    }

//    public List<OutputFrameData> getOutputFrameDataList() {
//        return outputFrameDataList;
//    }
//
//    public void setOutputFrameDataList(List<OutputFrameData> outputFrameDataList) {
//        this.outputFrameDataList = outputFrameDataList;
//    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String getModelType() {
        return "scene";
    }
}
