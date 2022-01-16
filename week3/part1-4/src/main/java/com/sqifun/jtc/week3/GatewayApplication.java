package com.sqifun.jtc.week3;

import com.sqifun.jtc.week3.handle.HttpHandler;
import com.sqifun.jtc.week3.inbound.filter.HttpRequestFilter;
import com.sqifun.jtc.week3.inbound.router.HttpEndpointRouter;
import com.sqifun.jtc.week3.netty.NettyHttpServer;
import com.sqifun.jtc.week3.outbound.filter.HttpResponseFilter;

import java.util.Arrays;
import java.util.List;

/**
 * @program: week3-part1-4
 * @className: GatewayApplication
 * @description:
 * @author: sqi
 * @date: 2022-01-15 17:12
 * @version: 1.0
 **/
public class GatewayApplication {

    public static final Integer PORT = 9999;

    public static final List<String> ENDPOINTS = Arrays.asList("http://localhost:8801", "http://localhost:8802", "http://localhost:8803");

    public static void main(String[] args) {
        HttpHandler handler = null;
        HttpRequestFilter requestFilter = null;
        HttpResponseFilter responseFilter = null;
        HttpEndpointRouter router = null;
        NettyHttpServer server = new NettyHttpServer(PORT, ENDPOINTS);
        server.run(handler, requestFilter, responseFilter, router);
    }

}