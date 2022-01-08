package com.shubao.web;

import com.shubao.service.UserService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");//价值配置文件
//        req.getServletContext();//获取方式①
        ServletContext servletContext = this.getServletContext();//获取方式②

//        ApplicationContext applicationContext = (ApplicationContext) servletContext.getAttribute("app");
//        ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);

        WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        UserService userService = applicationContext.getBean(UserService.class);
        userService.save();
    }
}
