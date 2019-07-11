package com.leqiang222.febs.common.runner;

import com.leqiang222.febs.common.exception.RedisConnectException;
import com.leqiang222.febs.common.service.CacheService;
import com.leqiang222.febs.system.domain.User;
import com.leqiang222.febs.system.manager.UserManager;
import com.leqiang222.febs.system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author LeQiang Li
 * @Date Created in 15:12 2019/7/11
 * @Description: 缓存初始化
 *                  ApplicationRunner的执行时机为容器启动完成的时候。
 * @Modified By:
 */
@Slf4j
@Component
//public class CacheInitRunner implements ApplicationRunner {
public class CacheInitRunner {
    @Autowired
    private UserService userService;

    @Autowired
    private CacheService cacheService;
    @Autowired
    private UserManager userManager;

    @Autowired
    private ConfigurableApplicationContext context;


//    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            log.info("Redis连接中 ······");
            cacheService.testConnect();

            log.info("缓存初始化 ······");
            log.info("缓存用户数据 ······");
            List<User> list = this.userService.list();
            for (User user : list) {
                userManager.loadUserRedisCache(user);
            }
        } catch (Exception e) {
            log.error("缓存初始化失败，{}", e.getMessage());
            log.error(" ____   __    _   _ ");
            log.error("| |_   / /\\  | | | |");
            log.error("|_|   /_/--\\ |_| |_|__");
            log.error("                        ");
            log.error("FEBS启动失败              ");
            if (e instanceof RedisConnectException) {
                log.error("Redis连接异常，请检查Redis连接配置并确保Redis服务已启动");
            }
            // 关闭 FEBS
            context.close();
        }
    }
}
