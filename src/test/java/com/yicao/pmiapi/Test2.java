package com.yicao.pmiapi;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yicao.pmiapi.mapper.AccountMapper;
import com.yicao.pmiapi.mapper.ComplaintMapper;
import com.yicao.pmiapi.mapper.UnitMapper;
import com.yicao.pmiapi.pojo.Account;
import com.yicao.pmiapi.pojo.Complaint;
import com.yicao.pmiapi.pojo.ComplaintImg;
import com.yicao.pmiapi.pojo.Family;
import com.yicao.pmiapi.service.IComplaintService;
import com.yicao.pmiapi.service.IFamilyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 测试2
 *
 * @author: yicao
 * @create: 2021-04-25 16:21
 */
@SpringBootTest
public class Test2 {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AccountMapper accountMapper;
    @Autowired
    UnitMapper unitMapper;
    @Autowired
    IFamilyService familyService;
    @Autowired
    ComplaintMapper complaintMapper;
    @Autowired
    IComplaintService complaintService;

    @Test
    public void test1() {
        System.out.println(passwordEncoder.encode("123456"));
        System.out.println(passwordEncoder.encode("123456"));
        System.out.println(passwordEncoder.encode("123456"));
    }

    @Test
    public void test2() {
        Account account = accountMapper.getAccountByUserName("admin");
        System.out.println(account);
    }

    @Test
    public void test3() {
        Account account = new Account();
        LocalDateTime ldt = new Date().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        account.setLastLogin(ldt);
        int i = accountMapper.update(account, new QueryWrapper<Account>().eq("username", "admin"));
        System.out.println(i);
    }

    @Test
    public void test04(){
        Map<String, Integer> keyById = unitMapper.getKeyById(1);
        System.out.println(keyById);
    }

    @Test
    public void test05(){
        IPage<Map<String, Object>> familyIPage = familyService.pageMaps(new Page<>(2, 2));
        System.out.println(familyIPage);
        List<Map<String, Object>> records = familyIPage.getRecords();
        System.out.println(records);
        System.out.println(familyIPage.getPages());
        System.out.println(familyIPage.getSize());
        System.out.println(familyIPage.getTotal());
    }

    @Test
    public void test06(){
        Complaint complaint = new Complaint();
        complaint.setFamilyId(3);
        complaint.setBody("单元门口很脏");
        complaint.setHouseId(2);
        complaint.setDate(LocalDateTime.now());

        System.out.println(complaint.getId());
        Integer integer = complaintMapper.addComplaint(complaint);
        System.out.println(complaint.getId());
        System.out.println(integer);
    }

    @Test
    public void test07(){
        Complaint complaint = new Complaint();
        complaint.setFamilyId(3);
        complaint.setBody("单元门口很脏");
        complaint.setHouseId(2);
        complaint.setDate(LocalDateTime.now());
        List<ComplaintImg> complaintImgs = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ComplaintImg complaintImg = new ComplaintImg();
            complaintImg.setImgUrl("http://127.0.0.1:8081/images/78f818b612264e83a88bd9daa2ffe79d.jpg");
            complaintImgs.add(complaintImg);
        }
        complaint.setComplaintImgs(complaintImgs);
        boolean b = complaintService.addComplaint(complaint);
        System.out.println(complaint);
        System.out.println(b);
    }

}
