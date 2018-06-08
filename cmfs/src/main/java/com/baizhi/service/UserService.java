package com.baizhi.service;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.User;
import com.baizhi.entity.UserMap;


import java.util.List;
import java.util.Map;


public interface UserService {
    //1.用户的注册功能
    JSONObject registUserService(User user);
    //2.用户的查询功能
    JSONObject loginUserService(User user);
    //3.查所有用户
    List<User> selectAllUser();
    List<UserMap> selectprovince();
    //5.修改user
    JSONObject updateUserService(User user);
    //6.返回不含查询用户的所有其他用户
    List<JSONObject> queryAllUser(User user);
}


