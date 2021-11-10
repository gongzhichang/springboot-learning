package com.example.springbootlearning.mapper.sys;

import com.example.springbootlearning.entity.sys.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void create() {
        User user = new User();
        user.setName("李四");
        user.setAge(22);
        user.setSex("1");
        int insert = userMapper.insert(user);
        System.out.println("insert = " + insert);
    }
}