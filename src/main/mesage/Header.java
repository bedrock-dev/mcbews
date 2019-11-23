package mesage;

import com.alibaba.fastjson.annotation.JSONField;

import java.security.PublicKey;
import java.util.UUID;

public class Header {
    @JSONField(ordinal = 1)
    private String requestId;
    @JSONField(ordinal = 2)
    private String messagePurpose;
    @JSONField(ordinal = 3)
    private int version;
    @JSONField(ordinal = 4)
    private String messageType;

    public Header(String requestId, String messagePurpose, int version, String messageType) {
        this.requestId = requestId;
        this.messagePurpose = messagePurpose;
        this.version = version;
        this.messageType = messageType;
    }

    public Header(String messagePurpose ,String messageType){
        this(UUID.randomUUID().toString(),messagePurpose,1,messageType);
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getMessagePurpose() {
        return messagePurpose;
    }

    public void setMessagePurpose(String messagePurpose) {
        this.messagePurpose = messagePurpose;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
}


