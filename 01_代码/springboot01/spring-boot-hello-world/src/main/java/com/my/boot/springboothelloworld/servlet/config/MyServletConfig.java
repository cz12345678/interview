package com.my.boot.springboothelloworld.servlet.config;

import com.my.boot.springboothelloworld.servlet.component.MyFilter;
import com.my.boot.springboothelloworld.servlet.component.MyLisenter;
import com.my.boot.springboothelloworld.servlet.component.MyServlet;
import org.springframework.boot.web.embedded.tomcat.ConfigurableTomcatWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * 定制和修改 Servlet 的相关配置
 */

@Configuration
public class MyServletConfig {


    /**
     * 注册过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
//        registrationBean.setUrlPatterns(Arrays.asList("/myServlet"));
        registrationBean.setUrlPatterns(Arrays.asList("/*"));
        return registrationBean;
    }

    /**
     * 注册监听器
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean myLisenter(){
        ServletListenerRegistrationBean registrationBean = new ServletListenerRegistrationBean( new MyLisenter());
        return registrationBean;
    }

    /**
     * 注册 Sevlet
     * @return
     */
    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean<MyServlet> registrationBean = new ServletRegistrationBean<>(new MyServlet(), "/myServlet");
        return registrationBean;
    }


    /**
     * 修改 嵌入式服务器（可以简单理解为tomcat等服务器） 的相关配置
     * @return
     */
    @Bean
    public WebServerFactoryCustomizer webServerFactoryCustomizer(){
        return new WebServerFactoryCustomizer<ConfigurableTomcatWebServerFactory>() {
            @Override
            public void customize(ConfigurableTomcatWebServerFactory factory) {
                factory.setPort(9999);
            }
        };
    }

}
