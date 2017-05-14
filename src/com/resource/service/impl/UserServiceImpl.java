package com.resource.service.impl;

import com.resource.entity.User.Role;
import com.resource.entity.User.User;
import com.resource.mapper.RoleMapper;
import com.resource.mapper.UserMapper;
import com.resource.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service("userService")
@Transactional  //此处不再进行创建SqlSession和提交事务，都已交由spring去管理了。
public class UserServiceImpl implements IUserService {

    @Resource(name = "userMapper")
    private UserMapper userMapper;

    @Resource
    private RoleMapper roleMapper;

    /**
     * 添加用户
     *
     * @param user user
     * @return boolean
     */
    @Override
    //方法上注解属性会覆盖类注解上的相同属性
   @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.READ_COMMITTED)
    public boolean add(User user) throws Exception{
        if(user!=null){
            if(user.getRole() != null){
                Role role = new Role();
                role.setId(UUID.randomUUID().toString());
                role.setRoleName(user.getRole().getRoleName());
                roleMapper.addRole(role);
                user.setRole(role);
            }
            userMapper.addUser(user);
            return true;
        }
        return false;
    }

    /**
     * 修改用户
     *
     * @param user user
     * @return boolean
     */
    @Override
    public boolean update(String id,User user) throws Exception{
        if(id != null && ("").equals(id)){
            user.setId(id);
        }
        return userMapper.updateUser(user);
    }

    /**
     * 删除用户
     *
     * @param id userId
     * @return boolean
     */
    @Override
    public boolean delete(String id) throws Exception{
        boolean flag = false;
        try {
            User user = userMapper.getUserById(id);
            Role role = user.getRole();
            if(role!=null){
                roleMapper.deleteRole(role.getId());
            }
             flag = userMapper.deleteUser(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 根据ID获取用户
     *
     * @param id id
     * @return User
     */
    @Override
    public User getUserById(String id) throws Exception{
        User user = userMapper.getUserById(id);
        System.out.println(user);
        return user;
    }

    /**
     * 根据Name获取用户
     *
     * @param name name
     * @return User
     */
    public User getUserByName(String name) throws Exception{
        return null;
//        return userMapper.getUserByName(name);
    }

    /**
     * 获取多个用户
     *
     * @return List
     */
    @Override
    @Transactional(readOnly = true)
    public List<User> getUsers() throws Exception{
        try {
            List<User> users = userMapper.getUsers();
            System.out.println(users.size());
            return userMapper.getUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取所有角色
     *
     * @return 所有角色
     * @throws Exception Exception
     */
    @Override
    @Transactional(readOnly = true)
    public List<Role> getRoles() throws Exception {
        try {
            return roleMapper.getRoles();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
