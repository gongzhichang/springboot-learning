package com.example.springbootlearning.controller.sys;


import com.example.springbootlearning.common.annotations.ModelView;
import com.example.springbootlearning.entity.sys.SysMenu;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 菜单管理表 前端控制器
 * </p>
 *
 * @author admin
 * @since 2021-12-27
 */
@Controller
@RequestMapping("/system/menu")
public class SysMenuController {

    /**
     * 菜单管理首页
     *
     * @return
     */
    @GetMapping("/index")
    @ModelView
    public String index() {
        return "/system/menu/index";
    }

}
