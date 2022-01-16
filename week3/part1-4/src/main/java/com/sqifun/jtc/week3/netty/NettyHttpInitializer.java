package com.sqifun.jtc.week3.netty;

import com.sqifun.jtc.week3.handle.HttpHandler;
import com.sqifun.jtc.week3.inbound.HttpInboundHandler;
import com.sqifun.jtc.week3.inbound.filter.HttpRequestFilter;
import com.sqifun.jtc.week3.inbound.router.HttpEndpointRouter;
import com.sqifun.jtc.week3.outbound.filter.HttpResponseFilter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

import java.util.List;

/**
 * @program: week3-part1-4
 * @className: NettyHttpInitializer
 * @description:
 * @author: sqi
 * @date: 2022-01-16 14:35
 * @version: 1.0
 **/
public class NettyHttpInitializer extends ChannelInitializer<SocketChannel> {

    private final List<String> endpoints;
    private final HttpHandler handler;
    private final HttpRequestFilter requestFilter;
    private final HttpResponseFilter responseFilter;
    private final HttpEndpointRouter router;

    public NettyHttpInitializer(List<String> endpoints, HttpHandler handler, HttpRequestFilter requestFilter, HttpResponseFilter responseFilter, HttpEndpointRouter router) {
        this.endpoints = endpoints;
        this.handler = handler;
        this.requestFilter = requestFilter;
        this.responseFilter = responseFilter;
        this.router = router;
    }

    @Override
    public void initChannel(SocketChannel socketChannel) {
        ChannelPipeline p = socketChannel.pipeline();
        p.addLast(new HttpServerCodec());
        p.addLast(new HttpObjectAggregator(1024 * 1024));
        p.addLast(new HttpInboundHandler(this.endpoints, this.handler, this.requestFilter, this.responseFilter, this.router));
    }

}