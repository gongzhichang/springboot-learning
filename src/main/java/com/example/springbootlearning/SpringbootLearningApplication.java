package com.example.springbootlearning;

import cn.hutool.core.net.Ipv4Util;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * springboot学习应用
 *
 * @author: admin
 * @date 2021/11/10
 */
@EnableOpenApi
@MapperScan("com.example.springbootlearning.mapper.**")
@SpringBootApplication
@Slf4j
public class SpringbootLearningApplication {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootLearningApplication.class, args);
        // 项目端口
        String port = context.getEnvironment().getProperty("server.port");
        log.info("127.0.0.1:{}",port);
        long endTime = System.currentTimeMillis();
        System.out.println("====启动成功====,耗时：" + (endTime - startTime) + "ms");
    }

}
