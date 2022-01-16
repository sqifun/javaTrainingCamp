package com.sqifun.jtc.week3.handle.impl;

import com.sqifun.jtc.week3.handle.HttpHandler;
import com.sqifun.jtc.week3.outbound.HttpOutboundHandler;
import com.sqifun.jtc.week3.outbound.filter.HttpResponseFilter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;

/**
 * @program: week3-part1-4
 * @className: HttpClientOutboundHandler
 * @description:
 * @author: sqi
 * @date: 2022-01-16 14:53
 * @version: 1.0
 **/
public class HttpClientHandler implements HttpHandler {

    @Override
    public void handle(FullHttpRequest fullRequest, ChannelHandlerContext ctx, String endpoint, HttpResponseFilter responseFilter) {
        final String url = endpoint + fullRequest.uri();
        CloseableHttpAsyncClient client = HttpAsyncClients.createDefault();
        client.start();
        final HttpGet httpGet = new HttpGet(url);

        client.execute(httpGet, new FutureCallback<HttpResponse>() {
            @Override
            public void completed(final HttpResponse endpointResponse) {
                try {
                    HttpOutboundHandler httpOutboundHandler = new HttpOutboundHandler(responseFilter);
                    httpOutboundHandler.handleResponse(fullRequest, ctx, endpointResponse);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(final Exception ex) {
                httpGet.abort();
                ex.printStackTrace();
            }

            @Override
            public void cancelled() {
                httpGet.abort();
            }
        });
    }

}