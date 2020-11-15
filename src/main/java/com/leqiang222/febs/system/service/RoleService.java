package com.leqiang222.febs.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.leqiang222.febs.common.domain.QueryRequestParam;
import com.leqiang222.febs.system.domain.Role;

import java.util.List;

/**
 * @Author LeQiang Li
 * @Date Created in 15:59 2019/7/8
 * @Description:
 * @Modified By:
 */
public interface RoleService extends IService<Role> {
    List<Role> findUserRole(String userName);


    IPage<Role> findRoles(Role role, QueryRequestParam request);
}
