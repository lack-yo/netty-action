package com.ganya.protocol.request;

import com.ganya.protocol.Packet;
import com.ganya.protocol.command.Command;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author loufeng
 * @date 2018/10/17 2:43 PM
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MessageRequestPacket extends Packet {
    private String msg;

    @Override
    public Byte getCommand() {
        return Command.MESSAGE_REQUEST;
    }
}
