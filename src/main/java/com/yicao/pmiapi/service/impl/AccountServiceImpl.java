package com.yicao.pmiapi.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yicao.pmiapi.config.security.JwtTokenUtil;
import com.yicao.pmiapi.mapper.AccountMapper;
import com.yicao.pmiapi.mapper.WorkerFamilyAccountMapper;
import com.yicao.pmiapi.pojo.Account;
import com.yicao.pmiapi.pojo.RespBean;
import com.yicao.pmiapi.pojo.VO.AccountAdd;
import com.yicao.pmiapi.pojo.WorkerFamilyAccount;
import com.yicao.pmiapi.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yicao
 * @since 2021-04-25
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private WorkerFamilyAccountMapper workerFamilyAccountMapper;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    /**
     * 登录之后返回token
     * @param username
     * @param password
     * @param code
     * @param request
     * @return
     */
    @Override
    public RespBean login(String username, String password, String code, HttpServletRequest request) {
        // 登录
        System.out.println("AccountServiceImpl");
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (null == userDetails || !passwordEncoder.matches(password, userDetails.getPassword())){
            return RespBean.error("用户名或密码不正确");
        }
        if (!userDetails.isEnabled()) {
            return RespBean.error("账号已禁用，请联系管理员");
        }

        // 更新security登录用户对象
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        // 生成token并返回
        String token = jwtTokenUtil.generateToken(userDetails);
        Map<String, String> tokenMap = new HashMap<>();
        Account account = ((Account)userDetails);
        if (account.getType() == 0) {
            tokenMap.put("worker_name", account.getWorker().getWorker_name());
        } else {
            tokenMap.put("family_name", account.getFamily().getName());
        }
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);

        return RespBean.success("登录成功", tokenMap);
    }

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    @Override
    public Account getAdminByUserName(String username) {
        System.out.println(123);
        Map<String, Object> map = accountMapper.getTypeByUsername(username);
        if (map == null) return null;
        System.out.println(map);
        Integer type = (Integer) map.get("type");
        Account account = null;
        if (type == 0) {
            account = accountMapper.getAccountByUserName(username);
        } else if (type == 1) {
            account = accountMapper.getFamilyAccountByUsername(username);
        }
        return account;
    }

    /**
     * 注销当前用户
     * @return
     * @param name
     */
    @Override
    public int logout(String name) {
        Account account = new Account();
        LocalDateTime ldt = new Date().toInstant()
                .atZone( ZoneId.systemDefault() )
                .toLocalDateTime();
        account.setLastLogin(ldt);
        return accountMapper.update(account, new QueryWrapper<Account>().eq("username", name));
    }

    /**
     * 根据用户名获取员工信息
     * @param username
     * @return
     */
    private String getWorkNameByUserName(String username) {
        return null;
    }

    /**
     *
     * @param account
     * @param type 0管理员 1家庭
     * @return
     */
    @Transactional
    public boolean addAccount(AccountAdd accountAdd) {
        // 先将密码加密，然后把账户存入数据库
        Account account = accountAdd.getAccount();
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        accountMapper.insert(account);

        // 关联账户与用户
        WorkerFamilyAccount workerFamilyAccount = new WorkerFamilyAccount();
        workerFamilyAccount.setAccountId(account.getId());
        if (accountAdd.getType() == 0) {
            workerFamilyAccount.setWorkerId(accountAdd.getId());
            workerFamilyAccount.setType(0);
        } else if (accountAdd.getType() == 1) {
            workerFamilyAccount.setFamilyId(accountAdd.getId());
            workerFamilyAccount.setType(1);
        }
        return workerFamilyAccountMapper.insert(workerFamilyAccount) == 1;
    }

    @Override
    public String getAdminUsernameByWorkerId(Integer id) {
        return accountMapper.getAdminUsernameByWorkerId(id);
    }

    @Override
    public String getFamilyUsernameByWorkerId(Integer id) {
        return accountMapper.getFamilyUsernameByWorkerId(id);
    }


}
