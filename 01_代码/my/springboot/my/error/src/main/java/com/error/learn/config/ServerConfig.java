package com.error.learn.config;

import com.error.learn.component.MyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 注册服务器组件
 */
@Configuration
public class ServerConfig extends WebMvcConfigurerAdapter {


    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet(),"/servlet");
        registrationBean.setLoadOnStartup(1);
        return registrationBean;
    }




}
