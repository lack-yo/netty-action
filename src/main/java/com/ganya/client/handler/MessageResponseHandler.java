package com.ganya.client.handler;

import com.ganya.protocol.response.MessageResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;

/**
 * 普通消息处理执行器
 *
 * @author loufeng
 * @date 2018/10/17 2:42 PM
 */
public class MessageResponseHandler extends SimpleChannelInboundHandler<MessageResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageResponsePacket msg) throws Exception {
        System.out.println(new Date() + ": 收到服务端的消息: " + msg.getMsg());
    }

}
