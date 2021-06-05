package com.yicao.pmiapi.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_worker")
@ApiModel(value="Worker对象", description="")
public class Worker {

    @ApiModelProperty(value = "id")
    @TableId(value = "worker_id", type = IdType.AUTO)
    private int worker_id;

    @ApiModelProperty("员工姓名")
    private String worker_name;

    @ApiModelProperty("部门")
    private String department;

    @ApiModelProperty("职位")
    private String worker_post;

    @ApiModelProperty("生日")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date worker_birthday;

    @ApiModelProperty("性别")
    private int worker_gender;

    @ApiModelProperty("电话")
    private String worker_phone;

    @ApiModelProperty("地址")
    private String worker_address;

    @ApiModelProperty("籍贯")
    private String worker_native_place;

    @ApiModelProperty("照片")
    private String worker_photo;

    @ApiModelProperty("备注")
    private String remark;

    public Worker(String worker_name, String department, String worker_post, Date worker_birthday, int worker_gender, String worker_phone, String worker_address, String worker_native_place, String worker_photo, String remark) {
        this.worker_name = worker_name;
        this.department = department;
        this.worker_post = worker_post;
        this.worker_birthday = worker_birthday;
        this.worker_gender = worker_gender;
        this.worker_phone = worker_phone;
        this.worker_address = worker_address;
        this.worker_native_place = worker_native_place;
        this.worker_photo = worker_photo;
        this.remark = remark;
    }
}


