package com.leqiang222.febs.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.leqiang222.febs.system.domain.LoginLog;
import com.leqiang222.febs.system.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @Author LeQiang Li
 * @Date Created in 16:42 2019/7/8
 * @Description:
 * @Modified By:
 */
public interface LoginLogMapper extends BaseMapper<LoginLog> {
    /**
     * 获取系统总访问次数
     *
     * @return Long
     */
    Long findTotalVisitCount();

    /**
     * 获取系统今日访问次数
     *
     * @return Long
     */
    Long findTodayVisitCount();

    /**
     * 获取系统今日访问 IP数
     *
     * @return Long
     */
    Long findTodayIp();

    /**
     * 获取系统近七天来的访问记录
     *
     * @param user 用户
     * @return 系统近七天来的访问记录
     */
    List<Map<String, Object>> findLastSevenDaysVisitCount(User user);
}
