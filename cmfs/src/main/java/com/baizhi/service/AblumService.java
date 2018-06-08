package com.baizhi.service;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.Ablum;

import java.util.List;

public interface AblumService {
    //1.专辑的添加
    void insertAblumService(Ablum ablum);
    //2.查询专辑
    JSONObject selectAblumService(String id);
    //3.专辑修改（因为章节添加而修改）
    void updateCountService(Ablum ablum);
    //4.查所有的专辑
    List<Ablum> selectAllAblumService();
}
