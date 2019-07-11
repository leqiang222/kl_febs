package com.leqiang222.febs.common.auth;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.leqiang222.febs.common.properties.FebsProperties;
import com.leqiang222.febs.common.utils.FebsUtil;
import com.leqiang222.febs.common.utils.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.springframework.util.AntPathMatcher;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author LeQiang Li
 * @Date Created in 10:02 2019/7/8
 * @Description: 拦截器
 * @Modified By:
 */
@Slf4j
public class JWTFilter extends BasicHttpAuthenticationFilter {

    private static final String TOKEN = "Authentication";
    private AntPathMatcher pathMatcher = new AntPathMatcher();

    /*
     * 是否允许访问
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws UnauthorizedException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        // 获取后端免认证接口数组
        FebsProperties febsProperties = SpringContextUtil.getBean(FebsProperties.class);
        String[] anonUrl = StringUtils.splitByWholeSeparatorPreserveAllTokens(febsProperties.getShiro().getAnonUrl(), StringPool.COMMA);

        // 请求的url是否和数组某个元素匹配
        for (String u : anonUrl) {
            boolean isMatch = pathMatcher.match(u, httpServletRequest.getRequestURI());
            if (isMatch) {
               return true;
            }
        }

        // 请求头是否有token
        if (isLoginAttempt(request, response)) {
            String method = ((HttpServletRequest) request).getMethod();
            return executeLogin(request, response);
        }
        return false;
    }

    /*
     * 请求头是否有token来判断是否需要重新登录
     */
    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;

        String token = req.getHeader(TOKEN);
        return token != null;
    }

    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String token = httpServletRequest.getHeader(TOKEN);
        JWTToken jwtToken = new JWTToken(FebsUtil.decryptToken(token));
        try {
            getSubject(request, response).login(jwtToken);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }
}
