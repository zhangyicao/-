package com.yicao.pmiapi.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yicao.pmiapi.pojo.WorkerNotice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yicao
 * @since 2021-05-10
 */
public interface WorkerNoticeMapper extends BaseMapper<WorkerNotice> {

    IPage<?> findNoticeList(Page<?> noticePage, String word);
}
