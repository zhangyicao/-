package com.yicao.pmiapi.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
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
 * @since 2021-04-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_area")
@ApiModel(value="Area对象", description="")
public class Area implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "小区名称")
    private String name;

    @ApiModelProperty(value = "描述")
    private String des;

    @ApiModelProperty(value = "负责人姓名")
    private String leader;

    @ApiModelProperty(value = "总楼栋数")
    @TableField("build_number")
    private Integer buildNumber;

    @ApiModelProperty(value = "完工日期")
    @TableField("complete_date")
    private LocalDate completeDate;

    @ApiModelProperty(value = "占地面积")
    @TableField("covered_area")
    private Double coveredArea;

    @ApiModelProperty(value = "总户数")
    @TableField("house_number")
    private Integer houseNumber;

    @ApiModelProperty(value = "已入住户数")
    @TableField("family_number")
    private Integer familyNumber;

    @ApiModelProperty(value = "备注")
    private String remark;


}
