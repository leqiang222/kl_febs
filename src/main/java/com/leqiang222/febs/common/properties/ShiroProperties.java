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
     * token默认有效时间 1天
     */
    private Long jwtTimeOut = 86400L;
}
