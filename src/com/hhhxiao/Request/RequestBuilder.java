package com.hhhxiao.Request;

import com.hhhxiao.Request.body.CommandRequestBody;
import com.hhhxiao.Request.body.EventRequestBody;
import com.hhhxiao.Request.body.Header;

public class RequestBuilder {
    private Request request;
    private RequestPurpose purpose;

    public RequestBuilder(RequestPurpose purpose){
        request = new Request();
        this.purpose = purpose;
    }
    public RequestBuilder commandBody(String command) {
//        if(this.purpose != RequestMessagePurpose.COMMAND_REQUEST)
//            throw  new BodyException("type error");
        request.setBody(new CommandRequestBody("origin", command, 1));
        return this;
    }

   public RequestBuilder eventBody(String eventType) {
//        if(this.purpose == RequestMessagePurpose.COMMAND_REQUEST)
//            throw new BodyException("type error");
        request.setBody(new EventRequestBody(eventType));
        return this;
    }

    public Request build() {
        switch (purpose){
            case SUBSCRIBE:
                request.header = new Header("subscribe","commandRequest");
                break;
            case UNSUBSCRIBE:
                request.header = new Header("unsubscribe","commandRequest");
                break;
            case COMMAND_REQUEST:
                request.header = new Header("commandRequest","commandRequest");
                break;
            default:
                break;
        }
        return this.request;
    }
}
