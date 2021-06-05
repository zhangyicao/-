package com.yicao.pmiapi.controller;


import com.yicao.pmiapi.pojo.Member;
import com.yicao.pmiapi.pojo.RespBean;
import com.yicao.pmiapi.service.IMemberService;
import io.swagger.annotations.Api;
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
 * @since 2021-04-29
 */
@Api(tags = "家庭成员控制器")
@RestController
public class MemberController {

    @Autowired
    private IMemberService memberService;

    @ApiOperation(value = "根据家庭id查询成员列表")
    @GetMapping("/members")
    public RespBean getMemberListByFamilyId(@RequestParam("family_id") Integer familyId) {
        Map<String, Object> map = new HashMap<>();
        map.put("family_id", familyId);
        List<Member> members = memberService.listByMap(map);
        return RespBean.success(members);
    }

    @ApiOperation(value = "根据家庭id添加一个成员")
    @PostMapping("/member")
    public RespBean addMemberByFamilyId(@RequestBody Member member) {
        return memberService.save(member)? RespBean.success(""): RespBean.error("");
    }

    @ApiOperation(value = "根据家庭id删除一个成员")
    @DeleteMapping("/member/{familyId:\\d+}")
    public RespBean deleteMemberByFamilyId(@PathVariable Integer familyId) {
        return memberService.removeById(familyId)? RespBean.success(""): RespBean.error("");
    }

    @ApiOperation(value = "根据家庭id修改一个成员")
    @PutMapping("/member")
    public RespBean editMemberByFamilyId(@RequestBody Member member) {
        return memberService.updateById(member)? RespBean.success(""): RespBean.error("");
    }
}
