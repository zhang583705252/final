package com.baizhi.service;

import com.baizhi.entity.DynamicPicture;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

public interface DynamicPictureService {
    List<DynamicPicture> queryAllService();
    //添加图片
    void addPictureService(String title, String desc, String status, Date data,  MultipartFile img,HttpServletRequest request);
    //删除图片
    void removePictureService(List<Integer> list);
    //修改图片
    void updataPicture(DynamicPicture dynamicPicture);
    //查询图片
    DynamicPicture queryBy_id(DynamicPicture dynamicPicture);
}
