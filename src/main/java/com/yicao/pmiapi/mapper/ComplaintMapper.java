package com.yicao.pmiapi.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yicao.pmiapi.pojo.Complaint;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yicao
 * @since 2021-05-11
 */
public interface ComplaintMapper extends BaseMapper<Complaint> {

    IPage<?> findComplaintList(Page<?> page);

    Complaint getComplaintById(Integer id);

    Integer addComplaint(Complaint complaint);
}
