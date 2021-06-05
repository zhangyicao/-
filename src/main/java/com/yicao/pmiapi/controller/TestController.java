package com.yicao.pmiapi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yicao.pmiapi.mapper.AccountMapper;
import com.yicao.pmiapi.pojo.Account;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * 测试
 *
 * @author: yicao
 * @create: 2021-04-26 15:03
 */
@RestController
@Api(tags = "测试")
public class TestController {


    @GetMapping("/test01")
    public void test01(Principal principal){
        System.out.println("principal:" + principal);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("authentication:" + authentication);

        System.out.println("getPrincipal:" + authentication.getPrincipal());
        System.out.println("getDetails:" + authentication.getDetails());
    }


}
