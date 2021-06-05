package com.yicao.pmiapi.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yicao.pmiapi.pojo.Notice;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yicao
 * @since 2021-05-10
 */
public interface INoticeService extends IService<Notice> {

    void findNoticeList(Page<?> mapPage, String word);
}
