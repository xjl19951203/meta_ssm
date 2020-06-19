package com.zeng.ssm.model;

import com.zeng.ssm.common.Searchable;

public class EnvLoad extends Searchable{

    private String title;
    private int envLoadCategoryId;
    private EnvLoadCategory envLoadCategory;
    private String description;
    private int safetyId;
    private Safety safety;
    private String treatment;
    private String source;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public EnvLoadCategory getEnvLoadCategory() {
        return envLoadCategory;
    }

    public void setEnvLoadCategory(EnvLoadCategory envLoadCategory) {
        this.envLoadCategory = envLoadCategory;
    }

    @Override
    public String getModelType() {
        return "env_load";
    }

    public int getEnvLoadCategoryId() {
        return envLoadCategoryId;
    }

    public void setEnvLoadCategoryId(int envLoadCategoryId) {
        this.envLoadCategoryId = envLoadCategoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSafetyId() {
        return safetyId;
    }

    public void setSafetyId(int safetyId) {
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
