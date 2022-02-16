package com.example.springbootlearning.common.exception;

import com.example.springbootlearning.common.api.CustomExceptionType;
import com.example.springbootlearning.common.api.ResultCode;

/**
 * 自定义异常
 *
 * @author admin
 * @date 2021/12/16
 */
public class CustomException extends RuntimeException {

    /**
     * 异常错误编码
     */
    private int code;
    /**
     * 异常错误信息
     */
    private String message;

    public CustomException() {}

    public CustomException(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public CustomException(ResultCode resultCode, String message) {
        this.code = resultCode.getCode();
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
