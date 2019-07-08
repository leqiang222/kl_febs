package com.leqiang222.febs.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.leqiang222.febs.system.domain.Role;

import java.util.List;

/**
 * @Author LeQiang Li
 * @Date Created in 16:48 2019/7/8
 * @Description:
 * @Modified By:
 */
public interface RoleMapper extends BaseMapper<Role> {
    List<Role> findUserRole(String userName);
}
