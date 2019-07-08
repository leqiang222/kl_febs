package com.leqiang222.febs.common.properties;

import lombok.Data;

/**
 * @Author LeQiang Li
 * @Date Created in 10:08 2019/7/8
 * @Description:
 * @Modified By:
 */
@Data
public class ShiroProperties {

    private String anonUrl;

    /**
     * 单位秒 token默认有效时间 1天
     */
    private Long jwtTimeOut = 86400L;

    public String getAnonUrl() {
        return anonUrl;
    }

    public void setAnonUrl(String anonUrl) {
        this.anonUrl = anonUrl;
    }

    public Long getJwtTimeOut() {
        return jwtTimeOut;
    }

    public void setJwtTimeOut(Long jwtTimeOut) {
        this.jwtTimeOut = jwtTimeOut;
    }
}
