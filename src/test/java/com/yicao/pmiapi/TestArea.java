package com.yicao.pmiapi;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yicao.pmiapi.mapper.AccountMapper;
import com.yicao.pmiapi.pojo.Account;
import com.yicao.pmiapi.pojo.Area;
import com.yicao.pmiapi.service.IAreaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * 小区测试类
 *
 * @author: yicao
 * @create: 2021-05-06 22:14
 */
@SpringBootTest
public class TestArea {

    @Autowired
    AccountMapper accountMapper;

    private String username = "admin";

    @Test
    public void test01(){
        QueryWrapper<Account> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        Account account = accountMapper.selectOne(wrapper);
        System.out.println(account);
    }

    @Test
    public void test02(){
        Map<String, Object> map = accountMapper.getTypeByUsername(this.username);
        System.out.println(map);
        Integer type = (Integer) map.get("type");
        Account account = null;
        if (type == 0) {
            account = accountMapper.getAccountByUserName(username);
        } else if (type == 1) {
            account = accountMapper.getFamilyAccountByUsername(username);
        }
        System.out.println(account);
    }

}
