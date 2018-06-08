package com.baizhi.controller;

import com.baizhi.service.CapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping(value="/capter")
@Controller
public class CapterController {
    @Autowired
    private CapterService capterService;
    //1.上传文件
    @RequestMapping(value="/addCapter",method = RequestMethod.POST)
    @ResponseBody
    public String  addCapter(MultipartFile eudio,String id,HttpServletRequest request){
        System.out.println("**********");
        System.out.println(eudio);
        boolean b=capterService.insertCapterService(eudio,id,request);
        if(b){return "添加成功";}
        else {return "添加失败";}

    }
    //2.下载文件
    @RequestMapping(value="/downCapter",method = RequestMethod.POST)
    @ResponseBody
    public void downCapter(String url, String oldName, HttpServletRequest request, HttpServletResponse response){
        System.out.println("**********");
        capterService.downCapterService(url,oldName,request,response);

    }
}
