package com.example.springbootlearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试控制器
 *
 * @author: admin
 * @date 2021/11/10
 */
@Controller
@RequestMapping("/test")
public class TestController {

    /**
     * hello
     *
     * @return {@link String}
     */
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello, SpringBoot!";
    }
}