package com.yicao.pmiapi.controller;

import com.yicao.pmiapi.pojo.RespBean;
import com.yicao.pmiapi.pojo.Worker;
import com.yicao.pmiapi.service.IWorkerService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "用户管理")
@RestController
public class WorkerController {

    @Autowired
    IWorkerService IWorkerService;

    @ApiOperation(value = "查询员工列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, paramType = "query" ),
            @ApiImplicitParam(name = "word", value = "查询字", paramType = "query")
    })
    @GetMapping("/worker")
    public Object getWorkerList(@RequestParam("page") Integer page, @RequestParam("pageSize") Integer pageSize, @RequestParam(value = "word", defaultValue = "") String word){
        if (page < 1) page = 1;
        List<Worker> workers = IWorkerService.findListByPage(page, pageSize, word);
        return workers;
    }

    @ApiOperation(value = "根据id获取员工详情信息")
    @GetMapping("/worker/{id:\\d+}")
    public Object getWorkerById(@PathVariable Integer id){
        System.out.println("id:" + id);
        Worker worker = IWorkerService.findById(id);
        return worker;
    }

    @ApiOperation(value = "统计员工数量")
    @GetMapping("/workernum")
    public Integer getWorkerNum(@RequestParam(value = "word", defaultValue = "") String word){
        return IWorkerService.countWorker(word);
    }

    @ApiOperation(value = "添加新员工")
    @PostMapping("/worker")
    @ResponseBody
    public Integer addWorker(@RequestBody Worker worker){
        System.out.println(worker);
        return IWorkerService.addWorker(worker);
    }

    @ApiOperation(value = "根据id删除一个员工")
    @DeleteMapping("/worker/{worker_id:\\d+}")
    public Integer deleteWorker(@PathVariable Integer worker_id){
        return IWorkerService.deleteWorker(worker_id);
    }

    @ApiOperation(value = "修改员工信息")
    @PutMapping("/worker")
    @ResponseBody
    public Integer putWorker(@RequestBody Worker worker){
        System.out.println(worker);
//        return 1;
        return IWorkerService.updateWorker(worker);
    }


}
