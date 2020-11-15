package com.leqiang222.febs.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.leqiang222.febs.system.domain.Dept;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author leqiang222
 */
public interface IDeptService extends IService<Dept> {
    IPage<Dept> findDepts();

}
