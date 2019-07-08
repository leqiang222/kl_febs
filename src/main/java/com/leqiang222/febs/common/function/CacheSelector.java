package com.leqiang222.febs.common.function;

/**
 * @Author LeQiang Li
 * @Date Created in 15:42 2019/7/8
 * @Description:
 * @Modified By:
 */
@FunctionalInterface
public interface CacheSelector<T> {
    T select() throws Exception;
}
