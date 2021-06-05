package com.yicao.pmiapi.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yicao.pmiapi.pojo.Family;
import com.yicao.pmiapi.pojo.RespBean;
import com.yicao.pmiapi.service.IFamilyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author yicao
 * @since 2021-04-29
 */
@Api(tags = "家庭管理")
@RestController
public class FamilyController {

    @Autowired
    private IFamilyService familyService;

    @ApiOperation(value = "查询家庭列表")
    @GetMapping("/families")
    public RespBean GetFamilyListByPage(@RequestParam("page") Integer page, @RequestParam("pageSize") Integer pageSize, @RequestParam(value = "word", required = false) String word) throws Exception {
        Page<Map<String, Object>> mapPage = new Page<>(page, pageSize);
        familyService.findFamilyList(mapPage, word);
        return RespBean.success(mapPage);
    }

    @ApiOperation("添加家庭")
    @PostMapping("/family")
    public RespBean AddFamily(@RequestBody Family family) {
        return RespBean.success(familyService.save(family));
    }

    @ApiOperation("修改家庭")
    @PutMapping("/family")
    public RespBean EditFamily(@RequestBody Family family) {
        return RespBean.success(familyService.updateById(family));
    }


}
