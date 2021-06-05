package com.yicao.pmiapi.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author yicao
 * @since 2021-05-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_worker_notice")
@ApiModel(value="WorkerNotice对象", description="")
public class WorkerNotice implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "员工id")
    @TableField("worker_id")
    private Integer workerId;

    @ApiModelProperty(value = "标题")
    @TableField("notice_title")
    private String noticeTitle;

    @ApiModelProperty(value = "内容")
    @TableField("notice_body")
    private String noticeBody;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "日期")
    @TableField("notice_date")
    private LocalDateTime noticeDate;

    @ApiModelProperty(value = "备注")
    private String remark;


    @ApiModelProperty(value = "员工姓名")
    @TableField(exist = false)
    private String workerName;


}
