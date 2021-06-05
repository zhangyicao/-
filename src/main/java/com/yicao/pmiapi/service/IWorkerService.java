package com.yicao.pmiapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yicao.pmiapi.pojo.Account;
import com.yicao.pmiapi.pojo.RespBean;
import com.yicao.pmiapi.pojo.Worker;

import java.util.List;

public interface IWorkerService extends IService<Worker> {

    Worker findById(int workerId);

    List<Worker> findListByPage(Integer page, Integer pageSize);

    List<Worker> findListByPage(Integer page, Integer pageSize, String word);

    Integer addWorker(Worker worker);

    Integer updateWorker(Worker worker);

    Integer deleteWorker(Integer id);

    Integer countWorker();

    Integer countWorker(String word);

    /**
     * 获取登录用户的信息
     * @return
     */
    RespBean getSelfInfo();
}
