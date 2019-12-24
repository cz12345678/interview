package com.my.boot.springboothelloworld.error.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 异常处理类
 */

@ControllerAdvice
public class MyExceptionHandler {


    /**
     * 异常处理方法
     * @param e
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    public String handlerException(Exception e, HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code","my-exception-message");
        map.put("message",e.getMessage());
        return "forward:/error";
    }
//    @ExceptionHandler(RuntimeException.class)
//    public Map<String, Object> handlerException(Exception e){
//        Map<String,Object> map = new HashMap<>();
//        map.put("code","user.notexist");
//        map.put("message",e.getMessage());
//        return map;
//    }

}
