package com.yicao.pmiapi.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yicao.pmiapi.pojo.Complaint;
import com.yicao.pmiapi.pojo.RespBean;
import com.yicao.pmiapi.service.IComplaintService;
import com.yicao.pmiapi.utils.Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yicao
 * @since 2021-05-11
 */
@Api(tags = "投诉管理")
@RestController
public class ComplaintController {

    @Autowired
    private IComplaintService complaintService;
    @Autowired
    private Util util;

    @ApiOperation(value = "查询投诉列表")
    @GetMapping("/complaints")
    public RespBean getComplaintListByPage(@RequestParam("page") Integer page, @RequestParam("pageSize") Integer pageSize, @RequestParam(value = "word", required = false) String word) {
        Page<Complaint> mapPage = new Page<>(page, pageSize);
        complaintService.findComplaintList(mapPage, word);

        return RespBean.success(mapPage);
    }

    @ApiOperation(value = "根据id查询投诉信息")
    @GetMapping("/complaint/{id:\\d+}")
    public RespBean getComplaintListByPage(@PathVariable Integer id) {
        Complaint complaint = complaintService.getComplaintById(id);
        return RespBean.success(complaint);
    }

    @ApiOperation(value = "添加投诉信息")
    @PostMapping("/complaint")
    public RespBean addComplaint(Principal principal, @RequestBody Complaint complaint) {
        complaint.setDate(LocalDateTime.now());
        Integer familyId = util.getFamilyId(principal);
        if (familyId == null) return RespBean.error("账号验证错误");
        complaint.setFamilyId(familyId);
        boolean res = complaintService.addComplaint(complaint);
        return res? RespBean.success(""): RespBean.error("");
    }
}
