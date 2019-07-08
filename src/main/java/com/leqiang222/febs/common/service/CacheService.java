package com.leqiang222.febs.common.service;

import com.leqiang222.febs.system.domain.Menu;
import com.leqiang222.febs.system.domain.Role;
import com.leqiang222.febs.system.domain.User;
import org.apache.catalina.startup.UserConfig;

import java.util.List;

/**
 * @Author LeQiang Li
 * @Date Created in 15:56 2019/7/8
 * @Description:
 * @Modified By:
 */
public interface CacheService {
    /**
     * 从缓存中获取用户
     *
     * @param username 用户名
     * @return User
     */
    User getUser(String username) throws Exception;

    /**
     * 从缓存中获取用户角色
     *
     * @param username 用户名
     * @return 角色集
     */
    List<Role> getRoles(String username) throws Exception;

    /**
     * 从缓存中获取用户权限
     *
     * @param username 用户名
     * @return 权限集
     */
    List<Menu> getPermissions(String username) throws Exception;

    /**
     * 从缓存中获取用户个性化配置
     *
     * @param userId 用户 ID
     * @return 个性化配置
     */
    UserConfig getUserConfig(String userId) throws Exception;

    /**
     * 缓存用户信息
     *
     * @param username 用户名
     */
    void saveUser(String username) throws Exception;
}
