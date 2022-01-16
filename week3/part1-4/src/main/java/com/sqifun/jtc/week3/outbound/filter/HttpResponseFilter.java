package com.sqifun.jtc.week3.outbound.filter;

import io.netty.handler.codec.http.FullHttpResponse;

/**
 * @program: week3-part1-4
 * @className: HttpResponseFilter
 * @description:
 * @author: sqi
 * @date: 2022-01-16 14:50
 * @version: 1.0
 **/
public interface HttpResponseFilter {

    void filter(FullHttpResponse response);

}