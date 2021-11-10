package com.example.springbootlearning.controller.sys;


import com.example.springbootlearning.entity.sys.User;
import com.example.springbootlearning.service.sys.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 测试表 前端控制器
 * </p>
 *
 * @author admin
 * @since 2021-11-10
 */
@Api("用户信息管理")
@RestController
@RequestMapping("/sys/user")
public class UserController {

    @Resource
    private IUserService userService;

    /**
     * 创建用户
     *
     * @param user 用户
     */
    @PostMapping("/create")
    @ApiOperation("创建用户")
    public void createUser(User user){
        boolean flag = userService.save(user);
    }

}
