package com.sqifun.jtc.week9.provider.config;

import com.sqifun.jtc.week9.api.UserService;
import com.sqifun.jtc.week9.core.api.RpcfxResolver;
import com.sqifun.jtc.week9.core.server.RpcfxInvoker;
import com.sqifun.jtc.week9.provider.DemoResolver;
import com.sqifun.jtc.week9.provider.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: week9-part3
 * @className: ProviderConfig
 * @description:
 * @author: sqi
 * @date: 2022-03-12 16:41
 * @version: 1.0
 **/
@Configuration
public class ProviderConfig {

    @Bean
    public RpcfxInvoker createInvoker(@Autowired RpcfxResolver resolver){
        return new RpcfxInvoker(resolver);
    }

    @Bean
    public RpcfxResolver createResolver(){
        return new DemoResolver();
    }

    // 能否去掉name
    //

    // annotation


    @Bean(name = "com.sqifun.jtc.week9.api.UserService")
    public UserService createUserService(){
        return new UserServiceImpl();
    }

}