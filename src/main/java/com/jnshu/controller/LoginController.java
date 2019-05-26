package com.jnshu.controller;

import com.jnshu.pojo.Auth;
import com.jnshu.service.IAuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/students")
public class LoginController {

//    日志
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    IAuthService iAuthService;

    @RequestMapping("/login")
    public String findAuth(HttpSession session, Auth auth){
        if (iAuthService.findAuth(auth)){
            session.setAttribute("username",auth.getUsername());
        }
        return "redirect:/students";
    }

    @RequestMapping("logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/students/login";
    }
}
