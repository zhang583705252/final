package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;

public class DynamicPicture implements Serializable{

    private Integer id;
    private String title;
    private String imgPath;
    private String desc;
    private String status;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date data;

    @Override
    public String toString() {
        return "DynamicPicture{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", desc='" + desc + '\'' +
                ", status='" + status + '\'' +
                ", date=" + data +
                '}';
    }

    public DynamicPicture() {
    }

    public DynamicPicture(Integer id, String title, String imgPath, String desc, String status, Date data) {
        this.id = id;
        this.title = title;
        this.imgPath = imgPath;
        this.desc = desc;
        this.status = status;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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
}
