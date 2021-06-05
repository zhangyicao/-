package com.yicao.pmiapi.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yicao.pmiapi.mapper.RepairImgMapper;
import com.yicao.pmiapi.pojo.Repair;
import com.yicao.pmiapi.mapper.RepairMapper;
import com.yicao.pmiapi.pojo.RepairImg;
import com.yicao.pmiapi.service.IRepairImgService;
import com.yicao.pmiapi.service.IRepairService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yicao
 * @since 2021-05-12
 */
@Service
public class RepairServiceImpl extends ServiceImpl<RepairMapper, Repair> implements IRepairService {

    @Autowired
    RepairMapper repairMapper;
    @Autowired
    IRepairImgService repairImgService;

    @Override
    public void getListByType(Page<Repair> mapPage, Integer type) {
        repairMapper.getList(mapPage, type);
    }

    public Repair getById(Integer id) {
        return repairMapper.getById(id);
    }

    @Override
    public boolean addRepair(Repair repair, List<String> imgUrlList) {
        int insert = repairMapper.insert(repair);
        if (insert != 1) return false;
        if (imgUrlList == null || imgUrlList.size() == 0) return true;

        List<RepairImg> repairImgList = new ArrayList<>();
        for (String imgUrl : imgUrlList) {
            RepairImg repairImg = new RepairImg();
            repairImg.setImgUrl(imgUrl);
            repairImg.setRepairId(repair.getId());
            repairImgList.add(repairImg);
        }
        return repairImgService.saveBatch(repairImgList);
    }
}
