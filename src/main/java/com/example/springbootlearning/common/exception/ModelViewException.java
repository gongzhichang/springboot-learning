package com.example.springbootlearning.common.exception;

/**
 * 模型视图异常
 *
 * @author admin
 * @date 2021/12/16
 */
public class ModelViewException extends RuntimeException {

    public ModelViewException(Throwable cause) {
        super(cause);
    }

    /**
     * 将Exception转换ModelViewException
     *
     * @param cause 导致
     * @return {@link ModelViewException}
     */
    public static ModelViewException transfer(Throwable cause) {
        return new ModelViewException(cause);
    }
}
