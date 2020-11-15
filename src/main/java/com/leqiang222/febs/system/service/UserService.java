package com.leqiang222.febs.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.leqiang222.febs.common.domain.QueryRequestParam;
import com.leqiang222.febs.system.domain.User;

/**
 * @Author LeQiang Li
 * @Date Created in 15:53 2019/7/8
 * @Description:
 * @Modified By:
 */
public interface UserService extends IService<User> {
    /**
     * 更新用户登录时间
     *
     * @param username username
     */
    void updateLoginTime(String username) throws Exception;

    /**
     * 通过用户名查找用户
     *
     * @param username username
     * @return user
     */
    User findByName(String username);

    /**
     * 查询用户详情，包括基本信息，用户角色，用户部门
     *
     * @param user user
     * @param queryRequestParam queryRequest
     * @return IPage
     */
    IPage<User> findUserDetail(User user, QueryRequestParam queryRequestParam);

    /**
     * 注册用户
     *
     * @param username 用户名
     * @param password 密码
     */
//    void regist(String username, String password) throws Exception;
}
