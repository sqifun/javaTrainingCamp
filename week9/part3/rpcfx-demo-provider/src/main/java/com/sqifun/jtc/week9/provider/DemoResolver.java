package com.sqifun.jtc.week9.provider;

import com.sqifun.jtc.week9.core.api.RpcfxResolver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @program: week9-part3
 * @className: DemoResolver
 * @description:
 * @author: sqi
 * @date: 2022-03-12 13:54
 * @version: 1.0
 **/
public class DemoResolver implements RpcfxResolver, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object resolve(String serviceClass) {
        return this.applicationContext.getBean(serviceClass);
    }
}