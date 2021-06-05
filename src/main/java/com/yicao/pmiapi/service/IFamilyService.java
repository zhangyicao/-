package com.yicao.pmiapi.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yicao.pmiapi.pojo.Family;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yicao
 * @since 2021-04-29
 */
public interface IFamilyService extends IService<Family> {

    void findFamilyList(Page<Map<String, Object>> mapPage, String word) throws Exception;
}
