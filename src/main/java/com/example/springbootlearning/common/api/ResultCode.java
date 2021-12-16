package com.example.springbootlearning.common.api;

/**
 * 返回状态码
 *
 * @author: admin
 * @date 2021/11/10
 */
public enum ResultCode implements IErrorCode {
    SUCCESS(200, "操作成功"),
    USER_INPUT_ERROR(400,"您输入的数据错误或您没有权限访问资源！"),
    SYSTEM_ERROR (500,"系统出现异常，请您稍后再试或联系管理员！"),
    OTHER_ERROR(999,"系统出现未知异常，请联系管理员！");;

    /**
     * 编码
     */
    private int code;
    /**
     * 异常类型描述
     */
    private String message;

    private ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
