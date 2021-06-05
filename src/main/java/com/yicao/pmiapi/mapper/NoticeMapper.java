package com.yicao.pmiapi.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yicao.pmiapi.pojo.Notice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yicao
 * @since 2021-05-10
 */
public interface NoticeMapper extends BaseMapper<Notice> {

    IPage<Notice> findNoticeList(Page<?> mapPage, String word);
}
