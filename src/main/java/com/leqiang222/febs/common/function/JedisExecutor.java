package com.leqiang222.febs.common.function;

import com.leqiang222.febs.common.exception.RedisConnectException;

/**
 * @Author LeQiang Li
 * @Date Created in 19:46 2019/7/8
 * @Description:
 * @Modified By:
 */
@FunctionalInterface
public interface JedisExecutor<T, R> {
    R excute(T t) throws RedisConnectException;
}

