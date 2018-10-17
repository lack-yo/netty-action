package com.ganya.protocol.response;

import com.ganya.protocol.Packet;
import com.ganya.protocol.command.Command;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author loufeng
 * @date 2018/10/17 2:32 PM
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class LoginResponsePacket extends Packet {
    private boolean success;
    private String reason;

    @Override
    public Byte getCommand() {
        return Command.LOGIN_RESPONSE;
    }
}
