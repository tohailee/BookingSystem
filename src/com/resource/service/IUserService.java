package com.resource.service;

import com.resource.entity.User.Role;
import com.resource.entity.User.User;

import java.util.List;


public interface IUserService {
    /**
     * 添加用户
     *
     * @param user user
     * @return boolean
     */
    boolean add(User user) throws Exception;

    /**
     * 修改用户
     *
     * @param user user
     * @return boolean
     */
    boolean update(String id, User user) throws Exception;

    /**
     * 删除用户
     *
     * @param id id
     * @return boolean
     */
    boolean delete(String id) throws Exception;

    /**
     * 根据ID获取用户
     *
     * @param id id
     * @return User
     */
    User getUserById(String id) throws Exception;

    /**
     * 根据Name获取用户
     *
     * @param name name
     * @return User
     */
    User getUserByName(String name) throws Exception;

    /**
     * 获取多个用户
     *
     * @return List
     */
    List<User> getUsers() throws Exception;

    /**
     * 获取所以角色
     *
     * @return 所以角色
     * @throws Exception Exception
     */
    List<Role> getRoles() throws Exception;
}
