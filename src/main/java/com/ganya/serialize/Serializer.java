package com.ganya.serialize;

import com.ganya.serialize.impl.JSONSerializer;

/**
 * @author loufeng
 * @date 2018/10/17 3:42 PM
 */
public interface Serializer {
    Serializer DEFAULT = new JSONSerializer();

    /**
     * 序列化算法
     *
     * @return 算法
     */
    byte getSerializerAlogrithm();

    /**
     * java 对象转换成二进制
     */
    byte[] serialize(Object object);

    /**
     * 二进制转换成 java 对象
     */
    <T> T deserialize(Class<T> clazz, byte[] bytes);
}
