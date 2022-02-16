package com.example.springbootlearning.controller.sys;

import com.example.springbootlearning.common.annotations.ModelView;
import com.example.springbootlearning.entity.sys.SysMenu;
import com.example.springbootlearning.service.sys.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 系统首页 Controller
 *
 * @author admin
 * @date 2021/12/22
 */
@Controller
public class SysIndexController {

    @Autowired
    private ISysMenuService sysMenuService;

    /**
     * 系统首页
     *
     * @return
     */
    @GetMapping("/index")
    @ModelView
    public String index(Model model) {
        List<SysMenu> sysMenus = sysMenuService.menuTree();
        model.addAttribute("menus", sysMenus);
        return "/system/index";
    }
}
