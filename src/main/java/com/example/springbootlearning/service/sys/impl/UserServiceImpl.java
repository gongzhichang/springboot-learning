package com.example.springbootlearning.service.sys.impl;

import com.example.springbootlearning.entity.sys.User;
import com.example.springbootlearning.mapper.sys.UserMapper;
import com.example.springbootlearning.service.sys.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 测试表 服务实现类
 * </p>
 *
 * @author admin
 * @since 2021-11-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
