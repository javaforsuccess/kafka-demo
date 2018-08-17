package org.pratap.sbms.kafkamsgng.model;

/**
 * Created by singsate on 16-Aug-18.
 */
public class SimpleMessage {

    private String senderName;
    private String senderMessage;

    public SimpleMessage() {
    }

    public SimpleMessage(String senderName, String senderMessage) {
        this.senderName = senderName;
        this.senderMessage = senderMessage;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderMessage() {
        return senderMessage;
    }

    public void setSenderMessage(String senderMessage) {
        this.senderMessage = senderMessage;
    }

    @Override
    public String toString() {
        return "["+this.getSenderName()+"]-->"+this.getSenderMessage();
    }
}
