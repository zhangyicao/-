package com.yicao.pmiapi.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult implements Serializable {
    private Integer code;
    private String message;
    private Object data;
}