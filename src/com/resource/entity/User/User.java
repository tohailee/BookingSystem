package com.resource.entity.User;

import java.io.Serializable;
import java.sql.Timestamp;

/*
 * <br>description:</br>
 * ${Time}
 * Created by hailee on 2016/12/28.
 */
public class User implements Serializable {
    private String id;
    private String username;
    private String password;
    private Role role;
    private String description;
    private String contact;
    private Timestamp createTime;
    private Timestamp lastLoginTime;

    public User() {
        super();
    }

    public User(String id, String username, String password, String description, String contact, Timestamp createTime, Timestamp lastLoginTime) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.description = description;
        this.contact = contact;
        this.createTime = createTime;
        this.lastLoginTime = lastLoginTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
