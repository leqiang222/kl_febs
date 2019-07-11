package com.leqiang222.febs.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leqiang222.febs.common.domain.FebsConstant;
import com.leqiang222.febs.common.domain.QueryRequest;
import com.leqiang222.febs.common.service.CacheService;
import com.leqiang222.febs.common.utils.MD5Util;
import com.leqiang222.febs.common.utils.SortUtil;
import com.leqiang222.febs.system.dao.UserMapper;
import com.leqiang222.febs.system.domain.User;
import com.leqiang222.febs.system.domain.UserRole;
import com.leqiang222.febs.system.manager.UserManager;
import com.leqiang222.febs.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Author LeQiang Li
 * @Date Created in 16:30 2019/7/8
 * @Description:
 * @Modified By:
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserManager userManager;
    @Autowired
    private CacheService cacheService;

    @Override
    public User findByName(String username) {
        LambdaQueryWrapper wrapper = new LambdaQueryWrapper<User>().eq(User::getUsername, username);
        return baseMapper.selectOne(wrapper);
    }

    @Override
    public IPage<User> findUserDetail(User user, QueryRequest queryRequest) {
        //
        Page<User> page = new Page<>();

        // 给page赋一些排序的值
        SortUtil.handlePageSort(queryRequest, page, "userId", FebsConstant.ORDER_ASC, false);

        //
        return this.baseMapper.findUserDetail(page, user);
    }

    @Override
    public void updateLoginTime(String username) throws Exception {
        User user = new User();
        user.setLastLoginTime(new Date());

        LambdaQueryWrapper wrapper = new LambdaQueryWrapper<User>().eq(User::getUsername, username);
        this.baseMapper.update(user, wrapper);

        // 重新将用户信息加载到 redis中
        cacheService.saveUser(username);

    }
}
