package com.resource.mapper;

import com.resource.entity.User.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userMapper")
public interface UserMapper {
    /**
     * 添加用户
     *
     * @param user user
     * @return boolean
     */
    boolean addUser(User user) throws Exception;

    /**
     * 修改用户
     *
     * @param user user
     * @return boolean
     */
    boolean updateUser(User user);

    /**
     * 删除用户
     *
     * @param id id
     * @return boolean
     */
    boolean deleteUser(String id) throws Exception;

    /**
     * 根据ID获取用户
     *
     * @param id id
     * @return User
     */
    User getUserById(String id);

    /**
     * 根据Name获取用户
     *
     * @param name name
     * @return User
     */
//    User getUserByName(String name);

    /**
     * 获取多个用户
     *
     * @return List
     */
    List<User> getUsers() throws Exception;
}
