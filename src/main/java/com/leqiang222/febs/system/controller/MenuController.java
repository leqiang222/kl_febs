package com.leqiang222.febs.system.controller;

import com.leqiang222.febs.common.domain.router.VueRouter;
import com.leqiang222.febs.system.domain.Menu;
import com.leqiang222.febs.system.manager.UserManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;

/**
 * @Author LeQiang Li
 * @Date Created in 15:44 2019/7/9
 * @Description:
 * @Modified By:
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private UserManager userManager;

    @GetMapping("/{username}")
    public ArrayList<VueRouter<Menu>> getUserRouters(@NotBlank(message = "{required}") @PathVariable String username) {
        return this.userManager.getUserRouters(username);
    }

}
