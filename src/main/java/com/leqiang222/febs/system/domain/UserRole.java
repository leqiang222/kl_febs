package com.leqiang222.febs.system.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.leqiang222.febs.common.domain.BaseDomain;
import lombok.Data;

/**
 * @Author LeQiang Li
 * @Date Created in 19:53 2019/7/8
 * @Description:
 * @Modified By:
 */
@TableName("t_user_role")
@Data
public class UserRole extends BaseDomain {
    private static final long serialVersionUID = -3166012934498268403L;

    private Long userId;

    private Long roleId;
}
