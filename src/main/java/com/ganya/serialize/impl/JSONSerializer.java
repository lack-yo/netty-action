package com.ganya.serialize.impl;

import com.alibaba.fastjson.JSON;
import com.ganya.serialize.Serializer;
import com.ganya.serialize.SerializerAlogrithm;

/**
 * @author loufeng
 * @date 2018/10/17 3:43 PM
 */
public class JSONSerializer implements Serializer {

    @Override
    public byte getSerializerAlogrithm() {
        return SerializerAlogrithm.JSON;
    }

    @Override
    public byte[] serialize(Object object) {

        return JSON.toJSONBytes(object);
    }

    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {

        return JSON.parseObject(bytes, clazz);
    }
}
