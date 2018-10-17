package com.ganya.protocol;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 自定义协议，包
 *
 * @author loufeng
 * @date 2018/10/17 2:24 PM
 */
public abstract class Packet {
    /**
     * 协议版本号
     */
    @JSONField(deserialize = false, serialize = false)
    private Byte version = 1;

    public Byte getVersion() {
        return version;
    }

    public void setVersion(Byte version) {
        this.version = version;
    }

    /**
     * 获取包中command
     *
     * @return command
     */
    @JSONField(serialize = false)
    public abstract Byte getCommand();
}
