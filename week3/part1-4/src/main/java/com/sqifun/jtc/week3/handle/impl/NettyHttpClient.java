package com.sqifun.jtc.week3.handle.impl;

import com.sqifun.jtc.week3.handle.HttpHandler;
import com.sqifun.jtc.week3.outbound.HttpOutboundHandler;
import com.sqifun.jtc.week3.outbound.filter.HttpResponseFilter;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.DefaultHttpResponse;
import io.netty.handler.codec.http.DefaultLastHttpContent;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.codec.http.HttpResponseDecoder;
import io.netty.util.CharsetUtil;

/**
 * @program: week3-part1-4
 * @className: NettyHttpClient
 * @description:
 * @author: sqi
 * @date: 2022-01-16 18:15
 * @version: 1.0
 **/
public class NettyHttpClient implements HttpHandler {

    @Override
    public void handle(FullHttpRequest fullRequest, ChannelHandlerContext ctx, String endpoint, HttpResponseFilter responseFilter) {
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) {
                    // 客户端接收到的是httpResponse响应，所以要使用HttpResponseDecoder进行解码
                    ch.pipeline().addLast(new HttpResponseDecoder());
//                    客户端发送的是httprequest，所以要使用HttpRequestEncoder进行编码
                    ch.pipeline().addLast(new HttpRequestEncoder());
                    ch.pipeline().addLast(new ServerHandr());
                }
            });

            // Start the client.
            String[] split = endpoint.split(":");
            ChannelFuture f = b.connect("localhost", 8803).sync();
            System.out.println("客户端连接服务器成功 ...");

            f.channel().flush();
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }

    static class ServerHandr extends ChannelInboundHandlerAdapter {



        /**
         * 读取数据 : 在服务器端读取客户端发送的数据
         * @param ctx
         *      通道处理者上下文对象 : 封装了 管道 ( Pipeline ) , 通道 ( Channel ), 客户端地址信息
         *      管道 ( Pipeline ) : 注重业务逻辑处理 , 可以关联很多 Handler
         *      通道 ( Channel ) : 注重数据读写
         * @param msg
         *      客户端上传的数据
         * @throws Exception
         */
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            // 查看 ChannelHandlerContext 中封装的内容
            System.out.println("channelRead : ChannelHandlerContext ctx = " + ctx);

            // 将客户端上传的数据转为 ByteBuffer
            // 这里注意该类是 Netty 中的 io.netty.buffer.ByteBuf 类
            // 不是 NIO 中的 ByteBuffer
            // io.netty.buffer.ByteBuf 性能高于 java.nio.ByteBuffer
            DefaultHttpResponse fullRequest = (DefaultHttpResponse) msg;
            // 将 ByteBuf 缓冲区数据转为字符串, 打印出来
            System.out.println(ctx.channel().remoteAddress() + " 接收到客户端发送的数据 : "
                    /*fullRequest.toString(CharsetUtil.UTF_8)*/);
        }

        /**
         * 服务器端读取数据完毕后回调的方法
         * @param ctx
         *      通道处理者上下文对象 : 封装了 管道 ( Pipeline ) , 通道 ( Channel ), 客户端地址信息
         *      *      管道 ( Pipeline ) : 注重业务逻辑处理 , 可以关联很多 Handler
         *      *      通道 ( Channel ) : 注重数据读写
         * @throws Exception
         */
        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
            // 数据编码 : 将字符串编码, 存储到 io.netty.buffer.ByteBuf 缓冲区中
            ByteBuf byteBuf = Unpooled.copiedBuffer("Hello Client", CharsetUtil.UTF_8);

            // 写出并刷新操作 : 写出数据到通道的缓冲区 ( write ), 并执行刷新操作 ( flush )
            ctx.writeAndFlush(byteBuf);
        }

        /**
         * 异常处理 , 上面的方法中都抛出了 Exception 异常, 在该方法中进行异常处理
         * @param ctx
         * @param cause
         * @throws Exception
         */
        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            System.out.println("通道异常, 关闭通道");
            cause.printStackTrace();
            //如果出现异常, 就关闭该通道
            ctx.close();
        }
    }
}