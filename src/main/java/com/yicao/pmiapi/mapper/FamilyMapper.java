package com.yicao.pmiapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yicao.pmiapi.pojo.Family;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yicao
 * @since 2021-04-29
 */
public interface FamilyMapper extends BaseMapper<Family> {
    IPage<Map<String,Object>> findFamilyList (Page<?> page, @Param("word") String word);
}
