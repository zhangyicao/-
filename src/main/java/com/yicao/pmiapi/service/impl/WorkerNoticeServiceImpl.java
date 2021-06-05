package com.yicao.pmiapi.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yicao.pmiapi.pojo.Notice;
import com.yicao.pmiapi.pojo.WorkerNotice;
import com.yicao.pmiapi.mapper.WorkerNoticeMapper;
import com.yicao.pmiapi.service.IWorkerNoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yicao
 * @since 2021-05-10
 */
@Service
public class WorkerNoticeServiceImpl extends ServiceImpl<WorkerNoticeMapper, WorkerNotice> implements IWorkerNoticeService {

    @Autowired
    WorkerNoticeMapper workerNoticeMapper;

    @Override
    public void findNoticeList(Page<?> noticePage, String word) {
        workerNoticeMapper.findNoticeList(noticePage, word);
    }
}
