package com.example.springbootlearning.service.sys;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springbootlearning.entity.sys.SysMenu;

import java.util.List;

/**
 * <p>
 * 菜单管理表 服务类
 * </p>
 *
 * @author admin
 * @since 2021-12-27
 */
public interface ISysMenuService extends IService<SysMenu> {

    /**
     * 菜单树
     *
     * @return {@link List}<{@link SysMenu}>
     */
    List<SysMenu> menuTree();

}
