package com.error.learn.config;

import com.error.learn.component.MyFilter;
import com.error.learn.component.MyLisenter;
import com.error.learn.component.MyServlet;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;
import java.util.logging.Filter;

/**
 * 注册服务器组件
 */
@Configuration
public class ServerConfig extends WebMvcConfigurerAdapter {


    /**
     * 自定义嵌入式Servlet容器
     * @return
     */
    @Bean
    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer(){
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                container.setPort(8888);
                container.setContextPath("/my");
            }
        };

    }


    /**
     * 添加监听器
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean<MyLisenter> registrationBean = new ServletListenerRegistrationBean<>();
        registrationBean.setListener(new MyLisenter());
        return registrationBean;
    }



    /**
     * 添加过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        registrationBean.setUrlPatterns(Arrays.asList("/hello", "/servlet"));
        return registrationBean;
    }

    /**
     * 添加Servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet(),"/servlet");
        registrationBean.setLoadOnStartup(1);
        return registrationBean;
    }




}
