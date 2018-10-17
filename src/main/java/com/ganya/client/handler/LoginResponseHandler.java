package com.ganya.client.handler;

import com.ganya.protocol.response.LoginResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 模拟，客户端登录执行器
 *
 * @author loufeng
 * @date 2018/10/12 2:55 PM
 */
public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponsePacket msg) throws Exception {
        //response解析
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //request
        super.channelActive(ctx);
    }

}
