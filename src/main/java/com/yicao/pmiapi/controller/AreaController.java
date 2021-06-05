package com.yicao.pmiapi.controller;


import com.yicao.pmiapi.pojo.Area;
import com.yicao.pmiapi.pojo.RespBean;
import com.yicao.pmiapi.service.IAreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yicao
 * @since 2021-04-29
 */
@Api(tags = "小区管理")
@RestController
public class AreaController {

    @Autowired
    IAreaService areaService;

    @ApiOperation(value = "查询小区列表")
    @GetMapping("/areas")
    public RespBean GetAreaList(){
        List<Area> areas = areaService.list();
        return RespBean.success(areas);
    }

    @ApiOperation(value = "根据id获取小区信息")
    @GetMapping("/area/{id:\\d+}")
    public RespBean GetAreaById(@PathVariable Integer id){
        Area area = areaService.getById(id);
        return RespBean.success(area);
    }

    @ApiOperation(value = "修改小区信息")
    @PutMapping("/area")
    public RespBean EditArea(@RequestBody Area area){
        return areaService.updateById(area)? RespBean.success(""): RespBean.error("");
    }

    @ApiOperation(value = "添加小区")
    @PostMapping("/area")
    public RespBean AddArea(@RequestBody Area area){
        return areaService.save(area)? RespBean.success(""): RespBean.error("");
    }
}
