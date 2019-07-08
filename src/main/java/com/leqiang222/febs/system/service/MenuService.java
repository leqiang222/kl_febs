package com.leqiang222.febs.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.leqiang222.febs.system.domain.Menu;

import java.util.List;
import java.util.Map;

/**
 * @Author LeQiang Li
 * @Date Created in 16:09 2019/7/8
 * @Description:
 * @Modified By:
 */
public interface MenuService extends IService<Menu> {
    List<Menu> findUserPermissions(String username);

    List<Menu> findUserMenus(String username);

    Map<String, Object> findMenus(Menu menu);

    List<Menu> findMenuList(Menu menu);

    void createMenu(Menu menu);

    void updateMenu(Menu menu) throws Exception;

    /**
     * 递归删除菜单/按钮
     *
     * @param menuIds menuIds
     */
    void deleteMeuns(String[] menuIds) throws Exception;
}
