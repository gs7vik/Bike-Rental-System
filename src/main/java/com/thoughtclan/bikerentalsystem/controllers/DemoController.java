package com.thoughtclan.bikerentalsystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("checkout")
public class DemoController {

    @GetMapping("/")
    public String search(){
        return "hello world";
    }
}
