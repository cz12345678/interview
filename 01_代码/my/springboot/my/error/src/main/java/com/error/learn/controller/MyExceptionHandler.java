package com.error.learn.controller;

import com.error.learn.exception.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {


    @ExceptionHandler(value = MyException.class)
    public String handleException(Exception e, HttpServletRequest request){

        Map<String,Object> map = new HashMap<>(16);
        /**
         * Integer statusCode = (Integer) request
         .getAttribute("javax.servlet.error.status_code");
         */
        request.setAttribute("javax.servlet.error.status_code", 500);

        map.put("自定义信息K1", "自定义信息V1");
        map.put("自定义信息K2", "自定义信息V2");

        // 将数据存到请求域中
        request.setAttribute("extMap", map);
        // 转发给BasicErrorController进行处理
        return "forward:/error";
    }

}
