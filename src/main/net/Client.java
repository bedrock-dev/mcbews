package net;

import mesage.Message;
import mesage.ReqMsgBuilder;
import mesage.ReqMsgPurpose;
import org.java_websocket.WebSocket;

public class Client {
    private final WebSocket webSocket;

    public Client(WebSocket w) {
        webSocket = w;
    }

    public void  send(Message message){
        webSocket.send(message.toJSONString());
    }

    public void sendCommand(String command){
        Message message = new ReqMsgBuilder(ReqMsgPurpose.COMMAND_REQUEST)
                .commandBody(command).build();
        send(message);
    }

    public void subscribe(String event){
        Message message = new ReqMsgBuilder(ReqMsgPurpose.SUBSCRIBE)
                .eventBody(event).build();
        send(message);
    }


}
