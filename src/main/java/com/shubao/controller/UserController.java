package com.shubao.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shubao.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

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

    /**
     * 使用ResponseBody注解，告诉Spring框架，该方法不进行视图跳转，直接进行数据响应
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/quick7")  //, produces= MediaType.TEXT_HTML_VALUE+";charset=utf-8"
    @ResponseBody  //告知Spring框架，该方法不进行视图跳转，直接进行数据响应
    public String save7() throws Exception {
        return "hello,spring!";
    }

    @RequestMapping(value = "/quick8")
    @ResponseBody
    public String save8() throws Exception {
        return "{\"username\": \"zhangsan\", \"age\": 18}";
    }

    /**
     * 使用Jackson手动转换POJO对象为json格式
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/quick9")
    @ResponseBody
    public String save9() throws Exception {
        User user = new User();
        user.setUsername("zhangsan");
        user.setAge(18);

        //使用json的转换工具，将对象转换成json格式字符串返回
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        return json;
    }

    /**
     * 通过Spring MVC的注解驱动解析POJO对象类型的响应数据
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/quick10")
    @ResponseBody
    public User save10() throws Exception {
        User user = new User();
        user.setUsername("zhangsan");
        user.setAge(18);
        return user;
    }

    /**
     * 请求参数类型为普通数据类型
     * @param username 用户名
     * @param age 年龄
     * @throws Exception
     */
    @RequestMapping(value = "/quick11")
    @ResponseBody
    public void save11(String username, int age) throws Exception {
        System.out.println(username);
        System.out.println(age);
    }

    /**
     * 请求参数类型为POJO对象
     * @param user
     * @throws Exception
     */
    @RequestMapping(value = "/quick12")
    @ResponseBody
    public void save12(User user) throws Exception {
        System.out.println(user);
    }

    /**
     * 请求参数类型为数组
     * @param strs
     * @throws Exception
     */
    @RequestMapping(value = "/quick13")
    @ResponseBody
    public void save13(String[] strs) throws Exception {
        System.out.println(Arrays.asList(strs));
    }

}
