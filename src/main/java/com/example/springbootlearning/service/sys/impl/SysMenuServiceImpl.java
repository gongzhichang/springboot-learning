package com.example.springbootlearning.service.sys.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootlearning.entity.sys.SysMenu;
import com.example.springbootlearning.mapper.sys.SysMenuMapper;
import com.example.springbootlearning.service.sys.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 菜单管理表 服务实现类
 * </p>
 *
 * @author admin
 * @since 2021-12-27
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<SysMenu> menuTree() {
        LambdaQueryWrapper<SysMenu> lambdaQueryWrapper = Wrappers.lambdaQuery();
        lambdaQueryWrapper.eq(SysMenu::getHidden, 0).eq(SysMenu::getStatus, 0).orderByDesc(SysMenu::getSort);
        List<SysMenu> sysMenus = sysMenuMapper.selectList(lambdaQueryWrapper);
        return getChildPerms(sysMenus, 0);
    }

    private List<SysMenu> getChildPerms(List<SysMenu> menuList, long parentId){
        List<SysMenu> list = new ArrayList<>();
        for (SysMenu menu : menuList) {
            if (ObjectUtil.equal(parentId, menu.getParentId())) {
                getChildNodes(menuList, menu);
                list.add(menu);
            }
        }
        return list;
    }

    private void getChildNodes(List<SysMenu> menuList, SysMenu sysMenu){
        List<SysMenu> childList = menuList.stream().filter(m -> ObjectUtil.equal(sysMenu.getId(), m.getParentId())).collect(Collectors.toList());
        for (SysMenu menu : childList) {
            if (!CollectionUtils.isEmpty(sysMenu.getChildren())) {
                getChildNodes(menuList, menu);
            }
        }
        sysMenu.setChildren(childList);
    }


}
