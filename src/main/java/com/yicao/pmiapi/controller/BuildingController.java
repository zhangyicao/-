package com.yicao.pmiapi.controller;


import com.yicao.pmiapi.pojo.Building;
import com.yicao.pmiapi.pojo.RespBean;
import com.yicao.pmiapi.service.IBuildingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yicao
 * @since 2021-05-06
 */
@Api(tags = "楼栋管理")
@RestController
public class BuildingController {

    @Autowired
    IBuildingService buildingService;

    @ApiOperation(value = "根据小区id获取楼栋列表")
    @GetMapping("/buildings")
    public RespBean GetBuildingListByAreaId(@RequestParam("area_id") Integer areaId){
        Map<String, Object> map = new HashMap<>();
        map.put("area", areaId);
        List<Building> buildings = buildingService.listByMap(map);
        return RespBean.success(buildings);
    }

    @ApiOperation(value = "根据楼栋id获取楼栋信息")
    @GetMapping("/building/{id:\\d+}")
    public RespBean GetBuildingById(@PathVariable Integer id){
        Building building = buildingService.getById(id);
        return RespBean.success(building);
    }


    @ApiOperation(value = "修改楼栋信息")
    @PutMapping("/building")
    public RespBean EditArea(@RequestBody Building building){
        return buildingService.updateById(building)? RespBean.success(""): RespBean.error("");
    }

    @ApiOperation(value = "添加楼栋")
    @PostMapping("/building")
    public RespBean AddBuilding(@RequestBody Building building){
        return buildingService.save(building)? RespBean.success(""): RespBean.error("");
    }


}
