package com.yicao.pmiapi.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yicao.pmiapi.pojo.Account;
import com.yicao.pmiapi.pojo.Notice;
import com.yicao.pmiapi.pojo.RespBean;
import com.yicao.pmiapi.pojo.WorkerNotice;
import com.yicao.pmiapi.service.IAccountService;
import com.yicao.pmiapi.service.INoticeService;
import com.yicao.pmiapi.service.IWorkerNoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yicao
 * @since 2021-05-10
 */
@Api(tags = "员工通知")
@RestController
public class WorkerNoticeController {


    @Autowired
    IWorkerNoticeService workerNoticeService;
    @Autowired
    IAccountService accountService;

    @ApiOperation(value = "查询通知列表")
    @GetMapping("/workerNotices")
    public RespBean getNoticeListByPage(@RequestParam("page") Integer page, @RequestParam("pageSize") Integer pageSize, @RequestParam(value = "word", required = false) String word) throws Exception {
        Page<Notice> workerNoticePage = new Page<>(page, pageSize);
        workerNoticeService.findNoticeList(workerNoticePage, word);
        return RespBean.success(workerNoticePage);
    }

    @ApiOperation(value = "根据id查询通知")
    @GetMapping("/workerNotice/{id:\\d+}")
    public RespBean getNoticeById(@PathVariable Integer id) {
        WorkerNotice workerNotice = workerNoticeService.getById(id);
        return RespBean.success(workerNotice);
    }

    @ApiOperation(value = "修改通知")
    @PutMapping("/workerNotice")
    public RespBean editNotice(@RequestBody WorkerNotice workerNotice) {
        System.out.println(workerNotice);
        System.out.println(123);
        return workerNoticeService.updateById(workerNotice)? RespBean.success(""): RespBean.error("");
    }

    @ApiOperation(value = "添加通知")
    @PostMapping("/workerNotice")
    public RespBean addNotice(Principal principal, @RequestBody WorkerNotice workerNotice) {
        if (null == principal) {
            return null;
        }
        String username = principal.getName();
        Account account = accountService.getAdminByUserName(username);
        workerNotice.setWorkerId(account.getWorker().getWorker_id());
        System.out.println(workerNotice);
        return workerNoticeService.save(workerNotice)? RespBean.success(""): RespBean.error("");
    }

    @ApiOperation(value = "删除通知")
    @DeleteMapping("/workerNotice/{id:\\d+}")
    public RespBean deleteNotice(@PathVariable Integer id) {
        return workerNoticeService.removeById(id)? RespBean.success(""): RespBean.error("");
    }
}
