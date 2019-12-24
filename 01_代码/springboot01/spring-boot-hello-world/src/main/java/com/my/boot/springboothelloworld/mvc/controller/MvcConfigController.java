package com.my.boot.springboothelloworld.mvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MvcConfigController {

    @GetMapping("/mvc01")
    public String test01(){
        return "success";
    }
}
