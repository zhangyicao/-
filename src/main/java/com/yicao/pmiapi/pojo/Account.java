package com.yicao.pmiapi.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Collection;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * <p>
 *
 * </p>
 *
 * @author yicao
 * @since 2021-04-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_account")
@ApiModel(value="Account对象", description="")
public class Account implements Serializable, UserDetails{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "上次登录时间")
    @TableField("last_login")
    private LocalDateTime lastLogin;

    @ApiModelProperty(value = "员工信息")
    @TableField(exist = false)
    private Worker worker;

    @ApiModelProperty(value = "员工id")
    @TableField(exist = false)
    private Integer workerId;

    @ApiModelProperty(value = "家庭信息")
    @TableField(exist = false)
    private Family family;

    @ApiModelProperty(value = "家庭id")
    @TableField(exist = false)
    private Integer familyId;

    @ApiModelProperty(value = "账户类型", notes = "0员工，1家庭")
    @TableField(exist = false)
    private Integer type;

    @ApiModelProperty(value = "是否启用：0否，1是")
    private Integer enable;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enable == 1;
    }


}
