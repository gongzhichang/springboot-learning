package com.example.springbootlearning.entity.sys;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 测试验证器
 *
 * @author admin
 * @date 2021/12/16
 */
@Data
public class TestValidator {

    private String id;
    @NotEmpty(message = "名称不能为空")
    private String name;
    private int sex;
    private String address;
    private Object remark1;
    private Object remark2;
    private Object remark3;
}
