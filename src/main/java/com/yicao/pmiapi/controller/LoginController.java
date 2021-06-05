package com.yicao.pmiapi.controller;

import com.yicao.pmiapi.pojo.Account;
import com.yicao.pmiapi.pojo.AccountLoginParams;
import com.yicao.pmiapi.pojo.RespBean;
import com.yicao.pmiapi.service.IAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * 登录控制器
 *
 * @author: yicao
 * @create: 2021-04-25 15:41
 */
@Api(tags = "登录")
@RestController
public class LoginController {
    @Autowired
    private IAccountService accountService;

    @ApiOperation(value = "登录之后返回token")
    @PostMapping("/login")
    public RespBean login(@RequestBody AccountLoginParams adminLoginParam, HttpServletRequest request) {
        return accountService.login(adminLoginParam.getUsername(), adminLoginParam.getPassword(), null, request);
    }

    @ApiOperation(value = "获取当前登录用户信息")
    @GetMapping("/account/info")
    public RespBean getAdminInfo(Principal principal) {
        if (null == principal) {
            return null;
        }
        System.out.println(principal);
        String username = principal.getName();
        Account account = accountService.getAdminByUserName(username);
        account.setPassword(null);
        return RespBean.success(account);
    }

    @ApiOperation(value = "退出登录")
    @GetMapping("/loginout")
    public RespBean logout(Principal principal) {
        System.out.println(principal);
        int res = accountService.logout(principal.getName());
        return RespBean.success("注销成功！");
    }
}
