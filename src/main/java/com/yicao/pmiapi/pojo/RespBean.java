package com.yicao.pmiapi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 公共返回对象
 *
 * @author: yicao
 * @create: 2021-04-23 22:22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespBean {

    private long code;
    private String message;
    private Object obj;

    /**
     * 成功返回
     * @param message
     * @return
     */
    public static RespBean success(String message){
        return new RespBean(200, message, null);
    }


    /**
     * 成功返回
     * @param obj
     * @return
     */
    public static RespBean success(Object obj){
        return new RespBean(200, null, obj);
    }


    /**
     * 成功返回
     * @param message
     * @param obj
     * @return
     */
    public static RespBean success(String message, Object obj){
        return new RespBean(200, message, obj);
    }


    /**
     * 失败返回
     * @param message
     * @return
     */
    public static RespBean error(String message) {
        return new RespBean(500, message, null);
    }


    /**
     * 失败返回
     * @param message
     * @param obj
     * @return
     */
    public static RespBean error(String message, Object obj) {
        return new RespBean(500, message, obj);
    }
}

