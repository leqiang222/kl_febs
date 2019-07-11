package com.leqiang222.febs.common.exception;

/**
 * @Author LeQiang Li
 * @Date Created in 13:59 2019/7/11
 * @Description: 限制访问异常类
 * @Modified By:
 */
public class LimitAccessException extends Exception {
    private static final long serialVersionUID = -3608667856397125671L;

    public LimitAccessException(String message) {
        super(message);
    }
}
