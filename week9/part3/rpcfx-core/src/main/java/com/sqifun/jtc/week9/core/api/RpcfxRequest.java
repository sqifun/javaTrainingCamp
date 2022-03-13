package com.sqifun.jtc.week9.core.api;

import lombok.Data;

/**
 * @program: week9-part3
 * @className: RpcfxRequest
 * @description:
 * @author: sqi
 * @date: 2022-03-12 14:09
 * @version: 1.0
 **/
@Data
public class RpcfxRequest {

    private String serviceClass;
    private String method;
    private Object[] params;

}