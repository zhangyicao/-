package com.yicao.pmiapi.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yicao.pmiapi.pojo.Notice;
import com.yicao.pmiapi.mapper.NoticeMapper;
import com.yicao.pmiapi.service.INoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yicao
 * @since 2021-05-10
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements INoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public void findNoticeList(Page<?> mapPage, String word) {
        noticeMapper.findNoticeList(mapPage, word);
    }
}
