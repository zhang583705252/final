package com.baizhi.dao;

import com.baizhi.entity.User;
import netscape.javascript.JSObject;

import java.util.List;
import java.util.Map;

public interface UserDAO {
    //1.用户的注册功能
    void insertUser(User user);
    //2.用户的查询功能
    User selectUser(User user);
    //3.查所有用户
    List<User> selectAllUser();
    //4.查所有用户
    List<User> selectprovinceUser();
    //5.修改用户
    void updateUser(User user);
    //6.返回不含查询用户的所有其他用户
    List<User> queryAllUser(User user);
}
