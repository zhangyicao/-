package com.yicao.pmiapi.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.List;

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
 * @since 2021-05-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_repair")
@ApiModel(value="Repair对象", description="")
public class Repair implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "家庭id")
    @TableField("family_id")
    private Integer familyId;

    @ApiModelProperty(value = "住房id")
    @TableField("house_id")
    private Integer houseId;

    @ApiModelProperty(value = "内容")
    private String body;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "提交日期")
    private LocalDateTime date;

    @ApiModelProperty(value = "处理进度1未处理2处理中3已完成")
    @TableField("handle_progress")
    private Integer handleProgress;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "住址")
    @TableField(exist = false)
    private String address;

    @ApiModelProperty(value = "家庭名")
    @TableField(exist = false)
    private String familyName;

    @ApiModelProperty(value = "报修图片")
    @TableField(exist = false)
    private List<RepairImg> repairImgList;

    @ApiModelProperty(value = "报修处理")
    @TableField(exist = false)
    private List<RepairHandle> repairHandleList;


}
