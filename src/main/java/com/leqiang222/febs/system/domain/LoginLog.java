package com.leqiang222.febs.system.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @Author LeQiang Li
 * @Date Created in 16:00 2019/7/8
 * @Description:
 * @Modified By:
 */
@TableName("t_login_log")
@Data
public class LoginLog {
    /**
     * 用户 ID
     */
    private String username;

    /**
     * 登录时间
     */
    private Date loginTime;

    /**
     * 登录地点
     */
    private String location;

    private String ip;
}
