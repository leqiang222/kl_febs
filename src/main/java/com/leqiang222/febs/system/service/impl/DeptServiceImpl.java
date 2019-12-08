package com.leqiang222.febs.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leqiang222.febs.common.domain.QueryRequest;
import com.leqiang222.febs.common.utils.SortUtil;
import com.leqiang222.febs.system.domain.Dept;
import com.leqiang222.febs.system.dao.DeptMapper;
import com.leqiang222.febs.system.domain.Role;
import com.leqiang222.febs.system.service.IDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author leqiang222
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {
    @Autowired
    DeptMapper deptMapper;

    @Override
    public IPage<Dept> findDepts() {
        LambdaQueryWrapper<Dept> queryWrapper = new LambdaQueryWrapper<>();

        IPage<Dept> page = new Page<>();

        return deptMapper.selectPage(page, queryWrapper);
    }
}
