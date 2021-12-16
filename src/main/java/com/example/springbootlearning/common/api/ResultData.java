package com.example.springbootlearning.common.api;

import com.example.springbootlearning.common.exception.CustomException;
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
     * 请求是否处理成功
     */
    private boolean isOK;
    /**
     * 请求响应状态码
     */
    private int code;
    /**
     * 请求结果描述信息
     */
    private String message;
    /**
     * 请求结果数据（通常用于查询操作）
     */
    private T data;
    /**
     * 时间戳
     */
    private long timestamp ;

    public ResultData() {
        this.timestamp = System.currentTimeMillis();
    }

    public ResultData(Boolean isOK, int code, String message, T data) {
        this.isOK = isOK;
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }

    public ResultData(Boolean isOK, int code, String message) {
        this.isOK = isOK;
        this.code = code;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * 成功返回结果
     *
     * @return {@link ResultData}<{@link T}>
     */
    public static <T> ResultData<T> success() {
        return new ResultData<T>(Boolean.TRUE, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), null);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     * @return {@link ResultData}<{@link T}>
     */
    public static <T> ResultData<T> success(T data) {
        return new ResultData<T>(Boolean.TRUE, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data    获取的数据
     * @param message 提示信息
     * @return {@link ResultData}<{@link T}>
     */
    public static <T> ResultData<T> success(T data, String message) {
        return new ResultData<T>(Boolean.TRUE, ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 错误返回结果
     *
     * @param e e
     * @return {@link ResultData}<{@link T}>
     */
    public static <T> ResultData<T> error(CustomException e) {
        return new ResultData<T>(Boolean.FALSE, e.getCode(), e.getMessage());
    }

    /**
     * 错误返回结果
     *
     * @param iErrorCode   我的错误代码
     * @param errorMessage 错误消息
     * @return {@link ResultData}<{@link T}>
     */
    public static <T> ResultData<T> error(IErrorCode iErrorCode, String errorMessage) {
        return new ResultData<T>(Boolean.FALSE, iErrorCode.getCode(), errorMessage);
    }
}
