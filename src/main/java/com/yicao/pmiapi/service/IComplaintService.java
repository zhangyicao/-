package com.yicao.pmiapi.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yicao.pmiapi.pojo.Complaint;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yicao
 * @since 2021-05-11
 */
public interface IComplaintService extends IService<Complaint> {

    void findComplaintList(Page<?> mapPage, String word);

    Complaint getComplaintById(Integer id);

    boolean addComplaint(Complaint complaint);
}
