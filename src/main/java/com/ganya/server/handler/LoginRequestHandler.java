package com.ganya.server.handler;

import com.ganya.protocol.request.LoginRequestPacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * server登录请求执行器
 *
 * @author loufeng
 * @date 2018/10/12 2:54 PM
 */
public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket msg) throws Exception {

    }
}
