package com.yicao.pmiapi.service;

import com.yicao.pmiapi.pojo.RespBean;
import com.yicao.pmiapi.pojo.Unit;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yicao
 * @since 2021-05-06
 */
public interface IUnitService extends IService<Unit> {

    RespBean getKeyById(Integer unitId);
}
