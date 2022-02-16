package com.example.springbootlearning.entity.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 菜单管理表
 * </p>
 *
 * @author admin
 * @since 2021-12-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="SysMenu对象", description="菜单管理表")
public class SysMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "上级菜单id")
    private Long parentId;

    @ApiModelProperty(value = "菜单名称")
    private String name;

    @ApiModelProperty(value = "菜单路径")
    private String url;

    @ApiModelProperty(value = "菜单权限")
    private String permission;

    @ApiModelProperty(value = "菜单图标")
    private String icon;

    @ApiModelProperty(value = "菜单排序")
    private Integer sort;

    @ApiModelProperty(value = "是否外链")
    private Boolean iFrame;

    @ApiModelProperty(value = "菜单组件")
    private String component;

    @ApiModelProperty(value = "菜单类型")
    private Integer type;

    @ApiModelProperty(value = "子菜单数目")
    private Integer subCount;

    @ApiModelProperty(value = "菜单标题")
    private String title;

    @ApiModelProperty(value = "菜单状态（0显示 1隐藏）")
    private Boolean hidden;

    @ApiModelProperty(value = "菜单状态（0正常 1停用）")
    private Boolean status;

    @ApiModelProperty(value = "创建者")
    private String createBy;

    @ApiModelProperty(value = "更新者")
    private String updateBy;

    @ApiModelProperty(value = "创建日期")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @TableField(exist = false)
    private List<SysMenu> children;


}
