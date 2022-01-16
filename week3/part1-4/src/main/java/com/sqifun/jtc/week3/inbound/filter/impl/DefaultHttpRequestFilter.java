package com.sqifun.jtc.week3.inbound.filter.impl;

import com.sqifun.jtc.week3.inbound.filter.HttpRequestFilter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @program: week3-part1-4
 * @className: DefaultHttpRequestFilter
 * @description:
 * @author: sqi
 * @date: 2022-01-16 16:50
 * @version: 1.0
 **/
public class DefaultHttpRequestFilter implements HttpRequestFilter {

    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {

    }
}