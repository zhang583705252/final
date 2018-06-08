package com.baizhi.entity;

import java.io.Serializable;
import java.util.List;

/*
    `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `iconCls` varchar(255) DEFAULT NULL,
  `prent_id` int(11) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
 */
public class Menu implements Serializable{
    private Integer id;
    private String title;
    private String iconCls;
    private Integer prent_id;
    private String url;
    private List<Menu> list;

    public List<Menu> getList() {
        return list;
    }

    public void setList(List<Menu> list) {
        this.list = list;
    }

    public Menu() {
    }

    public Menu(Integer id, String title, String iconCls, Integer prent_id, String url) {
        this.id = id;
        this.title = title;
        this.iconCls = iconCls;
        this.prent_id = prent_id;
        this.url = url;
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

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public Integer getPrent_id() {
        return prent_id;
    }

    public void setPrent_id(Integer prent_id) {
        this.prent_id = prent_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", prent_id=" + prent_id +
                ", url='" + url + '\'' +
                ", list=" + list +
                '}';
    }
}
