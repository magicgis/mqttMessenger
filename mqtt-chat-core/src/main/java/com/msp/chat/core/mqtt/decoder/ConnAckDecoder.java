package com.msp.chat.core.mqtt.decoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import java.util.List;
import com.msp.chat.core.mqtt.proto.messages.ConnAckMessage;

/**
 *
 * @author andrea
 */
class ConnAckDecoder extends DemuxDecoder {

    @Override
    void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        in.resetReaderIndex();
        //Common decoding part
        ConnAckMessage message = new ConnAckMessage();
        if (!decodeCommonHeader(message, in)) {
            in.resetReaderIndex();
            return;
        }
        //skip reserved byte
        in.skipBytes(1);
        
        //read  return code
        message.setReturnCode(in.readByte());
        out.add(message);
    }
    
}
