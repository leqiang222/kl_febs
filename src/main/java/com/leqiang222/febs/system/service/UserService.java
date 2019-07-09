package com.leqiang222.febs.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
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
     * 注册用户
     *
     * @param username 用户名
     * @param password 密码
     */
//    void regist(String username, String password) throws Exception;
}
