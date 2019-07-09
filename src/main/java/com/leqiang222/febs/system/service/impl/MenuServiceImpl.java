package com.leqiang222.febs.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leqiang222.febs.system.dao.MenuMapper;
import com.leqiang222.febs.system.domain.Menu;
import com.leqiang222.febs.system.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author LeQiang Li
 * @Date Created in 16:45 2019/7/8
 * @Description:
 * @Modified By:
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Override
    public List<Menu> findUserPermissions(String username) {
        return null;
    }

    @Override
    public List<Menu> findUserMenus(String username) {
        return this.baseMapper.findUserMenus(username);
    }

    @Override
    public Map<String, Object> findMenus(Menu menu) {
        return null;
    }

    @Override
    public List<Menu> findMenuList(Menu menu) {
        return null;
    }

    @Override
    public void createMenu(Menu menu) {

    }

    @Override
    public void updateMenu(Menu menu) throws Exception {

    }

    @Override
    public void deleteMeuns(String[] menuIds) throws Exception {

    }
}
