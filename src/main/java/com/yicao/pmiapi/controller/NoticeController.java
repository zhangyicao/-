package com.yicao.pmiapi.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yicao.pmiapi.pojo.Account;
import com.yicao.pmiapi.pojo.Notice;
import com.yicao.pmiapi.pojo.RespBean;
import com.yicao.pmiapi.pojo.Worker;
import com.yicao.pmiapi.service.IAccountService;
import com.yicao.pmiapi.service.INoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yicao
 * @since 2021-05-10
 */
@Api(tags = "业主通知管理")
@RestController
public class NoticeController {

    @Autowired
    INoticeService noticeService;
    @Autowired
    IAccountService accountService;

    @ApiOperation(value = "查询通知列表")
    @GetMapping("/notices")
    public RespBean getNoticeListByPage(@RequestParam("page") Integer page, @RequestParam("pageSize") Integer pageSize, @RequestParam(value = "word", required = false) String word) throws Exception {
        Page<Notice> noticePage = new Page<>(page, pageSize);
        noticeService.findNoticeList(noticePage, word);
        return RespBean.success(noticePage);
    }

    @ApiOperation(value = "根据id查询通知")
    @GetMapping("/notice/{id:\\d+}")
    public RespBean getNoticeById(@PathVariable Integer id) {
        Notice notice = noticeService.getById(id);
        return RespBean.success(notice);
    }

    @ApiOperation(value = "修改通知")
    @PutMapping("/notice")
    public RespBean editNotice(@RequestBody Notice notice) {
        System.out.println(notice);
        System.out.println(123);
        return noticeService.updateById(notice)? RespBean.success(""): RespBean.error("");
    }

    @ApiOperation(value = "添加通知")
    @PostMapping("/notice")
    public RespBean addNotice(Principal principal, @RequestBody Notice notice) {
        if (null == principal) {
            return null;
        }
        String username = principal.getName();
        Account account = accountService.getAdminByUserName(username);
        notice.setWorkerId(account.getWorker().getWorker_id());
        System.out.println(notice);
        return noticeService.save(notice)? RespBean.success(""): RespBean.error("");
    }

    @ApiOperation(value = "删除通知")
    @DeleteMapping("/notice/{id:\\d+}")
    public RespBean deleteNotice(@PathVariable Integer id) {
        return noticeService.removeById(id)? RespBean.success(""): RespBean.error("");
    }

}
