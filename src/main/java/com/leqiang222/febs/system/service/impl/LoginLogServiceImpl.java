package com.leqiang222.febs.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leqiang222.febs.common.utils.AddressUtil;
import com.leqiang222.febs.common.utils.HttpContextUtil;
import com.leqiang222.febs.common.utils.IPUtil;
import com.leqiang222.febs.system.dao.LoginLogMapper;
import com.leqiang222.febs.system.domain.LoginLog;
import com.leqiang222.febs.system.service.LoginLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Author LeQiang Li
 * @Date Created in 16:41 2019/7/8
 * @Description:
 * @Modified By:
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements LoginLogService {
    @Override
    @Transactional
    public void saveLoginLog(LoginLog loginLog) {
        loginLog.setLoginTime(new Date());
        HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
        String ip = IPUtil.getIpAddr(request);
        loginLog.setIp(ip);
        loginLog.setLocation(AddressUtil.getCityInfo(ip));
        this.save(loginLog);
    }
}
