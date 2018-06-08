package com.baizhi.controller;

import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@Controller
@RequestMapping(value="/menu")
public class MenuController {
    //查询所有的轮播图
    @Autowired
    private MenuService menuService;


    @RequestMapping("queryAll")
    public @ResponseBody List<Menu>  queryAll(){
        List<Menu> menus= menuService.quaryAllService();
        System.out.println(menus.size());
        return  menus;
    }
}
