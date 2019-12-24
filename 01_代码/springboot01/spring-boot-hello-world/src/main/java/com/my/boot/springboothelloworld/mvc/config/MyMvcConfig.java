package com.my.boot.springboothelloworld.mvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 扩展MVC配置
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    /**
     * 类似于添加 Servlet 与其对应的路径
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        // super.addViewControllers(registry);
        //浏览器发送 /thunisoft 请求来到 test01
        registry.addViewController("/thunisoft").setViewName("mvc01");
    }

}
