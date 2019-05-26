package com.jnshu.controller;

import com.jnshu.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonTestController {

    @RequestMapping(value = "/requestJsonTest",method = RequestMethod.POST)
    public @ResponseBody Student requestJsonTest(@RequestBody Student student){
        System.out.println("requestJson的student是："+student.toString());
        System.out.println("requestJson 前台传过来的student的名称是："+student.getS_name());
        //@ResponseBody将student转成json格式输出
        return student;
    }

    /*跳转到测试页面*/
    @RequestMapping("/jumpJsonTest")
    public String jumpJsonTest(){
        return "requestJsonTest";
    }

}
