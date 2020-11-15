package com.leqiang222.febs.common.handler;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.leqiang222.febs.common.domain.FebsResponse;
import com.leqiang222.febs.common.exception.FebsException;
import com.leqiang222.febs.common.exception.LimitAccessException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.javassist.NotFoundException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.List;
import java.util.Set;

/**
 * @Author LeQiang Li
 * @Date Created in 13:54 2019/7/11
 * @Description: 全局异常拦截器（捕获controller抛出的异常）
 * @Modified By:
 */
@Slf4j
@RestControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

    /*
     * http500 服务器异常，系统抛出的异常
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public FebsResponse handleException(Exception e) {
        log.error("系统内部异常，异常信息：", e);
        return new FebsResponse().message("系统内部异常");
    }

    /*
     * http500 服务器异常，自己抛出的异常
     */
    @ExceptionHandler(value = FebsException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public FebsResponse handleParamsInvalidException(FebsException e) {
        log.error("系统错误：{}", e.getMessage());
        return new FebsResponse().message(e.getMessage());
    }

    /*
     * http429 请求次数太多
     */
    @ExceptionHandler(value = LimitAccessException.class)
    @ResponseStatus(HttpStatus.TOO_MANY_REQUESTS)
    public FebsResponse handleLimitAccessException(LimitAccessException e) {
        log.warn(e.getMessage());
        return new FebsResponse().message(e.getMessage());
    }

    /*
     * http404
     */
    @ExceptionHandler(value = NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public FebsResponse handleNotFoundException(NotFoundException e) {
        String message = "请求资源不存在，请检查路径是否正确或是否已发布该资源";
        log.error("message");
        return new FebsResponse().message(message);
    }

    /*
     * http403 权限不足
     */
    @ExceptionHandler(value = UnauthorizedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void handleUnauthorizedException(Exception e) {
        log.error("该功能无访问权限，{}", e.getMessage());
    }

    /**
     * http400 无效的请求
     * 统一处理请求参数校验(实体对象传参)
     *
     * @param e BindException
     * @return FebsResponse
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public FebsResponse validExceptionHandler(BindException e) {
        StringBuilder message = new StringBuilder();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        for (FieldError error : fieldErrors) {
            message.append(error.getField()).append(error.getDefaultMessage()).append(StringPool.COMMA);
        }
        message = new StringBuilder(message.substring(0, message.length() - 1));
        return new FebsResponse().message(message.toString());
    }

    /**
     * http400 无效的请求
     * 统一处理请求参数校验(普通传参)
     *
     * @param e ConstraintViolationException
     * @return FebsResponse
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public FebsResponse handleConstraintViolationException(ConstraintViolationException e) {
        StringBuilder message = new StringBuilder();
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        for (ConstraintViolation<?> violation : violations) {
            Path path = violation.getPropertyPath();
            String[] pathArr = StringUtils.splitByWholeSeparatorPreserveAllTokens(path.toString(), StringPool.DOT);
            message.append(pathArr[1]).append(violation.getMessage()).append(StringPool.COMMA);
        }
        message = new StringBuilder(message.substring(0, message.length() - 1));
        return new FebsResponse().message(message.toString());
    }



}
