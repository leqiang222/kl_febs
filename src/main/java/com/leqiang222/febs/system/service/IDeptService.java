package com.leqiang222.febs.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.leqiang222.febs.common.domain.QueryRequest;
import com.leqiang222.febs.system.domain.Dept;
import com.baomidou.mybatisplus.extension.service.IService;
import com.leqiang222.febs.system.domain.Role;

/**
 * @author leqiang222
 */
public interface IDeptService extends IService<Dept> {
    IPage<Dept> findDepts();

}
