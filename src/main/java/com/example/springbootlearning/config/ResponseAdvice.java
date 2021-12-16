package com.example.springbootlearning.config;

import com.example.springbootlearning.common.api.ResultData;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.annotation.Resource;

/**
 * 返回结果统一标准格式封装
 *
 * @author: admin
 * @date 2021/11/10
 */
@ControllerAdvice
@Component
public class ResponseAdvice implements ResponseBodyAdvice<Object> {

    @Resource
    private ObjectMapper objectMapper;

    /**
     * 是否支持advice功能
     *
     * true 支持，false 不支持
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    /**
     * 对返回的数据进行处理
     */
    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        // 如果响应结果是JSON数据类型
        if(selectedContentType.equalsTypeAndSubtype(
                MediaType.APPLICATION_JSON)){
            // 为HTTP响应结果设置状态码，状态码就是ResultData的code，二者达到统一
            if(body instanceof ResultData){
                ResultData resultData = (ResultData)body;
                // 999 不是标准的HTTP状态码，特殊处理
                if(resultData.getCode() != 999){
                    response.setStatusCode(HttpStatus.valueOf(resultData.getCode()));
                }
                return body;
            } else {
                response.setStatusCode(HttpStatus.OK);
                return ResultData.success(body);
            }
        }
        return body;
    }


}
