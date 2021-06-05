package com.yicao.pmiapi.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yicao.pmiapi.pojo.Account;
import com.yicao.pmiapi.pojo.Complaint;
import com.yicao.pmiapi.pojo.Repair;
import com.yicao.pmiapi.pojo.RespBean;
import com.yicao.pmiapi.service.IAccountService;
import com.yicao.pmiapi.service.IRepairService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yicao
 * @since 2021-05-12
 */
@Api(tags = "报修管理")
@RestController
public class RepairController {
    @Autowired
    IRepairService repairService;
    @Autowired
    IAccountService accountService;

    @ApiOperation(value = "查询报修列表")
    @GetMapping("/repairs/{type:[1-3]}")
    public RespBean getComplaintListByPage(@RequestParam("page") Integer page, @RequestParam("pageSize") Integer pageSize, @RequestParam(value = "word", required = false) String word, @PathVariable Integer type) {
        Page<Repair> mapPage = new Page<>(page, pageSize);
        repairService.getListByType(mapPage, type);
        return RespBean.success(mapPage);
    }

    @ApiOperation(value = "根据id查询报修信息")
    @GetMapping("/repair/{id:\\d+}")
    public RespBean getRepairById(@PathVariable Integer id) {
        Repair repair = repairService.getById(id);
        return RespBean.success(repair);
    }

    @ApiOperation(value = "修改报修状态")
    @PatchMapping("/repair")
    public RespBean editRepairHandleProcess(@RequestBody Repair repair) {
        return repairService.updateById(repair)? RespBean.success(""): RespBean.error("");
    }

    @ApiOperation(value = "添加报修信息")
    @PostMapping("/repair")
    public RespBean addRepair(Principal principal, @RequestBody Map<String, Object> map) {
        System.out.println(map);
        // 参数处理
        Integer houseId = null;
        String body = null;
        List<String> imgUrlList = null;
        try {
            houseId = (Integer) map.get("houseId");
            body = (String) map.get("body");
            imgUrlList = (List<String>) map.get("imgUrlList");
        } catch (Exception e) {
            return RespBean.error("参数错误" + e.toString());
        }
        if (houseId == null || body == null) {
            return RespBean.error("参数不全");
        }
        System.out.println(imgUrlList);
        // 获取家庭id
        if (null == principal) {
            return null;
        }
        System.out.println(principal);
        String username = principal.getName();
        Account account = accountService.getAdminByUserName(username);
        Integer familyId = account.getFamilyId();

        Repair repair = new Repair();
        repair.setBody(body);
        repair.setDate(LocalDateTime.now());
        repair.setHouseId(houseId);
        repair.setFamilyId(familyId);

        return repairService.addRepair(repair, imgUrlList)? RespBean.success(""): RespBean.error("");
    }
}
