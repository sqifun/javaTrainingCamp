package com.sqifun.jtc.week3.inbound.router;

import java.util.List;

/**
 * @program: week3-part1-4
 * @className: HttpEndpointRouter
 * @description:
 * @author: sqi
 * @date: 2022-01-16 15:16
 * @version: 1.0
 **/
public interface HttpEndpointRouter {

    String route(List<String> endpoints);

    // Load Balance
    // Random
    // RoundRibbon
    // Weight
    // - server01,20
    // - server02,30
    // - server03,50

}