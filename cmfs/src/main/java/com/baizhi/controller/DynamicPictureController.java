package com.baizhi.controller;

import com.baizhi.entity.DynamicPicture;
import com.baizhi.service.DynamicPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping(value="/picture")
public class DynamicPictureController {
    @Autowired
    private DynamicPictureService dynamicPictureService;
    //查询所有
    @ResponseBody
    @RequestMapping(value="/queryAll")
    public List<DynamicPicture> queryAllDynamicPicture(){

        List<DynamicPicture> dynamicPictures= dynamicPictureService.queryAllService();
        return dynamicPictures;

    }
    //添加轮播图
    @ResponseBody
    @RequestMapping(value="/add",method = RequestMethod.POST)
    public void addPicture(String title, String desc, String status, Date data, MultipartFile img ,HttpServletRequest request){

        dynamicPictureService.addPictureService(title,desc,status,data,img,request);
    }
    //修改状态
    @ResponseBody
    @RequestMapping(value="/update",method = RequestMethod.POST)
    public String updatePictureContr(DynamicPicture dynamicPicture){
        System.out.println(dynamicPicture.getId());
        dynamicPictureService.updataPicture(dynamicPicture);
        return null;
    }
    //删除行
    @ResponseBody
    @RequestMapping(value="/delete",method = RequestMethod.POST)
    public String deletePictureContr(DynamicPicture dynamicPicture){
        System.out.println(dynamicPicture.getId());
        List<Integer> list=new ArrayList<Integer>();
        list.add(dynamicPicture.getId());
        dynamicPictureService.removePictureService(list);
        return null;
    }
}
