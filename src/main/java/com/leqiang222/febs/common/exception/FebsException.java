package com.leqiang222.febs.common.exception;

/**
 * @Author LeQiang Li
 * @Date Created in 15:51 2019/7/8
 * @Description: FEBS 系统内部异常
 * @Modified By:
 */
public class FebsException extends Exception {
    private static final long serialVersionUID = -994962710559017255L;

    public FebsException(String message) {
        super(message);
    }
}
