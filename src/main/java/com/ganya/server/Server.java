package com.ganya.server;

import com.ganya.codec.PacketDecoder;
import com.ganya.codec.PacketEncoder;
import com.ganya.codec.Spliter;
import com.ganya.server.handler.LoginRequestHandler;
import com.ganya.server.handler.MessageRequestHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * 模拟Server
 *
 * @author loufeng
 * @date 2018/9/29 2:27 PM
 */
public class Server {
    public static void main(String[] args) {
        //监听端口，accept 新连接的线程组
        NioEventLoopGroup parentGroup = new NioEventLoopGroup();
        //处理每一条连接的数据读写的线程组
        NioEventLoopGroup childGroup = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap
                .group(parentGroup, childGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) {
                        //定义后续每条连接的数据读写
                        ch.pipeline().addLast(new Spliter());
                        ch.pipeline().addLast(new PacketDecoder());
                        ch.pipeline().addLast(new LoginRequestHandler());
                        ch.pipeline().addLast(new MessageRequestHandler());
                        ch.pipeline().addLast(new PacketEncoder());
                    }
                });

        //绑定端口监听
        serverBootstrap.bind(8000).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println("绑定成功");
            } else {
                System.out.println("绑定失败");
            }
        });
    }

}
