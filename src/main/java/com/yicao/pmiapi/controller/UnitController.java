package com.yicao.pmiapi.controller;


import com.yicao.pmiapi.pojo.Building;
import com.yicao.pmiapi.pojo.House;
import com.yicao.pmiapi.pojo.RespBean;
import com.yicao.pmiapi.pojo.Unit;
import com.yicao.pmiapi.service.IHouseService;
import com.yicao.pmiapi.service.IUnitService;
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
 *  单元前端控制器
 * </p>
 *
 * @author yicao
 * @since 2021-05-06
 */
@Api(tags = "单元管理")
@RestController
public class UnitController {

    @Autowired
    IUnitService unitService;

    @ApiOperation(value = "根据楼栋id获取单元列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "building_id", value = "楼栋id", required = true, paramType = "query")
    })
    @GetMapping("/units")
    public RespBean GetBuildingListByUnitId(@RequestParam("building_id") Integer buildingId){
        Map<String, Object> map = new HashMap<>();
        map.put("building", buildingId);
        List<Unit> units = unitService.listByMap(map);
        return RespBean.success(units);
    }


    @ApiOperation(value = "根据id获取单元信息")
    @GetMapping("/unit/{id:\\d+}")
    public RespBean GetUnitById(@PathVariable Integer id){
        Unit unit = unitService.getById(id);
        return RespBean.success(unit);
    }

    @ApiOperation(value = "修改单元信息")
    @PutMapping("/unit")
    public RespBean EditUnit(@RequestBody Unit unit){
        return unitService.updateById(unit)? RespBean.success(""): RespBean.error("");
    }

    @ApiOperation(value = "添加单元")
    @PostMapping("/unit")
    public RespBean AddUnit(@RequestBody Unit unit){
        return unitService.save(unit)? RespBean.success(""): RespBean.error("");
    }

    @ApiOperation(value = "根据单元id获取小区id和楼栋id")
    @GetMapping("/unit/key")
    public RespBean AddUnit(@RequestParam("unit_id") Integer unitId){
        return unitService.getKeyById(unitId);
    }
}
