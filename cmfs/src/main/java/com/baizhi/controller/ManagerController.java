package com.baizhi.controller;

import com.baizhi.entity.Manager;
import com.baizhi.service.ManagerService;

import com.sun.org.apache.bcel.internal.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value="/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    //登陆功能
    @RequestMapping ("login")
    public String loginManager(Manager manager,String encode){
        System.out.println(manager);
        HttpServletRequest request=null;
       try {
//            request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//           String code=(String) request.getSession().getAttribute("code");
//           System.out.println(code);
//           if(!encode.equals(code)){return "redirect:/login.jsp";
//           }else{
               Manager man=managerService.queryManagerServic(manager);
              //request.getSession().setAttribute("managerName",manager.getManagerName());
               return "redirect:/main/main.jsp";
  //         }

       } catch (Exception e) {
           e.printStackTrace();
           e.getMessage();
            return "index";
       }

    }
}
