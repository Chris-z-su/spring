package com.shubao.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shubao.domain.User;
import com.shubao.domain.VO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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

        /*
        Model: 模型，作用是封装数据
        View: 视图，作用是展示数据
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
     * @return 响应的数据
     */
    @RequestMapping(value = "/quick7")  //, produces= MediaType.TEXT_HTML_VALUE+";charset=utf-8"
    @ResponseBody  //告知Spring框架，该方法不进行视图跳转，直接进行数据响应
    public String save7() {
        return "hello,spring!";
    }

    @RequestMapping(value = "/quick8")
    @ResponseBody
    public String save8() {
        return "{\"username\": \"zhangsan\", \"age\": 18}";
    }

    /**
     * 使用Jackson手动转换POJO对象为json格式
     * @return 响应的数据json字符串
     * @throws Exception writeValueAsString()方法的异常
     */
    @RequestMapping(value = "/quick9")
    @ResponseBody
    public String save9() throws Exception {
        User user = new User();
        user.setUsername("zhangsan");
//        user.setAge(18);

        //使用json的转换工具，将对象转换成json格式字符串返回
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(user);
    }

    /**
     * 通过Spring MVC的注解驱动解析POJO对象类型的响应数据
     * @return 响应数据
     */
    @RequestMapping(value = "/quick10")
    @ResponseBody
    public User save10() {
        User user = new User();
        user.setUsername("zhangsan");
//        user.setAge(18);
        return user;
    }

    /**
     * 请求参数类型为普通数据类型
     * @param username 用户名
     * @param age 年龄
     */
    @RequestMapping(value = "/quick11")
    @ResponseBody
    public void save11(String username, int age) {
        System.out.println(username);
        System.out.println(age);
    }

    /**
     * 请求参数类型为POJO对象
     * @param user 请求参数对象
     */
    @RequestMapping(value = "/quick12")
    @ResponseBody
    public void save12(User user) {
        System.out.println(user);
    }

    /**
     * 请求参数类型为数组
     * @param strs 请求参数数组
     */
    @RequestMapping(value = "/quick13")
    @ResponseBody
    public void save13(String[] strs) {
        System.out.println(Arrays.asList(strs));
    }

    /**
     * 请求参数类型为集合，用POJO对象接收
     * @param vo 请求参数VO对象
     */
    @RequestMapping(value = "/quick14")
    @ResponseBody
    public void save14(VO vo) {
        System.out.println(vo);
    }

    /**
     * 使用注解@RequestBody
     * @param userList 请求参数List集合
     */
    @RequestMapping(value = "/quick15")
    @ResponseBody
    public void save15(@RequestBody List<User> userList) {
        System.out.println(userList);
    }

    @RequestMapping(value = "/quick16")
    @ResponseBody
    public void save16(@RequestParam(value = "username", required = false, defaultValue = "tom") String username) {
        System.out.println(username);
    }

    /**
     * Restful风格
     * @param username 用户名
     */
    @RequestMapping(value = "/quick17/{username}")
    @ResponseBody
    public void save17(@PathVariable("username") String username) {
        System.out.println(username);
    }

    /**
     * 自定义转换器：日期格式转换器
     * @param date 日期
     */
    @RequestMapping(value = "/quick18")
    @ResponseBody
    public void save18(Date date) {
        System.out.println(date);
    }

    /**
     * 获取Servlet相关API
     * @param request request对象
     * @param response response对象
     * @param session session对象
     */
    @RequestMapping(value = "/quick19")
    @ResponseBody
    public void save19(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        System.out.println("request = " + request);
        System.out.println("response = " + response);
        System.out.println("session = " + session);
    }

    /**
     * 使用注解@RequestHead获取请求头
     * @param user_agent user_agent对象
     */
    @RequestMapping(value = "/quick20")
    @ResponseBody
    public void save20(@RequestHeader(value = "User-Agent", required = false) String user_agent) {
        System.out.println("user_agent = " + user_agent);
    }

    /**
     * 使用@CookieValue获取cookie的value
     * @param jsessionId JSESSIONID对象
     */
    @RequestMapping(value = "/quick21")
    @ResponseBody
    public void save21(@CookieValue(value = "JSESSIONID", required = false) String jsessionId) {
        System.out.println("jsessionId = " + jsessionId);
    }

    /**
     * 单文件上传
     * @param username 用户名
     * @param file1 文件1
     * @param file2 文件2
     * @throws Exception IO异常
     */
    @RequestMapping(value = "/quick22")
    @ResponseBody
    public void save22(String username, MultipartFile file1, MultipartFile file2) throws Exception {
        System.out.println("username = " + username);
        //获得上传文件的名称
        String originalFilename1 = file1.getOriginalFilename();
        System.out.println("originalFilename1 = " + originalFilename1);
        file1.transferTo(new File("D:\\logs\\" + originalFilename1));

        String originalFilename2 = file2.getOriginalFilename();
        System.out.println("originalFilename2 = " + originalFilename2);
        file2.transferTo(new File("D:\\logs\\" + originalFilename2));
    }

    /**
     * 多文件上传
     * @param username 用户名
     * @param file 文件列表
     * @throws Exception IO异常
     */
    @RequestMapping(value = "/quick23")
    @ResponseBody
    public void save23(String username, MultipartFile[] file) throws Exception {
        System.out.println("username = " + username);
        //获得上传文件的名称
        for (MultipartFile multipartFile : file){
            String originalFilename = multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File("D:\\logs\\" + originalFilename));
        }
    }

}
