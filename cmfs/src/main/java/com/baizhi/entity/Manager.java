package com.baizhi.entity;

import java.io.Serializable;

public class Manager implements Serializable{
    private Integer id;
    private String managerName;
    private String password;

    public Manager() {
    }

    public Manager(Integer id, String managerName, String password) {
        this.id = id;
        this.managerName = managerName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", managerName='" + managerName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
