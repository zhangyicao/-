package com.yicao.pmiapi;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yicao.pmiapi.mapper.RepairMapper;
import com.yicao.pmiapi.pojo.Area;
import com.yicao.pmiapi.pojo.Building;
import com.yicao.pmiapi.pojo.Repair;
import com.yicao.pmiapi.service.IAreaService;
import com.yicao.pmiapi.service.IBuildingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.parameters.P;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 小区测试类
 *
 * @author: yicao
 * @create: 2021-05-06 22:14
 */
@SpringBootTest
public class TestBuilding {

    @Autowired
    IBuildingService buildingService;
    @Autowired
    RepairMapper repairMapper;

    @Test
    public void test01(){
        Repair repair = repairMapper.getById(1);
        System.out.println(repair);
    }

    @Test
    public void test02(){
        Page<Repair> page = new Page<>(1, 5);
        repairMapper.getList(page, 3);
        System.out.println(page.getRecords());
    }

}
