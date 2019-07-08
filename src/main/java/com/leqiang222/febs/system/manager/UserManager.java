package com.leqiang222.febs.system.manager;

import com.leqiang222.febs.common.utils.FebsUtil;
import com.leqiang222.febs.system.domain.Role;
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

}
