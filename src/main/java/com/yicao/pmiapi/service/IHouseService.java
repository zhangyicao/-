package com.yicao.pmiapi.service;

import com.yicao.pmiapi.pojo.House;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yicao
 * @since 2021-04-29
 */
public interface IHouseService extends IService<House> {

    List<House> getListByFamilyId(Integer familyId);
}
