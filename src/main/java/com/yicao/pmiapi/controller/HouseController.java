package com.yicao.pmiapi.controller;


import com.yicao.pmiapi.pojo.*;
import com.yicao.pmiapi.service.IAccountService;
import com.yicao.pmiapi.service.IBuildingService;
import com.yicao.pmiapi.service.IFamilyService;
import com.yicao.pmiapi.service.IHouseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yicao
 * @since 2021-04-29
 */
@Api(tags = "住房管理")
@RestController
public class HouseController {

    @Autowired
    IHouseService houseService;
    @Autowired
    IFamilyService familyService;
    @Autowired
    IAccountService accountService;

    @ApiOperation(value = "根据单元id获取住房列表")
    @GetMapping("/houses")
    public RespBean GetBuildingListByAreaId( @RequestParam("unit_id") Integer unitId){
        Map<String, Object> map = new HashMap<>();
        map.put("unit_num", unitId);
        List<House> houses = houseService.listByMap(map);
        return RespBean.success(houses);
    }

    @ApiOperation(value = "根据住房id获取住房信息")
    @GetMapping("/house/{id:\\d+}")
    public RespBean GetBuildingById( @PathVariable Integer id){
        House house = houseService.getById(id);
        if (house.getFamilyId() != null) {
            Family family = familyService.getById(house.getFamilyId());
            house.setHouseState(house.getHouseState() + "  住户姓名：" + family.getName());
        }
        return RespBean.success(house);
    }

    @ApiOperation(value = "修改住房信息")
    @PutMapping("/house")
    public RespBean EditArea(@RequestBody House house){
        return houseService.updateById(house)? RespBean.success(""): RespBean.error("");
    }

    @ApiOperation(value = "添加住房")
    @PostMapping("/house")
    public RespBean AddHouse(@RequestBody House house){
        return houseService.save(house)? RespBean.success(""): RespBean.error("");
    }

    @ApiOperation(value = "业主获取住房列表")
    @GetMapping("/house_address")
    public RespBean getAddressList(Principal principal) {
        // 获取家庭id
        if (null == principal) {
            return null;
        }
        System.out.println(principal);
        String username = principal.getName();
        Account account = accountService.getAdminByUserName(username);
        Integer familyId = account.getFamilyId();

        // 根据家庭id获取住房列表
        List<House> houseList = houseService.getListByFamilyId(familyId);
        return RespBean.success(houseList);
    }
}
