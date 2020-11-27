package com.cido.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping({"/", "/login", "/login.html"})
    public String index() {
        return "login";
    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}
