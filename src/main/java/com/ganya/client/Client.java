package com.ganya.client;

import com.ganya.client.handler.LoginResponseHandler;
import com.ganya.client.handler.MessageResponseHandler;
import com.ganya.codec.PacketDecoder;
import com.ganya.codec.PacketEncoder;
import com.ganya.codec.Spliter;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * 模拟Client
 *
 * @author loufeng
 * @date 2018/9/29 2:30 PM
 */
public class Client {
    private static final int MAX_RETRY = 5;

    public static void main(String[] args) {
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();
        // 1.group指定线程模型
        // 2.channel指定 IO 类型为 NIO
        // 3.handler IO 处理逻辑
        bootstrap
                .group(workerGroup)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    public void initChannel(SocketChannel ch) {
                        //读写处理
                        ch.pipeline().addLast(new Spliter());
                        ch.pipeline().addLast(new PacketDecoder());
                        ch.pipeline().addLast(new LoginResponseHandler());
                        ch.pipeline().addLast(new MessageResponseHandler());
                        ch.pipeline().addLast(new PacketEncoder());
                    }
                });
        // 4.建立连接，最多重试5次
        connect(bootstrap, MAX_RETRY);
    }

    private static void connect(Bootstrap bootstrap, int retry) {
        bootstrap.connect("127.0.0.1", 8000).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println("连接成功!");
            } else {
                int tryCount = MAX_RETRY - retry;
                if (tryCount > 0) {
                    System.err.println("连接失败! 当前重试次数： " + tryCount);
                }
                //重连逻辑
                if (retry == 0) {
                    System.err.println("连接失败!重试次数耗尽");
                } else {
                    Thread.sleep(1000);
                    connect(bootstrap, retry - 1);
                }
            }

        });
    }

}
