package com.yicao.pmiapi.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yicao.pmiapi.mapper.ComplaintImgMapper;
import com.yicao.pmiapi.pojo.Complaint;
import com.yicao.pmiapi.mapper.ComplaintMapper;
import com.yicao.pmiapi.pojo.ComplaintImg;
import com.yicao.pmiapi.service.IComplaintImgService;
import com.yicao.pmiapi.service.IComplaintService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yicao
 * @since 2021-05-11
 */
@Service
public class ComplaintServiceImpl extends ServiceImpl<ComplaintMapper, Complaint> implements IComplaintService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private ComplaintMapper complaintMapper;
    @Autowired
    private IComplaintImgService complaintImgService;

    @Override
    public void findComplaintList(Page<?> mapPage, String word) {
        complaintMapper.findComplaintList(mapPage);
    }

    @Override
    public Complaint getComplaintById(Integer id) {
        return complaintMapper.getComplaintById(id);
    }

    @Override
    public boolean addComplaint(Complaint complaint) {
        int insert = complaintMapper.insert(complaint);
        if (insert == 1) {
            if (complaint.getComplaintImgs() == null) return true;
            for (ComplaintImg complaintImg : complaint.getComplaintImgs()) {
                complaintImg.setComplaintId(complaint.getId());
            }
            boolean b = complaintImgService.saveBatch(complaint.getComplaintImgs());
            return b;
        }
        return false;
    }
}
