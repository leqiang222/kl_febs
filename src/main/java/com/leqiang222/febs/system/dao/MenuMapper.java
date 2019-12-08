package com.leqiang222.febs.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.leqiang222.febs.system.domain.Menu;

import java.util.List;

/**
 * @Author LeQiang Li
 * @Date Created in 16:45 2019/7/8
 * @Description:
 * @Modified By:
 */
public interface MenuMapper extends BaseMapper<Menu> {
    List<Menu> findUserPermissions(String userName);

    List<Menu> findUserMenus(String userName);

    /**
     * 查找当前菜单/按钮关联的用户 ID
     *
     * @param menuId menuId
     * @return 用户 ID集合
     */
    List<String> findUserIdsByMenuId(String menuId);

    /**
     * 递归删除菜单/按钮
     *
     * @param menuId menuId
     */
    void deleteMenus(String menuId);
}
