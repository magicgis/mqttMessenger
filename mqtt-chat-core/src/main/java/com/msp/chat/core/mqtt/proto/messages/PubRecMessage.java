package com.msp.chat.core.mqtt.proto.messages;

/**
 * Placeholder for PUBREC message.
 * 
 * @author andrea
 */
public class PubRecMessage extends MessageIDMessage {
    
    public PubRecMessage() {
        m_messageType = AbstractMessage.PUBREC;
    }
}
