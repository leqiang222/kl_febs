package com.leqiang222.febs.common.task;

import com.leqiang222.febs.common.domain.FebsConstant;
import com.leqiang222.febs.common.service.RedisService;
import com.leqiang222.febs.common.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Author LeQiang Li
 * @Date Created in 15:26 2019/7/11
 * @Description: 主要用于定时删除 Redis中 key为 febs.user.active 中已经过期的 score
 * @Modified By:
 */
@Slf4j
@Component
public class CacheTask {
    @Autowired
    private RedisService redisService;

    @Scheduled(fixedRate = 3600000) // 上一次开始执行时间点之后3600秒后再执行
    public void run() {
        try {
            String now = DateUtil.formatFullTime(LocalDateTime.now());
            redisService.zremrangeByScore(FebsConstant.ACTIVE_USERS_ZSET_PREFIX, "-inf", now);
            log.info("delete expired user");
        } catch (Exception ignore) {
        }
    }
}
