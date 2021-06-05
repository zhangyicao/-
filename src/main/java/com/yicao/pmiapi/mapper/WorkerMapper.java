package com.yicao.pmiapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yicao.pmiapi.pojo.Account;
import com.yicao.pmiapi.pojo.Worker;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface WorkerMapper extends BaseMapper<Worker> {

    /*根据id查询员工详情*/
    @Select("select * from t_worker where worker_id = #{id}")
    Worker findById(int workerId);

    /*分页查询员工列表*/
    List<Worker> findListByPage(@Param("start") Integer start, @Param("pageSize") Integer pageSize, @Param("word") String word);

    /*统计员工总数*/
    Integer countWorker(String word);

    /*添加新员工*/
    @Insert("insert into t_worker(worker_name, department, worker_post, worker_birthday, worker_gender, " +
            "worker_phone, worker_address, worker_native_place" +
            ", worker_photo, remark) VALUES (#{worker_name}, #{department}, #{worker_post}, #{worker_birthday}," +
            "#{worker_gender}, #{worker_phone}, #{worker_address}, #{worker_native_place}, #{worker_photo}, #{remark})")
    Integer addWorker(Worker worker);

    /*删除员工byId*/
    @Delete("delete from t_worker where worker_id = #{id}")
    Integer delWorker(Integer id);

    /*修改员工信息*/
    @Update("update t_worker set worker_name=#{worker_name}, department=#{department}, worker_post=#{worker_post}," +
            "worker_birthday=#{worker_birthday}, worker_gender=#{worker_gender}, worker_phone=#{worker_phone}, worker_address=#{worker_address}" +
            ",worker_native_place=#{worker_native_place}, worker_photo=#{worker_photo}, remark=#{remark} where worker_id = #{worker_id}")
    Integer updateWorker(Worker worker);

}
