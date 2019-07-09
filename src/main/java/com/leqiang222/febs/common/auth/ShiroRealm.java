package com.leqiang222.febs.common.auth;

import com.leqiang222.febs.common.domain.FebsConstant;
import com.leqiang222.febs.common.service.RedisService;
import com.leqiang222.febs.common.utils.FebsUtil;
import com.leqiang222.febs.common.utils.HttpContextUtil;
import com.leqiang222.febs.common.utils.IPUtil;
import com.leqiang222.febs.system.domain.User;
import com.leqiang222.febs.system.manager.UserManager;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/**
 * @Author LeQiang Li
 * @Date Created in 10:54 2019/7/8
 * @Description: 自定义实现 ShiroRealm，包含认证和授权两大模块
 * @Modified By:
 */
public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    private UserManager userManager;
    @Autowired
    private RedisService redisService;

    /**
     * 授权模块，获取用户角色和权限
     *
     * @param principalCollection token
     * @return AuthorizationInfo 权限信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 根据token获取username
        String username = JWTUtil.getUsername(principalCollection.toString());

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        // 获取用户角色集
        Set<String> roleSet = userManager.getUserRoles(username);
        simpleAuthorizationInfo.setRoles(roleSet);

        // 获取用户权限集
        Set<String> permissionSet = userManager.getUserPermissions(username);
        simpleAuthorizationInfo.setStringPermissions(permissionSet);
        return simpleAuthorizationInfo;
    }

    /**
     * 用户认证
     *
     * @param authenticationToken 身份认证 token
     * @return AuthenticationInfo 身份认证信息
     * @throws AuthenticationException 认证相关异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 1.1 这里的 token是从 JWTFilter 的 executeLogin 方法传递过来的，已经经过了解密
        String token = (String) authenticationToken.getCredentials();

        // 1.2 从 redis里获取这个 token
        HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
        String ip = IPUtil.getIpAddr(request);

        // 1.3 对请求过来的token和存储在redis的token做对比
        String encryptToken = FebsUtil.encryptToken(token);
        String encryptTokenInRedis = null;

        try {
            encryptTokenInRedis = redisService.get(FebsConstant.TOKEN_CACHE_PREFIX + encryptToken + "." + ip);
        } catch (Exception ignore) {
        }

        // 如果找不到，说明已经失效
        if (StringUtils.isBlank(encryptTokenInRedis)) {
            throw new AuthenticationException("token已经过期");
        }

        String username = JWTUtil.getUsername(token);

        if (StringUtils.isBlank(username)) {
            throw new AuthenticationException("token校验不通过");
        }

        // 通过用户名查询用户信息
        User user = userManager.getUser(username);

        if (user == null) {
            throw new AuthenticationException("用户名或密码错误");
        }
        if (!JWTUtil.verify(token, username, user.getPassword())) {
            throw new AuthenticationException("token校验不通过");
        }
        return new SimpleAuthenticationInfo(token, token, "febs_shiro_realm");
    }
}
