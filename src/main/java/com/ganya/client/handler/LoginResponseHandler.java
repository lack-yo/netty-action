package com.ganya.client.handler;

import com.ganya.protocol.request.LoginRequestPacket;
import com.ganya.protocol.response.LoginResponsePacket;
import com.ganya.util.LoginUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;

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
        if (msg.isSuccess()) {
            System.out.println(new Date() + ": 客户端登录成功");
            LoginUtil.markAsLogin(ctx.channel());
        } else {
            System.out.println(new Date() + ": 客户端登录失败，原因：" + msg.getReason());
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //request
        // 创建登录对象
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        loginRequestPacket.setUsername("lf");
        loginRequestPacket.setPwd("pwd");

        // 写数据
        ctx.channel().writeAndFlush(loginRequestPacket);
    }

}
