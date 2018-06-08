package com.baizhi.dao;

import com.baizhi.entity.Manager;

public interface ManagerDAO {
    Manager queryManagerBy_Name(String managerName);
}
