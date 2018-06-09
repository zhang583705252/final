package com.baizhi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.User;
import com.baizhi.entity.UserMap;
import com.baizhi.service.UserService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileOutputStream;
import java.util.*;


@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    //1.用户注册
    @ResponseBody
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public JSONObject registUser(User user) {

        JSONObject jsonObject = userService.registUserService(user);
        return jsonObject;
    }

    //2.用户登陆
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JSONObject login(User user) {
        JSONObject jsonObject = userService.loginUserService(user);
        return jsonObject;

    }

    //3.用户的修改
    @ResponseBody
    @RequestMapping(value = "/modify")
    public JSONObject modify(User user) {
        JSONObject jsonObject = userService.updateUserService(user);
        return jsonObject;

    }

    //4.获取验证码的
    @ResponseBody
    @RequestMapping(value = "/obtain")
    public JSONObject obtain(String phoneNum) {
        JedisPoolConfig config = new JedisPoolConfig();
        //和redis数据库建立连接
        JedisPool s = new JedisPool(config, "127.0.0.1", 6379);
        Jedis je = s.getResource();
        //
        String code = je.get("code");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", code);
        //设置过期时间
        je.setex("code", 60, code);
        return jsonObject;

    }

    //检查验证码
    public JSONObject check(String phoneNum, String code) {

        JedisPool s = new JedisPool("127.0.0.1", 6379);
        Jedis je = s.getResource();
        String code1 = je.get("code");
        JSONObject jsonObject = new JSONObject();
        if (code1.equals(code)) {
            jsonObject.put("result", "success");
            //ok存入数据库
            User user = new User();
            user.setPhoneNum(phoneNum);
            userService.registUserService(user);
            return jsonObject;
        } else {
            jsonObject.put("result", "fail");
            return jsonObject;
        }

    }

    //随机获取金刚道友
    @RequestMapping(value = "/member")
    @ResponseBody
    public List<JSONObject> member(User user) {
        List<JSONObject> jsonObjectList = userService.queryAllUser(user);
        return jsonObjectList;
    }

    //查所有
    @RequestMapping(value = "/allUser")
    @ResponseBody
    public ArrayList<Map> queryAllUser() {
        List<UserMap> list = userService.selectprovince();
        System.out.println(list);
        Map<String, Object> map = null;
        ArrayList<Map> arrayList = new ArrayList<>();
        for (UserMap userMap : list) {
            map = new HashMap<String, Object>();
            map.put("name", userMap.getKey());
            map.put("value", userMap.getValue());
            arrayList.add(map);
        }
        return arrayList;
    }

    @RequestMapping(value = "/customerExport")
    public void customerExport(String title, String fileds, HttpServletResponse response) {
        String[] titles = title.split(",");
        String[] field = fileds.split(",");
        Workbook workbook = new HSSFWorkbook();
        //日期格式的转换
        DataFormat dataFormat = workbook.createDataFormat();
        short format = dataFormat.getFormat("yyyy-MM-dd");
        //创建日期样式
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat(format);
        Sheet sheet = workbook.createSheet("用户工作表");
        //建标题行
        Row row = sheet.createRow(0);
        for (int i = 0; i < titles.length; i++) {
            String s = titles[i];
            //建单元格并填充数据  name 名字
            row.createCell(i).setCellValue(s);
        }
        //从数据库查询数据为field填充数据
        List<User> users = userService.selectAllUser();
        for (int i = 0; i < users.size(); i++) {
            row = sheet.createRow(i + 1);


            for (int j = 0; j < field.length; j++) {
                String s = field[j];
                //获取方法名
                String methodName = "get" + s.substring(0, 1).toUpperCase() + s.substring(1);
                //通过反射获取实体类的类对象
                Class<User> userClass = User.class;
                Object invoke = null;
                try {
                    //类对象通过反射获取对应的get方法
                    invoke = userClass.getDeclaredMethod(methodName, null).invoke(users.get(i), null);
                    Cell cell = row.createCell(j);
                    if (invoke instanceof Date) {
                        cell.setCellStyle(cellStyle);
                        cell.setCellValue((Date) invoke);
                    } else {
                        if(invoke == null){
                            cell.setCellValue("");
                        }
                        cell.setCellValue(invoke.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }
        String name = "E:\\excel\\用户自定义导出文件.xls";

        try {
            //  fileName=new String(name.getBytes(charsetName:"utf-8"),charsetName:"ISO8859-1");
            workbook.write(new FileOutputStream(new File(name)));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
