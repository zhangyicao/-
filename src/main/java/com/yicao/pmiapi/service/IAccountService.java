package com.yicao.pmiapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yicao.pmiapi.pojo.Account;
import com.yicao.pmiapi.pojo.RespBean;
import com.yicao.pmiapi.pojo.VO.AccountAdd;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  账户服务类
 * </p>
 *
 * @author yicao
 * @since 2021-04-25
 */
public interface IAccountService extends IService<Account> {

    /**
     * 登录之后返回token
     * @param username
     * @param password
     * @param code
     * @param request
     * @return
     */
    RespBean login(String username, String password, String code, HttpServletRequest request);

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    Account getAdminByUserName(String username);

    /**
     * 注销当前用户
     * @return
     * @param name
     */
    int logout(String name);

    /**
     * 添加账户
     * @param accountAdd
     * @return
     */
    boolean addAccount(AccountAdd accountAdd);

    /**
     * 根据员工id获取管理员用户名
     * @param id
     * @return
     */
    String getAdminUsernameByWorkerId(Integer id);

    String getFamilyUsernameByWorkerId(Integer id);
}
