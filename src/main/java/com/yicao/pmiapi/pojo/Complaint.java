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
 * @since 2021-05-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_complaint")
@ApiModel(value="Complaint对象", description="")
public class Complaint implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "家庭id")
    @TableField("family_id")
    private Integer familyId;

    @ApiModelProperty(value = "家庭住处id")
    @TableField("house_id")
    private Integer houseId;

    @ApiModelProperty(value = "内容")
    private String body;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "投诉日期")
    private LocalDateTime date;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "相关图片")
    @TableField(exist = false)
    private List<ComplaintImg> complaintImgs;

    @ApiModelProperty(value = "家庭住处")
    @TableField(exist = false)
    private String address;


}
