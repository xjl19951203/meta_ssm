package com.zeng.ssm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zeng.ssm.common.AbstractModel;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 用户模型
 */
public class User extends AbstractModel{

    private String userName;
    private String password;
    private String email;

//    private List<UserGroup> ownGroups; // 用户所创建的表
//    private List<UserGroupData> joinGroups; // 用户所属的表

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date updatedAt;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public List<UserGroup> getOwnGroups() {
//        return ownGroups;
//    }
//
//    public void setOwnGroups(List<UserGroup> ownGroups) {
//        this.ownGroups = ownGroups;
//    }
//
//    public List<UserGroupData> getJoinGroups() {
//        return joinGroups;
//    }
//
//    public void setJoinGroups(List<UserGroupData> joinGroups) {
//        this.joinGroups = joinGroups;
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
}
