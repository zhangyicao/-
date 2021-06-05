package com.yicao.pmiapi.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yicao.pmiapi.pojo.Notice;
import com.yicao.pmiapi.pojo.WorkerNotice;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yicao
 * @since 2021-05-10
 */
public interface IWorkerNoticeService extends IService<WorkerNotice> {

    void findNoticeList(Page<?> noticePage, String word);
}
