package com.yicao.pmiapi.pojo.VO;

import com.yicao.pmiapi.pojo.Account;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 添加账号VO
 *
 * @author: yicao
 * @create: 2021-05-18 17:57
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AccountAdd {

    private Account account;
    private int type;
    private int id;
}
