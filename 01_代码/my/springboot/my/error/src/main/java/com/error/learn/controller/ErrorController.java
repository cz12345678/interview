package com.error.learn.controller;

import com.error.learn.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ErrorController {

    @RequestMapping("/exception")
    @ResponseBody
    public String errorTest(Integer id){
        if (id == null){
            throw new MyException("xxxxxxxxxxxx");
        }
        return "name:zhangsan";
    }

}
