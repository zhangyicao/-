package com.yicao.pmiapi.controller;


import com.yicao.pmiapi.pojo.RepairHandle;
import com.yicao.pmiapi.pojo.RespBean;
import com.yicao.pmiapi.service.IRepairHandleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yicao
 * @since 2021-05-12
 */
@Api(tags = "报修处理管理")
@RestController
public class RepairHandleController {

    @Autowired
    IRepairHandleService repairHandleService;

    @ApiOperation(value = "添加新报修进度")
    @PostMapping("/repair-handle")
    public RespBean addHandleByRepairId(@RequestBody RepairHandle repairHandle) {
        repairHandle.setDate(LocalDateTime.now());
        return repairHandleService.save(repairHandle)? RespBean.success(""): RespBean.error("");
    }
}
