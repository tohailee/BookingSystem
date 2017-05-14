package com.resource.mapper;

import com.resource.entity.User.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by eliihai on 2017/1/9.
 */
@Repository
public interface RoleMapper {
    /**
     *
     * @param role role
     * @return true or false
     * @throws Exception Exception
     */
    boolean addRole(Role role) throws Exception;

    boolean updateRole(Role role) throws Exception;

    boolean deleteRole(String id) throws Exception;

    Role getRoleById(String id) throws Exception;

    List<Role> getRoles() throws Exception;
}
