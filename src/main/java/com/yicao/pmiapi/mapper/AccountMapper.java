package com.yicao.pmiapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yicao.pmiapi.pojo.Account;

import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yicao
 * @since 2021-04-25
 */
public interface AccountMapper extends BaseMapper<Account> {

    String getAdminUsernameByWorkerId(Integer id);

    /**
     * 根据用户id获取账户信息
     * @param username
     * @return
     */
    Account getAccountByUserName(String username);

    /**
     * 根据用户名获取账户类型
     * @param username
     * @return
     */
    Map<String, Object> getTypeByUsername(String username);

    /**
     * 根据用户名获取家庭账户信息
     * @param username
     * @return
     */
    Account getFamilyAccountByUsername(String username);

    String getFamilyUsernameByWorkerId(Integer id);
}
