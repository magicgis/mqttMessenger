package com.msp.chat.server.bean.events;

/**
 * Used to model the connection lost event
 * 
 * @author andrea
 */
public class LostConnectionEvent extends MessagingEvent {
    private String m_clientID;

    public LostConnectionEvent(String clienID) {
        m_clientID = clienID;
    }

    public String getClientID() {
        return m_clientID;
    }
    
}
