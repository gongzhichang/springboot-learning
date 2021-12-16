package com.example.springbootlearning.common.api;

/**
 * 错误代码
 *
 * @author: admin
 * @date 2021/11/10
 */
public interface IErrorCode {

    /**
     * 获取状态码
     *
     * @return long
     */
    int getCode();

    /**
     * 获取消息
     *
     * @return {@link String }
     */
    String getMessage();
}
