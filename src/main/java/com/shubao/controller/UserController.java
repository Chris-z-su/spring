package com.shubao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    @RequestMapping(value = "/quick2")
    public ModelAndView save2(){
        /**
         * Model: 模型，作用是封装数据
         * View: 视图，作用是展示数据
         */
        ModelAndView modelAndView = new ModelAndView();
        //设置模型数据
        modelAndView.addObject("username", "zhangsan");
        //设置视图名
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping(value = "/quick3")
    public ModelAndView save3(ModelAndView modelAndView){
        //设置模型数据
        modelAndView.addObject("username", "lisi");
        //设置视图名
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping(value = "/quick4")
    public String save4(Model model){
        model.addAttribute("username", "wangwu");
        return "success";
    }

    @RequestMapping(value = "/quick5")
    public String save5(HttpServletRequest request){
        request.setAttribute("username", "张三");
        return "success";
    }

    @RequestMapping(value = "/quick6")
    public void save6(HttpServletResponse response) throws IOException {
        response.getWriter().print("Hello, Spring!");
    }

    @GetMapping(value = "/quick7")  //, produces= MediaType.TEXT_HTML_VALUE+";charset=utf-8"
    @ResponseBody  //告知Spring框架，该方法不进行视图跳转，直接进行数据响应
    public String save7(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("application/json;charset=utf-8");
       return "hello,spring!";
    }

    @RequestMapping(value = "/quick8")
    @ResponseBody  //告知Spring框架，该方法不进行视图跳转，直接进行数据响应
    public String save8() throws Exception {
        return "123";
    }

}
