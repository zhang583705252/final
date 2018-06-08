package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Capter implements Serializable {
    private String id;
    private String aname; //文件名
    private String size;  //所占磁盘的空间
    private  String duration;//音频时长
    private String downPath; //下载路径

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date uploadDate; //上传时间
    private String ablum_id;//专辑的id（父id）


    public Capter() {
    }

    public Capter(String id, String aname, String size, String duration, String downPath, Date uploadDate, String ablum_id) {
        this.id = id;
        this.aname = aname;
        this.size = size;
        this.duration = duration;
        this.downPath = downPath;
        this.uploadDate = uploadDate;
        this.ablum_id = ablum_id;
    }

    @Override
    public String toString() {
        return "Capter{" +
                "id=" + id +
                ", aname='" + aname + '\'' +
                ", size=" + size +
                ", duration=" + duration +
                ", downPath='" + downPath + '\'' +
                ", uploadDate=" + uploadDate +
                ", ablum_id=" + ablum_id +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDownPath() {
        return downPath;
    }

    public void setDownPath(String downPath) {
        this.downPath = downPath;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getAblum_id() {
        return ablum_id;
    }

    public void setAblum_id(String ablum_id) {
        this.ablum_id = ablum_id;
    }
}
