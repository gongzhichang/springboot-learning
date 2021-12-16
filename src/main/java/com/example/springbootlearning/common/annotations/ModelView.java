package com.example.springbootlearning.common.annotations;

import java.lang.annotation.*;

/**
 * 页面请求注解
 *
 * @author admin
 * @date 2021/12/16
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ModelView {
}
