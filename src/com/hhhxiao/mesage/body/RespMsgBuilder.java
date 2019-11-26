package mesage.body;

import mesage.Header;
import mesage.Message;

public class RespMsgBuilder {
    private Message message;
    private RespMsgPurpose purpose;

    public RespMsgBuilder(RespMsgPurpose purpose) {
        this.purpose = purpose;
        this.message = new Message();
    }

    public RespMsgBuilder eventBody(String eventType) {
        this.message.setBody(new EventResponseBody(eventType, null, null));
        return this;
    }

    public RespMsgBuilder commandBody(int statusCode) {
        this.message.setBody(new CommandResponseBody(statusCode, null));
        return this;
    }

    public Message build() {
        switch (purpose) {
            case COMMAND_RESPONSE:
                this.message.setHeader(new Header("commandResponse", null));
                break;
            case EVENT:
                this.message.setHeader(new Header("event", null));
                break;
            default:
                break;
        }
        return this.message;
    }

}
