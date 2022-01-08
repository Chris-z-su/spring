package com.shubao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/quick")
    public String save(){
        System.out.println("UserController.save() running...");
        return "success.jsp";
    }

}
