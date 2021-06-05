package com.yicao.pmiapi.service.impl;

import com.yicao.pmiapi.pojo.Member;
import com.yicao.pmiapi.mapper.MemberMapper;
import com.yicao.pmiapi.service.IMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yicao
 * @since 2021-04-29
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements IMemberService {

}
