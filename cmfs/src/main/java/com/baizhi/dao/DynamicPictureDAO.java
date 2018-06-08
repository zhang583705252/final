package com.baizhi.dao;

import com.baizhi.entity.DynamicPicture;

import java.util.List;

public interface DynamicPictureDAO {
    //查所有
    List<DynamicPicture> queryAll();
    //添加图片
    void insertPicture(DynamicPicture dynamicPicture);
    //删除图片
    void deletePicture(List<Integer> list);
    //修改图片
    void updataPicture(DynamicPicture dynamicPicture);
    //根据id查图片
    DynamicPicture queryBy_id(Integer id);
}
