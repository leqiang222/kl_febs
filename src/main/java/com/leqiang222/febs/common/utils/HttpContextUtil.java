package com.leqiang222.febs.common.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @Author LeQiang Li
 * @Date Created in 16:19 2019/7/8
 * @Description:
 * @Modified By:
 */
public class HttpContextUtil {
    private HttpContextUtil(){

    }
    public static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }
}
