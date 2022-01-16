package com.sqifun.jtc.week3.netty;

import com.sqifun.jtc.week3.handle.HttpHandler;
import com.sqifun.jtc.week3.inbound.filter.HttpRequestFilter;
import com.sqifun.jtc.week3.inbound.router.HttpEndpointRouter;
import com.sqifun.jtc.week3.outbound.filter.HttpResponseFilter;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.util.List;

/**
 * @program: week3-part1-4
 * @className: NettyHttpServer
 * @description:
 * @author: sqi
 * @date: 2022-01-16 14:30
 * @version: 1.0
 **/
public class NettyHttpServer {

    private final int port;

    private final List<String> endpoints;

    public NettyHttpServer(int port, List<String> endpoints) {
        this.port = port;
        this.endpoints = endpoints;
    }

    public void run(HttpHandler handler, HttpRequestFilter requestFilter, HttpResponseFilter responseFilter, HttpEndpointRouter router) {

        EventLoopGroup bossGroup = new NioEventLoopGroup(5);
        EventLoopGroup workerGroup = new NioEventLoopGroup(16);

        try {
            ServerBootstrap b = new ServerBootstrap();
            b.option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.TCP_NODELAY, true)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childOption(ChannelOption.SO_REUSEADDR, true)
                    .childOption(ChannelOption.SO_RCVBUF, 32 * 1024)
                    .childOption(ChannelOption.SO_SNDBUF, 32 * 1024)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);

            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.DEBUG))
                    .childHandler(new NettyHttpInitializer(this.endpoints, handler, requestFilter, responseFilter, router));

            Channel ch = b.bind(port).sync().channel();
            System.out.println("开启netty http服务器，监听地址和端口为 http://127.0.0.1:" + port + '/');
            ch.closeFuture().sync();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

}