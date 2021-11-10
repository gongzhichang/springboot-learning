package com.example.springbootlearning.common.api;

import lombok.Data;

/**
 * 结果
 *
 * @author: admin
 * @date 2021/11/10
 */
@Data
public class ResultData<T> {

    /**
     * 状态码
     */
    private long status;
    /**
     * 消息
     *
     * @see String
     */
    private String message;
    /**
     * 数据
     *
     * @see T
     */
    private T data;
    /**
     * 时间戳
     */
    private long timestamp ;

    public ResultData() {
        this.timestamp = System.currentTimeMillis();
    }

    public ResultData(long status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> ResultData<T> success(T data) {
        return new ResultData<T>(ResultCodeI.SUCCESS.getCode(), ResultCodeI.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     * @param  message 提示信息
     */
    public static <T> ResultData<T> success(T data, String message) {
        return new ResultData<T>(ResultCodeI.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败返回结果
     * @param errorCode 错误码
     */
    public static <T> ResultData<T> failed(IErrorCode errorCode) {
        return new ResultData<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 失败返回结果
     * @param message 提示信息
     */
    public static <T> ResultData<T> failed(String message) {
        return new ResultData<T>(ResultCodeI.FAILED.getCode(), message, null);
    }

    /**
     * 失败返回结果
     */
    public static <T> ResultData<T> failed() {
        return failed(ResultCodeI.FAILED);
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> ResultData<T> validateFailed() {
        return failed(ResultCodeI.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败返回结果
     * @param message 提示信息
     */
    public static <T> ResultData<T> validateFailed(String message) {
        return new ResultData<T>(ResultCodeI.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     */
    public static <T> ResultData<T> unauthorized(T data) {
        return new ResultData<T>(ResultCodeI.UNAUTHORIZED.getCode(), ResultCodeI.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> ResultData<T> forbidden(T data) {
        return new ResultData<T>(ResultCodeI.FORBIDDEN.getCode(), ResultCodeI.FORBIDDEN.getMessage(), data);
    }
}
