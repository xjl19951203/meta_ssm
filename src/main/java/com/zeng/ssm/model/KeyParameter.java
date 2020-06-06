package com.zeng.ssm.model;

import com.zeng.ssm.common.Searchable;

public class KeyParameter extends Searchable {
    private String title;
    private Integer categoryRootId;
    private Category category;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCategoryRootId() {
        return categoryRootId;
    }

    public void setCategoryRootId(int parentId) {
        this.categoryRootId = categoryRootId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
