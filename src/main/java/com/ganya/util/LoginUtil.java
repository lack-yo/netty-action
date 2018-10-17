package com.ganya.util;

import com.ganya.Attributes;
import io.netty.channel.Channel;
import io.netty.util.Attribute;

/**
 * @author loufeng
 * @date 2018/10/17 9:31 PM
 */
public class LoginUtil {
    public static void markAsLogin(Channel channel) {
        channel.attr(Attributes.LOGIN).set(true);
    }

    public static boolean hasLogin(Channel channel) {
        Attribute<Boolean> loginAttr = channel.attr(Attributes.LOGIN);

        return loginAttr.get() != null;
    }
}
