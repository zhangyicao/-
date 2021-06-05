package com.yicao.pmiapi.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yicao.pmiapi.pojo.Repair;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yicao
 * @since 2021-05-12
 */
public interface IRepairService extends IService<Repair> {

    void getListByType(Page<Repair> mapPage, Integer type);

    Repair getById(Integer id);

    boolean addRepair(Repair repair, List<String> imgUrlList);
}
