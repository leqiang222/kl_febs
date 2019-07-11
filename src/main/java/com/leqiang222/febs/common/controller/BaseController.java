package com.leqiang222.febs.common.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author LeQiang Li
 * @Date Created in 11:40 2019/7/10
 * @Description:
 * @Modified By:
 */
public class BaseController {
    protected Map<String, Object> getDataTable(IPage<?> pageInfo) {
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", pageInfo.getRecords());
        rspData.put("total", pageInfo.getTotal());
        return rspData;
    }
}
