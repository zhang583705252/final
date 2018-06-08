package com.baizhi.controller;


import com.baizhi.entity.CreateValidateCode;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


import javax.servlet.http.HttpServletRequest;
import java.io.OutputStream;

@Controller
@RequestMapping(value="/random")
public class RandomController {
    private String email;
    private String password;
    private String code;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @RequestMapping(value="/image")
    public String execute(OutputStream out) throws Exception {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        JedisPoolConfig config = new JedisPoolConfig();
        //和redis数据库建立连接
        JedisPool s = new JedisPool(config, "127.0.0.1", 6379);
        //1. 得到随机数
        CreateValidateCode cvc = new CreateValidateCode();
        String code = cvc.getCode();
        //将验证码存入redis数据库
         s.getResource().set("code",code);
        //3. 调用工具类的方法画图片
        cvc.write(out);

        return null;
    }



}
