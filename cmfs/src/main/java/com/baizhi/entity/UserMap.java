package com.baizhi.entity;



public class UserMap {
    private  String key;
    private  Integer value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "UserMap{" +
                "key='" + key + '\'' +
                ", value=" + value +
                '}';
    }
}
