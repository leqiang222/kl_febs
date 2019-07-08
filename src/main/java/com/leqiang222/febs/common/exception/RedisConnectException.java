package com.leqiang222.febs.common.exception;

/**
 * @Author LeQiang Li
 * @Date Created in 16:04 2019/7/8
 * @Description: Redis 连接异常类
 * @Modified By:
 */
public class RedisConnectException extends Exception {
    private static final long serialVersionUID = 1639374111871115063L;

    public RedisConnectException(String message) {
        super(message);
    }
}
