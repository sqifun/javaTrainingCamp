package com.sqifun.jtc.week3.inbound;

import com.sqifun.jtc.week3.handle.HttpHandler;
import com.sqifun.jtc.week3.handle.impl.HttpClientHandler;
import com.sqifun.jtc.week3.inbound.filter.HttpRequestFilter;
import com.sqifun.jtc.week3.inbound.filter.impl.DefaultHttpRequestFilter;
import com.sqifun.jtc.week3.inbound.router.HttpEndpointRouter;
import com.sqifun.jtc.week3.inbound.router.impl.RandomHttpEndpointRouter;
import com.sqifun.jtc.week3.outbound.filter.HttpResponseFilter;
import com.sqifun.jtc.week3.outbound.filter.impl.DefaultHttpResponseFilter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.util.ReferenceCountUtil;

import java.util.List;

/**
 * @program: week3-part1-4
 * @className: HttpInboundHandler
 * @description:
 * @author: sqi
 * @date: 2022-01-16 14:37
 * @version: 1.0
 **/
public class HttpInboundHandler extends ChannelInboundHandlerAdapter {

    private final List<String> endpoints;
    private final HttpHandler handler;
    private final HttpRequestFilter requestFilter;
    private final HttpResponseFilter responseFilter;
    private final HttpEndpointRouter router;

    public HttpInboundHandler(List<String> endpoints, HttpHandler handler, HttpRequestFilter requestFilter, HttpResponseFilter responseFilter, HttpEndpointRouter router) {
        this.endpoints = endpoints;
        this.handler = handler == null ? new HttpClientHandler() : handler;
        this.requestFilter = requestFilter == null ? new DefaultHttpRequestFilter() : requestFilter;
        this.responseFilter = responseFilter == null ? new DefaultHttpResponseFilter() : responseFilter;
        this.router = router == null ? new RandomHttpEndpointRouter() : router;
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        try {
            FullHttpRequest fullRequest = (FullHttpRequest) msg;
            requestFilter.filter(fullRequest, ctx);
            String endpoint = router.route(this.endpoints);
            handler.handle(fullRequest, ctx, endpoint, responseFilter);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

}