package com.baizhi.controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
* 自定义注解
* */
//注解运用的位置
@Target(ElementType.FIELD)
//注解运行的时机
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    public  String name();
}
