package com.example.springbootlearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录控制器
 *
 * @author: admin
 * @date: 2021/11/22
 */
@Controller
public class LoginController {

    /**
     * 登录页面
     */
    @GetMapping("/login")
    public String page() {
        return "/login";
    }

}
