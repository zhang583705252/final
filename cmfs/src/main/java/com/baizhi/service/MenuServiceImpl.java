package com.baizhi.service;

import com.baizhi.dao.MenuDAO;
import com.baizhi.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDAO menuDAO;

    public MenuDAO getMenuDAO() {
        return menuDAO;
    }

    public void setMenuDAO(MenuDAO menuDAO) {
        this.menuDAO = menuDAO;
    }

    @Override
    public List<Menu> quaryAllService(){
        List<Menu> menus=menuDAO.queryAll();

        return menus;
    }
}
