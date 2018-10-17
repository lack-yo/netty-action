package com.ganya.codec;

import com.ganya.protocol.PacketCodeC;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * 自定义解码器
 *
 * @author loufeng
 * @date 2018/10/17 2:24 PM
 */
public class PacketDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List out) {
        //将数据传递到链表的下一个节点
        out.add(PacketCodeC.INSTANCE.decode(in));
    }
}
