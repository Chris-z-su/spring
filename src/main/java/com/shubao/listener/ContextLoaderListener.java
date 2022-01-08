package com.shubao.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //ServletContext对象
        ServletContext servletContext = sce.getServletContext();

//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");//获取Spring配置文件方式①
        //读取web.xml中的全局参数
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");//获取Spring配置文件方式②
        ApplicationContext app = new ClassPathXmlApplicationContext(contextConfigLocation);

        //将Spring的应用上下文对象存储到ServletContext域中
        servletContext.setAttribute("app", app);
        System.out.println("ContextLoaderListener.class: Spring容器创建完毕(applicationContext.xml)。。。");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
