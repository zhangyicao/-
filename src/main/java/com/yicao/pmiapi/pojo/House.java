package com.yicao.pmiapi.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.List;

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
@TableName("t_house")
@ApiModel(value="House对象", description="")
public class House implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "楼栋号")
    @TableField("building_num")
    private Integer buildingNum;

    @ApiModelProperty(value = "单元号")
    @TableField("unit_num")
    private Integer unitNum;

    @ApiModelProperty(value = "楼层号")
    @TableField("floor_num")
    private Integer floorNum;

    @ApiModelProperty(value = "门牌号")
    @TableField("house_num")
    private String houseNum;

    @ApiModelProperty(value = "房屋状态")
    @TableField("house_state")
    private String houseState;

    @ApiModelProperty(value = "交房时间")
    @TableField("complete_date")
    private LocalDate completeDate;

    @ApiModelProperty(value = "房屋面积")
    @TableField("house_area")
    private Integer houseArea;

    @ApiModelProperty(value = "户型")
    @TableField("house_type")
    private String houseType;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "小区id")
    @TableField("area_id")
    private Integer areaId;

    @ApiModelProperty(value = "家庭id")
    @TableField("family_id")
    private Integer familyId;

    @ApiModelProperty(value = "地址")
    @TableField(exist = false)
    private String address;
}
