package com.sqifun.jtc.week9.core.api;

import lombok.Data;

/**
 * @program: week9-part3
 * @className: RpcfxResponse
 * @description:
 * @author: sqi
 * @date: 2022-03-12 14:10
 * @version: 1.0
 **/
@Data
public class RpcfxResponse {

    private Object result;
    private boolean status;
    private Exception exception;

}