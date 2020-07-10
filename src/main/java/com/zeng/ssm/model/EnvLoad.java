package com.zeng.ssm.model;

import com.zeng.ssm.common.Searchable;

public class EnvLoad extends Searchable{

    private String title;
    private Integer envLoadCategoryId;
    private EnvLoadCategory envLoadCategory;
    private String description;
    private Integer safetyId;
    private Safety safety;
    private String treatment;
    private String source;

    @Override
    public String getModelType() {
        return "env_load";
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getEnvLoadCategoryId() {
        return envLoadCategoryId;
    }

    public void setEnvLoadCategoryId(Integer envLoadCategoryId) {
        this.envLoadCategoryId = envLoadCategoryId;
    }

    public EnvLoadCategory getEnvLoadCategory() {
        return envLoadCategory;
    }

    public void setEnvLoadCategory(EnvLoadCategory envLoadCategory) {
        this.envLoadCategory = envLoadCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSafetyId() {
        return safetyId;
    }

    public void setSafetyId(Integer safetyId) {
        this.safetyId = safetyId;
    }

    public Safety getSafety() {
        return safety;
    }

    public void setSafety(Safety safety) {
        this.safety = safety;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
