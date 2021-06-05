package com.yicao.pmiapi.service.impl;

import com.yicao.pmiapi.pojo.RespBean;
import com.yicao.pmiapi.pojo.Unit;
import com.yicao.pmiapi.mapper.UnitMapper;
import com.yicao.pmiapi.service.IUnitService;
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
 * @since 2021-05-06
 */
@Service
public class UnitServiceImpl extends ServiceImpl<UnitMapper, Unit> implements IUnitService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    UnitMapper unitMapper;

    @Override
    public RespBean getKeyById(Integer unitId) {
        Map<String, Integer> map = unitMapper.getKeyById(unitId);
        return RespBean.success(map);
    }
}
