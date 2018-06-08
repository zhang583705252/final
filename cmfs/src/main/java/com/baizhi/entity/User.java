package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.regex.Pattern;

// id` int(11) NOT NULL AUTO_INCREMENT,
//        `phoneNum` varchar(255) DEFAULT NULL,
//        `username` varchar(255) DEFAULT NULL,
//        `password` varchar(255) DEFAULT NULL,
//        `salt` varchar(255) DEFAULT NULL,
//        `dharmaName` varchar(255) DEFAULT NULL COMMENT '法名',
//        `province` varchar(255) DEFAULT NULL COMMENT '省份',
//        `city` varchar(255) DEFAULT NULL,
//        `sex` varchar(255) DEFAULT NULL,
//        `sign` int(11) DEFAULT NULL COMMENT '标记',
//        `headPic` varchar(255) DEFAULT NULL,
//        `status` varchar(255) DEFAULT NULL,
//        `data` date DEFAULT NULL,
//        PRIMARY KEY (`id`)
public class User {
    private Integer id;
    private String phoneNum;
    private String username;
    private String password;
    private String salt;
    private String dharmaName;
    private String province;
    private String city;
    private String sex;
    private Integer sign;
    private String headPic;
    private String status;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JSONField(format="yyyy-MM-dd")
    private Date data;


    public User() {
    }

    public User(Integer id, String phoneNum, String username, String password, String salt, String dharmaName, String province, String city, String sex, Integer sign, String headPic, String status, Date data) {
        this.id = id;
        this.phoneNum = phoneNum;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.dharmaName = dharmaName;
        this.province = province;
        this.city = city;
        this.sex = sex;
        this.sign = sign;
        this.headPic = headPic;
        this.status = status;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getDharmaName() {
        return dharmaName;
    }

    public void setDharmaName(String dharmaName) {
        this.dharmaName = dharmaName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getSign() {
        return sign;
    }

    public void setSign(Integer sign) {
        this.sign = sign;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", phoneNum='" + phoneNum + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", dharmaName='" + dharmaName + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", sex='" + sex + '\'' +
                ", sign=" + sign +
                ", headPic='" + headPic + '\'' +
                ", status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}
