package com.yicao.pmiapi.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
 * @since 2021-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_worker_family_account")
@ApiModel(value="WorkerFamilyAccount对象", description="")
public class WorkerFamilyAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "账户id")
    @TableField("account_id")
    private Integer accountId;

    @ApiModelProperty(value = "员工id")
    @TableField("worker_id")
    private Integer workerId;

    @ApiModelProperty(value = "家庭id")
    @TableField("family_id")
    private Integer familyId;

    @ApiModelProperty(value = "账户类型：0员工，1家庭")
    private Integer type;


}
