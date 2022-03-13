package com.sqifun.jtc.week9.core.api;

import lombok.Builder;
import lombok.Data;

/**
 * @program: week9-part3
 * @className: ServiceProviderDesc
 * @description:
 * @author: sqi
 * @date: 2022-03-12 14:12
 * @version: 1.0
 **/
@Data
@Builder
public class ServiceProviderDesc {

    private String host;
    private Integer port;
    private String serviceClass;

    // group
    // version
}