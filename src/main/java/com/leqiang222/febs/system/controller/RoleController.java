package com.leqiang222.febs.system.controller;

import com.leqiang222.febs.common.controller.BaseController;
import com.leqiang222.febs.common.domain.QueryRequestParam;
import com.leqiang222.febs.system.domain.Role;
import com.leqiang222.febs.system.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author LeQiang Li
 * @Date Created in 15:07 2019/7/10
 * @Description:
 * @Modified By:
 */
@Slf4j
@Validated
@RestController
@RequestMapping("role")
public class RoleController extends BaseController {
    @Autowired
    private RoleService roleService;

    @GetMapping
    @RequiresPermissions("role:view")
    public Map<String, Object> roleList(QueryRequestParam queryRequestParam, Role role) {
        return getDataTable(roleService.findRoles(role, queryRequestParam));
    }
}
