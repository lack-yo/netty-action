package com.ganya;

import io.netty.util.AttributeKey;

/**
 * @author loufeng
 * @date 2018/10/17 9:31 PM
 */
public interface Attributes {
    AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");
}
