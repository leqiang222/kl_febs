package com.leqiang222.febs.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.leqiang222.febs.system.domain.LoginLog;

/**
 * @Author LeQiang Li
 * @Date Created in 16:01 2019/7/8
 * @Description:
 * @Modified By:
 */
public interface LoginLogService extends IService<LoginLog> {
    void saveLoginLog (LoginLog loginLog);
}
