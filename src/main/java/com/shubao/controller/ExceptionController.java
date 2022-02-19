package com.shubao.controller;

import com.shubao.service.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {

    @Autowired
    private ExceptionService exceptionService;

    @RequestMapping(value = "/show")
    public String show(){
        System.out.println("show() running...");
        exceptionService.show1();
    }
}
