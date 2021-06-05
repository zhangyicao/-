package com.yicao.pmiapi.mapper;

import com.yicao.pmiapi.pojo.Unit;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yicao
 * @since 2021-05-06
 */
public interface UnitMapper extends BaseMapper<Unit> {

    Map<String,Integer> getKeyById(Integer unitId);
}
