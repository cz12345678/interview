package com.learn.webjsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyTestController {

    @RequestMapping("/abc")
    public String toSuccess(Model model){
        System.out.println("--------------");
        model.addAttribute("msg", "xx");
        return "success";
    }

}
