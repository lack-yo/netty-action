package com.ganya.protocol;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * 自定义协议，包
 *
 * @author loufeng
 * @date 2018/10/17 2:24 PM
 */
@Data
public abstract class Packet {
    /**
     * 协议版本号，在序列化与反序列化中忽略
     */
    @JSONField(deserialize = false, serialize = false)
    private Byte version = 1;

    /**
     * 获取包中指令，在序列化中忽略
     *
     * @return command
     */
    @JSONField(serialize = false)
    public abstract Byte getCommand();
}
