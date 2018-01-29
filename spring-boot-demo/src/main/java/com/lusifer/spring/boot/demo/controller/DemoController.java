package com.lusifer.spring.boot.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @RequestMapping(value = "hi")
    public String sayHi() {
        return "Hello Spring Boot";
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
    }
}
