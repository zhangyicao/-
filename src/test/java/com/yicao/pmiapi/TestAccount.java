package com.yicao.pmiapi;

import com.yicao.pmiapi.mapper.AccountMapper;
import com.yicao.pmiapi.pojo.Account;
import com.yicao.pmiapi.pojo.VO.AccountAdd;
import com.yicao.pmiapi.service.IAccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 测试
 *
 * @author: yicao
 * @create: 2021-05-18 18:33
 */
@SpringBootTest
public class TestAccount {

    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IAccountService accountService;

    @Test
    public void test01(){
        Account account = new Account();
        account.setUsername("zhangsan");
        account.setPassword(passwordEncoder.encode("123456"));
        int insert = accountMapper.insert(account);
        System.out.println(account);
        System.out.println(insert);
    }

    @Test
    public void test021(){
        AccountAdd accountAdd = new AccountAdd();
        Account account = new Account();
        account.setUsername("zhangsan123");
        account.setPassword(passwordEncoder.encode("123456"));
        accountAdd.setAccount(account);
        accountAdd.setType(0);
        accountAdd.setId(5);
        accountService.addAccount(accountAdd);
    }
}
