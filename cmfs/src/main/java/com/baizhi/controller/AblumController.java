package com.baizhi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.Ablum;

import com.baizhi.service.AblumService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value="/album")
public class AblumController {
    @Autowired
    private AblumService  ablumService;
    //1.查询专辑
    @RequestMapping(value="/queryAllAlbum")//,method = RequestMethod.POST)
    @ResponseBody
    public List<Ablum> queryAllAlbum(){
        List<Ablum> ablums=ablumService.selectAllAblumService();
        return  ablums;
    }
    //2.添加专辑
    @RequestMapping(value="/addAblum",method = RequestMethod.POST)
    @ResponseBody
    public  void  addAblum(Ablum ablum){
        ablumService.insertAblumService(ablum);

    }
    //3.专辑的详情ye
    @RequestMapping(value="/wen")
    @ResponseBody
    public JSONObject wen(String uid,String ablum_id){
        JSONObject jsonObject=ablumService.selectAblumService(ablum_id);
        return jsonObject;
    }
}
