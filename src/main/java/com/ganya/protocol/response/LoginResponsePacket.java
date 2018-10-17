package com.ganya.protocol.response;

import com.ganya.protocol.Packet;
import com.ganya.protocol.command.Command;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author loufeng
 * @date 2018/10/17 2:32 PM
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponsePacket extends Packet {
    /**
     * 成功标志
     */
    private boolean success;
    /**
     * 失败原因
     */
    private String reason;

    @Override
    public Byte getCommand() {
        return Command.LOGIN_RESPONSE;
    }
}
