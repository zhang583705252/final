package com.baizhi.service;

import  com.alibaba.fastjson.JSONObject;
import com.baizhi.dao.AblumDAO;
import com.baizhi.entity.Ablum;
import com.baizhi.entity.Capter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Transactional
@Service
public class AblumServiceImpl implements AblumService {
    @Autowired
    private AblumDAO ablumDAO;

    @Override
    public JSONObject selectAblumService(String id) {
        List<JSONObject> list1=new ArrayList<JSONObject>();
        Ablum ablum=ablumDAO.selectAblum(id);
        JSONObject jsonObject =new JSONObject();
        jsonObject.put("id",ablum.getId());
        jsonObject.put("aname",ablum.getAname());
        jsonObject.put("author",ablum.getAuthor());
        jsonObject.put("prief",ablum.getPrief());
        jsonObject.put("publishDate",ablum.getPublishDate());
        List<Capter> capters=ablum.getChildren();
        for (Capter capter :capters) {
            jsonObject.put("aname",capter.getAname());
            jsonObject.put("size",capter.getSize());
            jsonObject.put("downPath",capter.getDownPath());
            jsonObject.put("uploadDate",capter.getUploadDate());
            jsonObject.put("duration",capter.getDuration());
            jsonObject.put("id",capter.getId());
            list1.add(jsonObject);

        }
        jsonObject.put("children",list1);
        return jsonObject;
    }

    @Override
    public void insertAblumService(Ablum ablum) {
        String id=UUID.randomUUID().toString();
        ablum.setId(id);
        ablumDAO.insertAblum(ablum);
    }

    @Override
    public void updateCountService(Ablum ablum) {
        //先通过id将数据库的数据查出来
        Ablum abl=ablumDAO.selectAblum(ablum.getId());
        abl.setCount(ablum.getCount());
        ablumDAO.updateCount(abl);

    }

    @Override
    public List<Ablum> selectAllAblumService() {
       List<Ablum> ablums= ablumDAO.selectAllAblum();
       if(ablums==null) throw new RuntimeException("没有专辑");
       else return ablums;
    }
}
