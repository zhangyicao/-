package com.yicao.pmiapi.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yicao.pmiapi.pojo.Account;
import com.yicao.pmiapi.pojo.Area;
import com.yicao.pmiapi.pojo.RespBean;
import com.yicao.pmiapi.pojo.VO.AccountAdd;
import com.yicao.pmiapi.service.IAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author yicao
 * @since 2021-04-25
 */
@Api(tags = "账户管理")
@RestController
public class AccountController {

    @Autowired
    private IAccountService accountService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @ApiOperation(value = "添加管理员账户")
    @PostMapping("/account")
    public RespBean addAdminAccount(@RequestBody AccountAdd account) {
        return accountService.addAccount(account) ? RespBean.success("") : RespBean.error("");
    }

    @ApiOperation("获取家庭账户信息")
    @GetMapping("/account/worker/{id:\\d+}")
    public RespBean getAdminAccount(@PathVariable Integer id) {
        String username = accountService.getAdminUsernameByWorkerId(id);
        return username != null ? RespBean.success(username) : RespBean.error("");
    }

    @ApiOperation("获取管理员账户信息")
    @GetMapping("/account/family/{id:\\d+}")
    public RespBean getFamilyAccount(@PathVariable Integer id) {
        String username = accountService.getFamilyUsernameByWorkerId(id);
        return username != null ? RespBean.success(username) : RespBean.error("");
    }

    @ApiOperation("修改账户密码")
    @PutMapping("/account")
    public RespBean editPassword(@RequestBody Account account) {
        QueryWrapper<Account> wrapper = new QueryWrapper<>();
        wrapper.eq("username", account.getUsername());

        account.setPassword(passwordEncoder.encode(account.getPassword()));
        boolean update = accountService.update(account, wrapper);
        return update ? RespBean.success("") : RespBean.error("");
    }



}
