package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Ablum implements  Serializable {
    private String id;
    private String aname;
    private String coverImg; //封面的路径
    private Integer count;  //该专辑包含的章节
    private Double star;    //推荐指数 *****
    private String author;  //作者
    private String broadCast;  //播音
    private String  prief;     //简介
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date publishDate; //发布日期
    private  String url; //对应的.jsp 的路径

    private List<Capter> children; //章节集合

    public Ablum() {
    }

    public Ablum(String id, String aname, String coverImg, Integer count, Double star, String author, String broadCast, String prief, Date publishDate, String url) {
        this.id = id;
        this.aname = aname;
        this.coverImg = coverImg;
        this.count = count;
        this.star = star;
        this.author = author;
        this.broadCast = broadCast;
        this.prief = prief;
        this.publishDate = publishDate;
        this.url = url;
    }

    public List<Capter> getChildren() {
        return children;
    }

    public void setcChildren(List<Capter> children) {
        this.children = children;
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

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getStar() {
        return star;
    }

    public void setStar(Double star) {
        this.star = star;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBroadCast() {
        return broadCast;
    }

    public void setBroadCast(String broadCast) {
        this.broadCast = broadCast;
    }

    public String getPrief() {
        return prief;
    }

    public void setPrief(String prief) {
        this.prief = prief;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Ablum{" +
                "id='" + id + '\'' +
                ", aname='" + aname + '\'' +
                ", coverImg='" + coverImg + '\'' +
                ", count=" + count +
                ", star=" + star +
                ", author='" + author + '\'' +
                ", broadCast='" + broadCast + '\'' +
                ", prief='" + prief + '\'' +
                ", publishDate=" + publishDate +
                ", url='" + url + '\'' +
                ", children=" + children +
                '}';
    }
}
