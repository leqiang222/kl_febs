package com.leqiang222.febs.system.controller;

import com.leqiang222.febs.common.controller.BaseController;
import com.leqiang222.febs.common.domain.FebsResponse;
import com.leqiang222.febs.common.domain.QueryRequest;
import com.leqiang222.febs.system.domain.User;
import com.leqiang222.febs.system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author LeQiang Li
 * @Date Created in 11:30 2019/7/10
 * @Description:
 * @Modified By:
 */
@Slf4j
@Validated
@RestController
@RequestMapping("user")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @GetMapping
    @RequiresPermissions("user:view")
    public Map<String, Object> userList(QueryRequest queryRequest, User user) {
        return getDataTable(userService.findUserDetail(user, queryRequest));
    }

    @PutMapping("profile")
    public FebsResponse saveProfile(QueryRequest queryRequest, User user) {
        boolean result =  userService.updateById(user);

        String message = result? "修改成功": "修改失败";
        return new FebsResponse().message(message).data(null);
    }
}
