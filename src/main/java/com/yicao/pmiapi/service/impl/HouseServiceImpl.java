package com.yicao.pmiapi.service.impl;

import com.yicao.pmiapi.pojo.House;
import com.yicao.pmiapi.mapper.HouseMapper;
import com.yicao.pmiapi.service.IHouseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yicao
 * @since 2021-04-29
 */
@Service
public class HouseServiceImpl extends ServiceImpl<HouseMapper, House> implements IHouseService {

    @Autowired
    HouseMapper houseMapper;

    @Override
    public List<House> getListByFamilyId(Integer familyId) {

        return houseMapper.getListByFamilyId(familyId);
    }
}
