package com.sqifun.jtc.week9.provider.controller;

import com.sqifun.jtc.week9.core.api.RpcfxRequest;
import com.sqifun.jtc.week9.core.api.RpcfxResponse;
import com.sqifun.jtc.week9.core.server.RpcfxInvoker;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: week9-part3
 * @className: ProviderController
 * @description:
 * @author: sqi
 * @date: 2022-03-12 16:40
 * @version: 1.0
 **/
@RestController
public class ProviderController {

    @Resource
    private RpcfxInvoker invoker;

    @PostMapping("/")
    public RpcfxResponse invoke(@RequestBody RpcfxRequest request) {
        return invoker.invoke(request);
    }

}