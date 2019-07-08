package com.leqiang222.febs.common.auth;

import lombok.Data;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * @Author LeQiang Li
 * @Date Created in 10:15 2019/7/8
 * @Description:
 * @Modified By:
 */
@Data
public class JWTToken implements AuthenticationToken {
    private static final long serialVersionUID = 1282057025599826155L;

    private String token;

    private String exipreAt;

    public JWTToken(String token) {
        this.token = token;
    }

    public JWTToken(String token, String exipreAt) {
        this.token = token;
        this.exipreAt = exipreAt;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
