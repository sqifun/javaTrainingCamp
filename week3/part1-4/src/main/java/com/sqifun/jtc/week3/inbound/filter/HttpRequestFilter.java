package com.sqifun.jtc.week3.inbound.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @program: week3-part1-4
 * @className: HttpRequestFilter
 * @description:
 * @author: sqi
 * @date: 2022-01-16 14:48
 * @version: 1.0
 **/
public interface HttpRequestFilter {

    void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx);

}