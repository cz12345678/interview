package com.my.boot.springboothelloworld.error.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 异常测试的类
 */

@RestController
public class ErrorTestController {

    @GetMapping("/test01")
    public String testError01(){
        int i= 1 / 0;
        return "success";
    }

}
