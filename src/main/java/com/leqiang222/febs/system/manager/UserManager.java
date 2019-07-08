package com.leqiang222.febs.system.manager;

import com.leqiang222.febs.common.service.CacheService;
import com.leqiang222.febs.common.utils.FebsUtil;
import com.leqiang222.febs.system.domain.Menu;
import com.leqiang222.febs.system.domain.Role;
import com.leqiang222.febs.system.domain.User;
import com.leqiang222.febs.system.domain.UserConfig;
import com.leqiang222.febs.system.service.MenuService;
import com.leqiang222.febs.system.service.RoleService;
import com.leqiang222.febs.system.service.UserConfigService;
import com.leqiang222.febs.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author LeQiang Li
 * @Date Created in 10:59 2019/7/8
 * @Description: 封装一些和 User相关的业务操作
 * @Modified By:
 */
@Service
public class UserManager {

    @Autowired
    private CacheService cacheService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private UserConfigService userConfigService;

    /**
     * 通过用户名获取用户角色集合
     *
     * @param username 用户名
     * @return 角色集合
     */
    public Set<String> getUserRoles(String username) {
        List<Role> roleList = FebsUtil.selectCacheByTemplate(
                () -> this.cacheService.getRoles(username),
                () -> this.roleService.findUserRole(username));
        return roleList.stream().map(Role::getRoleName).collect(Collectors.toSet());
    }

    /**
     * 通过用户名获取用户基本信息
     *
     * @param username 用户名
     * @return 用户基本信息
     */
    public User getUser(String username) {
        return FebsUtil.selectCacheByTemplate(
                () -> this.cacheService.getUser(username),
                () -> this.userService.findByName(username));
    }

    /**
     * 通过用户名获取用户权限集合
     *
     * @param username 用户名
     * @return 权限集合
     */
    public Set<String> getUserPermissions(String username) {
        List<Menu> permissionList = FebsUtil.selectCacheByTemplate(
                () -> this.cacheService.getPermissions(username),
                () -> this.menuService.findUserPermissions(username));
        return permissionList.stream().map(Menu::getPerms).collect(Collectors.toSet());
    }

    /**
     * 通过用户 ID获取前端系统个性化配置
     *
     * @param userId 用户 ID
     * @return 前端系统个性化配置
     */
    public UserConfig getUserConfig(String userId) {
        return FebsUtil.selectCacheByTemplate(
                () -> this.cacheService.getUserConfig(userId),
                () -> this.userConfigService.findByUserId(userId));
    }
}
