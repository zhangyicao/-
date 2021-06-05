package com.yicao.pmiapi.utils;

import com.yicao.pmiapi.pojo.Account;
import com.yicao.pmiapi.service.IAccountService;
import com.yicao.pmiapi.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.Principal;

/**
 * 工具类
 *
 * @author: yicao
 * @create: 2021-05-15 10:31
 */
@Component
public class Util {

    @Autowired
    private IAccountService accountService;

    /**
     * 根据登录信息获取家庭id
     * @param principal
     * @return
     */
    public Integer getFamilyId(Principal principal) {
        if (null == principal) {
            return null;
        }
        System.out.println(principal);
        String username = principal.getName();
        System.out.println(username);
        Account account = accountService.getAdminByUserName(username);
        Integer familyId = account.getFamilyId();
        return familyId;
    }
}
