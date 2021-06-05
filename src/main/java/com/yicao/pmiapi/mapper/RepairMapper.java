package com.yicao.pmiapi.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yicao.pmiapi.pojo.Repair;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yicao
 * @since 2021-05-12
 */
public interface RepairMapper extends BaseMapper<Repair> {

    Repair getById(Integer id);

    IPage<Repair> getList(Page<Repair> page, @Param("handleProgress") Integer handleProgress);
}
