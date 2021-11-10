package com.example.springbootlearning;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
public class SpringbootLearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootLearningApplication.class, args);
    }

}
