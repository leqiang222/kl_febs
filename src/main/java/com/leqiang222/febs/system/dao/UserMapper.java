package com.leqiang222.febs.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leqiang222.febs.system.domain.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Author LeQiang Li
 * @Date Created in 16:31 2019/7/8
 * @Description:
 * @Modified By:
 */
public interface UserMapper extends BaseMapper<User> {
    IPage<User> findUserDetail(Page page, @Param("user") User user);

    /**
     * 获取单个用户详情
     *
     * @param username 用户名
     * @return 用户信息
     */
    User findDetail(String username);
}
