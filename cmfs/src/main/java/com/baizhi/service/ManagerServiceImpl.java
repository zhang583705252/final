package com.baizhi.service;

import com.baizhi.dao.ManagerDAO;
import com.baizhi.entity.Manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ManagerServiceImpl implements ManagerService{
    @Autowired
    private ManagerDAO managerDAO;

    public ManagerDAO getManagerDAO() {
        return managerDAO;
    }

    public void setManagerDAO(ManagerDAO managerDAO) {
        this.managerDAO = managerDAO;
    }

    public Manager queryManagerServic(Manager manager){
        try{
            Manager man=managerDAO.queryManagerBy_Name(manager.getManagerName());
            if(man==null){throw new RuntimeException("该用户不存在");}
            else if(!man.getPassword().equals(manager.getPassword())) {
                throw new RuntimeException("密码不对");
            }else return man;
        }catch (Exception e){
            e.printStackTrace();
            throw  new  RuntimeException(e.getMessage());
        }

    }
}
