package com.yicao.pmiapi.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yicao.pmiapi.pojo.Family;
import com.yicao.pmiapi.mapper.FamilyMapper;
import com.yicao.pmiapi.service.IFamilyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yicao
 * @since 2021-04-29
 */
@Service
public class FamilyServiceImpl extends ServiceImpl<FamilyMapper, Family> implements IFamilyService {


    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    FamilyMapper familyMapper;

    @Override
    public void findFamilyList(Page<Map<String, Object>> mapPage, String word) throws Exception {
        familyMapper.findFamilyList(mapPage, word);
    }
}
