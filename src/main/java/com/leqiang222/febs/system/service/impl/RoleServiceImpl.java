package com.leqiang222.febs.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leqiang222.febs.system.dao.RoleMapper;
import com.leqiang222.febs.system.domain.Role;
import com.leqiang222.febs.system.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author LeQiang Li
 * @Date Created in 16:47 2019/7/8
 * @Description:
 * @Modified By:
 */
@Slf4j
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Override
    public List<Role> findUserRole(String userName) {
        return baseMapper.findUserRole(userName);
    }
}
