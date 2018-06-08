package com.baizhi.dao;

import com.baizhi.entity.Ablum;

import java.util.List;

public interface AblumDAO {
    //1.专辑的添加
    void insertAblum(Ablum ablum);
    //2.查询专辑
    Ablum selectAblum(String id);
    //3.专辑修改（因为章节添加而修改）
    void updateCount(Ablum ablum);
    //4.查所有的专辑
    List<Ablum>  selectAllAblum();

}
