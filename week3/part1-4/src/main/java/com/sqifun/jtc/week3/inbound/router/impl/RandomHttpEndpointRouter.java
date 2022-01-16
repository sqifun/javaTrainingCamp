package com.sqifun.jtc.week3.inbound.router.impl;

import com.sqifun.jtc.week3.inbound.router.HttpEndpointRouter;

import java.util.List;
import java.util.Random;

/**
 * @program: week3-part1-4
 * @className: RandomHttpEndpointRouter
 * @description:
 * @author: sqi
 * @date: 2022-01-16 16:48
 * @version: 1.0
 **/
public class RandomHttpEndpointRouter implements HttpEndpointRouter {

    @Override
    public String route(List<String> endpoints) {
        int size = endpoints.size();
        Random random = new Random(System.currentTimeMillis());
        return endpoints.get(random.nextInt(size));
    }
}