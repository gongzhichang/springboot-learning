package com.example.springbootlearning.controller;

import com.example.springbootlearning.common.annotations.ModelView;
import com.example.springbootlearning.common.api.ResultCode;
import com.example.springbootlearning.common.api.ResultData;
import com.example.springbootlearning.common.exception.CustomException;
import com.example.springbootlearning.entity.sys.TestValidator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

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

    /**
     * 错误
     */
    @GetMapping("/error")
    @ResponseBody
    public void error() {
        try {
            int i = 1/0;
        } catch (Exception e) {
            throw new CustomException(ResultCode.USER_INPUT_ERROR, "自定义异常");
        }

    }

    /**
     * 页面请求
     */
    @GetMapping("/page")
    @ModelView
    public String page() {
        int i = 1/0;
        return "/test";
    }

    /**
     * 测试参数验证
     */
    @PostMapping("/vali")
    public ResultData<String> testVal(@Valid @RequestBody TestValidator testValidator) {
        return ResultData.success();
    }
}
