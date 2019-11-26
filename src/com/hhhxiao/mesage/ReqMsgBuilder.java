package mesage;

import mesage.body.CommandRequestBody;
import mesage.body.EventRequestBody;

public class ReqMsgBuilder {
    private Message message;
    private ReqMsgPurpose purpose;

    public ReqMsgBuilder(ReqMsgPurpose purpose){
        message = new Message();
        this.purpose = purpose;
    }

    public ReqMsgBuilder commandBody(String command) {
//        if(this.purpose != RequestMessagePurpose.COMMAND_REQUEST)
//            throw  new BodyException("type error");
        message.setBody(new CommandRequestBody("origin", command, 1));
        return this;
    }

   public ReqMsgBuilder eventBody(String eventType) {
//        if(this.purpose == RequestMessagePurpose.COMMAND_REQUEST)
//            throw new BodyException("type error");
        message.setBody(new EventRequestBody(eventType));
        return this;
    }

    public Message build() {
        switch (purpose){
            case SUBSCRIBE:
                message.header = new Header("subscribe","commandRequest");
                break;
            case UNSUBSCRIBE:
                message.header = new Header("unsubscribe","commandRequest");
                break;
            case COMMAND_REQUEST:
                message.header = new Header("commandRequest","commandRequest");
                break;
            default:
                break;
        }
        return this.message;
    }
}
