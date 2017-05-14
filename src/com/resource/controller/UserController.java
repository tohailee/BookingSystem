package com.resource.controller;

import com.resource.entity.User.Role;
import com.resource.entity.User.User;
import com.resource.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource(name = "userService")
    private IUserService userService;//添加final关键词后必须要初始化或者通过构造函数注入

    /**
     * 获取所有用户列表
     *
     * @param request request
     * @return String
     */
    @RequestMapping("/getUsers")
    public String getUsers(HttpServletRequest request) {
        List<User> users = null;
        try {
            users = userService.getUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("userList", users);
        return "allUser";
    }

    /**
     * 跳转到添加用户界面
     *
     * @param request request
     * @return String
     */
    @RequestMapping("/addUser")
    public String addUser(HttpServletRequest request) {
        return "addUser";
    }

    /**
     * 添加用户并重定向到用户列表
     *
     * @param user    user
     * @param request request
     * @return String
     */
    @RequestMapping(value = "/newUser",method = RequestMethod.POST)
    public String newUser(User user, HttpServletRequest request) {
        Boolean flag = false;
        if(user!=null){
            user.setId(String.valueOf(UUID.randomUUID()));
            try {
                flag = userService.add(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (flag)
            return "redirect:/user/getUsers";
        else{
            try {
                if (user != null) {
                    String userName = user.getUsername();
                    String roleName = userService.getUserByName(userName).getRole().getRoleName();
                    request.setAttribute("error", userName + "或" + roleName + "已经存在！");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "forward:addUser";
        }
    }

    /**
     * 编辑用户并重定向
     *
     * @param request request
     * @return String
     */
    @RequestMapping("/editUser/{id}")
    public String editUser(@PathVariable("id") String id,  HttpServletRequest request){
        try {
            User user = userService.getUserById(id);
            System.out.println(user);
            request.setAttribute("user", user);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "editUser";
    }

    @ModelAttribute("roles")
    public Map<String,String> getRoles(){
        Map<String, String> roles = new HashMap<>();
        try {
            List<Role> roleList = userService.getRoles();
            if(roleList!=null){
                for (Role role : roleList) {
                    roles.put(role.getId(), role.getRoleName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roles;
    }

    @RequestMapping("/updateUser/{id}")
    public String updateUser(@PathVariable String id, User user,HttpServletRequest request) {
        String roleId = request.getParameter("roleId");
        try {
            Role role = new Role();
            role.setId(roleId);
            user.setRole(role);
            userService.update(id,user);
            request.setAttribute("user", user);
            return "redirect:/user/getUsers";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/error";
    }

    /**
     * 根据id查询单个用户
     *
     * @param id      id
     * @param request request
     * @return String
     */
    @RequestMapping("/getUser/{id}")
    public String getUser(@PathVariable String id, HttpServletRequest request) {

        try {
            request.setAttribute("user", userService.getUserById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/editUser";
    }

    /**
     * 删除用户
     *
     * @param id       id
     * @param request  request
     * @param response response
     */
    @RequestMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) {
        String result = "{\"result\":\"error\"}";

        try {
            if (userService.delete(id)) {
                result = "{\"result\":\"success\"}";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.setContentType("application/json");

        try {
            PrintWriter out = response.getWriter();
            out.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
