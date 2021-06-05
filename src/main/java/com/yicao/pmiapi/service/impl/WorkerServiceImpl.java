package com.yicao.pmiapi.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yicao.pmiapi.mapper.AccountMapper;
import com.yicao.pmiapi.pojo.Account;
import com.yicao.pmiapi.pojo.RespBean;
import com.yicao.pmiapi.pojo.Worker;
import com.yicao.pmiapi.mapper.WorkerMapper;
import com.yicao.pmiapi.service.IWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerServiceImpl extends ServiceImpl<WorkerMapper, Worker> implements IWorkerService {

    @Autowired
    private WorkerMapper mapper;

    @Override
    public Worker findById(int workerId) {
        return mapper.findById(workerId);
    }

    @Override
    public List<Worker> findListByPage(Integer page, Integer pageSize) {
        return mapper.findListByPage((page - 1) * pageSize, pageSize, null);
    }

    @Override
    public List<Worker> findListByPage(Integer page, Integer pageSize, String word) {
        if ("".equals(word))
            return findListByPage(page, pageSize);
        else
            return mapper.findListByPage((page - 1) * pageSize, pageSize, word);
    }

    @Override
    public Integer addWorker(Worker worker) {
        return mapper.addWorker(worker);
    }

    @Override
    public Integer updateWorker(Worker worker) {
        return mapper.updateWorker(worker);
    }

    @Override
    public Integer deleteWorker(Integer id) {
        return mapper.delWorker(id);
    }

    @Override
    public Integer countWorker() {
        return mapper.countWorker(null);
    }

    @Override
    public Integer countWorker(String word) {
        if (word == null || "".equals(word))
            return countWorker();
        else
            return mapper.countWorker(word);
    }

    /**
     * 获取登录用户的信息
     * @return
     */
    @Override
    public RespBean getSelfInfo() {
        Worker worker = ((Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getWorker();
        return RespBean.success("获取成功", worker);
    }
}
