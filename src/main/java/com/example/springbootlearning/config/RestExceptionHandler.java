package com.example.springbootlearning.config;

import com.example.springbootlearning.common.api.CustomExceptionType;
import com.example.springbootlearning.common.api.ResultCode;
import com.example.springbootlearning.common.api.ResultData;
import com.example.springbootlearning.common.exception.CustomException;
import com.example.springbootlearning.common.exception.ModelViewException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 *
 * @author: admin
 * @date: 2021/11/10
 */
@ControllerAdvice
@Slf4j
public class RestExceptionHandler {

    /**
     * 处理程序员在程序中未能捕获（遗漏的）异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultData exception(Exception e) {
        //TODO 将异常信息持久化处理，方便运维人员处理
        e.printStackTrace();
        log.error("全局异常信息 ex={}", e.getMessage(), e);
        return ResultData.error(new CustomException(ResultCode.OTHER_ERROR, ""));
    }

    /**
     * 处理程序员主动转换的自定义异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public ResultData customerException(CustomException e) {
        log.error("全局异常信息 ex={}", e.getMessage(), e);
        if(e.getCode() == CustomExceptionType.SYSTEM_ERROR.getCode()){
            //400异常不需要持久化，将异常信息以友好的方式告知用户就可以
            //TODO 将500异常信息持久化处理，方便运维人员处理
        }
        return ResultData.error(e);
    }

    /**
     * 处理方法参数无效异常
     *
     * @param ex
     * @return {@link ResultData}
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResultData handleBindException(MethodArgumentNotValidException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldError();
        return ResultData.error(new CustomException(ResultCode.USER_INPUT_ERROR,
                fieldError.getDefaultMessage()));
    }

    /**
     * 处理绑定异常
     *
     * @param ex
     * @return {@link ResultData}
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResultData handleBindException(BindException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldError();
        return ResultData.error(new CustomException(ResultCode.USER_INPUT_ERROR,
                fieldError.getDefaultMessage()));
    }

    /**
     * 处理页面请求异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(ModelViewException.class)
    public ModelAndView viewExceptionHandler(HttpServletRequest req, ModelViewException e) {
        ModelAndView modelAndView = new ModelAndView();
        //将异常信息设置如modelAndView
        modelAndView.addObject("exception", e);
        modelAndView.addObject("url", req.getRequestURL());
        modelAndView.setViewName("error");
        //返回ModelAndView
        return modelAndView;
    }

    /**
     * 判断是否是Ajax请求
     *
     * @param request
     * @return
     */
    public boolean isAjax(HttpServletRequest request) {
        return (request.getHeader("X-Requested-With") != null &&
                "XMLHttpRequest".equals(request.getHeader("X-Requested-With").toString()));
    }
}
