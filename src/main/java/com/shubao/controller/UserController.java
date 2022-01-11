package com.shubao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/quick", method = RequestMethod.GET, params = {"username"})
    public String save(String username){
        System.out.println("UserController.save() running...");
        System.out.println("username = " + username);

//        return "/success.jsp";//默认方式：forward 转发
//        return "forward:/success.jsp";//forward 转发
//        return "redirect:/success.jsp";//redirect 重定向
        return "success";//配置视图解析器
    }

}
