package com.baizhi.service;
import com.alibaba.fastjson.JSONObject;
import com.baizhi.dao.UserDAO;
import com.baizhi.dao.UserMapDAO;
import com.baizhi.entity.User;
import com.baizhi.entity.UserMap;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.*;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private UserMapDAO userMapDAO;
    private JSONObject jsonObject=new JSONObject();
    //注册功能
    @Override
    public JSONObject registUserService(User user) {

        if(user.getPassword().equals("")||user.getPhoneNum().equals("")){
            jsonObject.put("error","-200");
            jsonObject.put("errmsg","电话号码或者密码不能为空");
            return  jsonObject;
        }
        //将电话号码传入数据库查询，如果有对象返回则说明该号码已经注册
        if(userDAO.selectUser(user)!=null){
            jsonObject.put("error","-200");
            jsonObject.put("errmsg","对不起，该号码已经注册过了");
            return jsonObject;
        }
        String str="1234567890zxcvbnm,.;lkjhgfdsaqwertyuiopZXCVBNM《》？“：LKJHGFDSAQWERTTYUIOOP+_)(*&%$#@!";
        int i=0;
        String str1="";
        //生成四为随机数Salt
        Random rd=new Random();
        while (i<4){

            int a=rd.nextInt(str.length()-1);
            char b= str.charAt(a) ;
            str1+=b;
            i++;
        }
        //将密码加盐(拼接)后MD5加密
       String password= user.getPassword()+str1;
       password=DigestUtils.md5Hex(password) ;
       user.setPassword(password);

        user.setData(new Date());
        userDAO.insertUser(user);
        jsonObject.put("phoneNum",user.getPhoneNum());
        jsonObject.put("password",user.getPassword());
        jsonObject.put("data",user.getData());
        return jsonObject;
    }
    //登陆功能
    @Override
    public JSONObject loginUserService(User user) {
         if(user.getPhoneNum().equals("")){
             jsonObject.put("error","-200");
             jsonObject.put("errmsg","请输入手机号");
             return jsonObject;
         }
        User us=userDAO.selectUser(user);
        if(us==null) {
            jsonObject.put("error", "-200");
            jsonObject.put("errmsg", "手机号码不对");
            return jsonObject;
        }
        //如果Slt为空串，则密码没有加密啊，直接比较
        if(us.getSalt()==null) {
            if (!us.getPassword().equals(user.getPassword())) {
                jsonObject.put("error", "-200");
                jsonObject.put("errmsg", "密码不对，请重新输入");
                return jsonObject;
            } else{
                jsonObject.put("id", us.getId());
                jsonObject.put("username", us.getUsername());
                jsonObject.put("phoneNum", us.getPhoneNum());
                jsonObject.put("province", us.getProvince());
                jsonObject.put("password", us.getPassword());
                return jsonObject;
            }
        }else{
            //将salt从数据库查出来，和用户的密码用MD5
            //加密后比较
           String password= us.getSalt()+user.getPassword();
           //加密
             password= DigestUtils.md5Hex(password);
             //和数据库的us对象的密码比较
            if(!us.getPassword().equals(password)){
                jsonObject.put("error", "-200");
                jsonObject.put("errmsg", "密码不对，请重新输入");
                return jsonObject;
            }else{
                jsonObject.put("id", us.getId());
                jsonObject.put("username", us.getUsername());
                jsonObject.put("phoneNum", us.getPhoneNum());
                jsonObject.put("province", us.getProvince());
                jsonObject.put("password", us.getPassword());
                return jsonObject;
            }
        }
    }



    @Override
    public List<User> selectAllUser() {
        List<User> us=userDAO.selectAllUser();
        if(us==null)throw new RuntimeException("没有注册的用户");

        return us;
    }


    @Override
    public  List<UserMap> selectprovince() {
         List<UserMap> maps=userMapDAO.selectprovinceUser();
         if(maps==null)throw new RuntimeException("没有数据");
         return maps;
    }

    @Override
    //修改用户信息
    public JSONObject updateUserService(User user) {
        if(userDAO.selectUser(user)!=null){
            jsonObject.put("error","-200");
            jsonObject.put("errmsg","该手机号已经存在");
            return jsonObject;
        }
        userDAO.updateUser(user);
        //将修改后的数据返回给前端
        User use=userDAO.selectUser(user);
        jsonObject.put("id",use.getId());
        jsonObject.put("username",use.getUsername());
        jsonObject.put("phoneNum",use.getPhoneNum());
        jsonObject.put("province",use.getProvince());
        jsonObject.put("data",use.getData());
        jsonObject.put("city",use.getCity());
        jsonObject.put("dharmaName",use.getDharmaName());
        jsonObject.put("sex",use.getSex());
        return jsonObject;
    }
    //6.返回不含查询用户的所有其他用户
    @Override
    public List<JSONObject> queryAllUser(User user) {
        List<User> list=userDAO.queryAllUser(user);
        List<JSONObject> list1=new ArrayList<JSONObject>();
        //随机生成数
        Random rd=new Random();
        int i=0;
        while (i<5){
             int a=rd.nextInt(list.size()-1);
             User use=list.get(a);
            jsonObject.put("id",use.getId());
            jsonObject.put("username",use.getUsername());
            jsonObject.put("phoneNum",use.getPhoneNum());
            jsonObject.put("province",use.getProvince());
            jsonObject.put("data",use.getData());
            jsonObject.put("city",use.getCity());
            jsonObject.put("dharmaName",use.getDharmaName());
            jsonObject.put("sex",use.getSex());
            list1.add(jsonObject);
            i++;
         }
        return list1;
    }

}
