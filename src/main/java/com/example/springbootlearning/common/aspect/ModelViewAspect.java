package com.example.springbootlearning.common.aspect;

import com.example.springbootlearning.common.exception.ModelViewException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 页面请求异常切面
 *
 * @author admin
 * @date 2021/12/16
 */
@Aspect
@Component
@Slf4j
public class ModelViewAspect {

    /**
     * 设置切入点：这里直接拦截被@ModelView注解的方法
     */
    @Pointcut("@annotation(com.example.springbootlearning.common.annotations.ModelView)")
    public void pointcut() { }

    /**
     * 当有ModelView的注解的方法抛出异常的时候，做如下的处理
     */
    @AfterThrowing(pointcut = "pointcut()", throwing = "e")
    public void afterThrowing(Throwable e) {
        throw ModelViewException.transfer(e);
    }
}
