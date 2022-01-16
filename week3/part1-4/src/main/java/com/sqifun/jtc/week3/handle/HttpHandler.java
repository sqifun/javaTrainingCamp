package com.sqifun.jtc.week3.handle;

import com.sqifun.jtc.week3.outbound.filter.HttpResponseFilter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @program: week3-part1-4
 * @className: HttpOutboundHandler
 * @description:
 * @author: sqi
 * @date: 2022-01-16 14:45
 * @version: 1.0
 **/
public interface HttpHandler {

    void handle(FullHttpRequest fullRequest, ChannelHandlerContext ctx, String endpoint, HttpResponseFilter responseFilter);

}