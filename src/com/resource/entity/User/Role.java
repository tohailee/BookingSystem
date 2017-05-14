package com.resource.entity.User;

import java.util.List;

/*
 * <br>description:</br>
 * ${Time}
 * Created by hailee on 2016/12/28.
 */
public class Role {
    private String id;
    private String roleName;
    private List<Privilege> privileges;
    private String description;

    public Role() {
    }

    public Role(String id,String roleName,List<Privilege> privileges,String description){
        this.id = id;
        this.roleName = roleName;
        this.privileges = privileges;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
