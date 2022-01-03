package com.shubao.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//配置该类是Spring的核心配置类
@Configuration
/*
 <!--  配置组件扫描  -->
 <context:component-scan base-package="com.shubao"></context:component-scan>
 */
@ComponentScan("com.shubao")

/*
引入子配置文件类
<import resource="xxx.xxx"></import>
 */
@Import({DataSourceConfiguration.class})
public class SpringConfiguration {

}
