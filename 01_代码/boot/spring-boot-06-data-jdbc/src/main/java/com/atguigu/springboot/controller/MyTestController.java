package com.atguigu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MyTestController {


    @RequestMapping("/index")
    public String toIndex(){
        return "index";
    }

}
