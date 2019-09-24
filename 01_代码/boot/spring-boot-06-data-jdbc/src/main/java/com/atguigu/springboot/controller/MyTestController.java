package com.atguigu.springboot.controller;

import com.atguigu.springboot.util.SpringContextUtils;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;


@Controller
public class MyTestController {


    @RequestMapping("/index")
    public String toIndex(HttpServletRequest request){
        SpringContextUtils.setApplicationContext(WebApplicationContextUtils.getWebApplicationContext(request.getServletContext()));
        AutowireCapableBeanFactory beanFactory = SpringContextUtils.getApplicationContext().getAutowireCapableBeanFactory();

        TestAutowired testAutowired = new TestAutowired();
        beanFactory.autowireBeanProperties(testAutowired, AutowireCapableBeanFactory.AUTOWIRE_BY_NAME, true );

        System.out.println(testAutowired.myTestController);

        return "index";
    }

    @RequestMapping("/testSpringContextUtils")
    public String testSpringContextUtils(){
        return "index";
    }

}
