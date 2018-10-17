package com.ganya.server.handler;

import com.ganya.protocol.request.MessageRequestPacket;
import com.ganya.protocol.response.MessageResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;

/**
 * @author loufeng
 * @date 2018/10/17 2:42 PM
 */
public class MessageRequestHandler extends SimpleChannelInboundHandler<MessageRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageRequestPacket msg) throws Exception {
        MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
        System.out.println(new Date() + ": 收到客户端消息: " + msg.getMsg());
        messageResponsePacket.setMsg("服务端回复【" + msg.getMsg() + "】");

        ctx.channel().writeAndFlush(messageResponsePacket);
    }
}
