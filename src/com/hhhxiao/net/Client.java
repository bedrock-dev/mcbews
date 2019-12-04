package com.hhhxiao.net;

import com.hhhxiao.Request.Request;
import com.hhhxiao.Request.RequestBuilder;
import com.hhhxiao.Request.RequestPurpose;
import org.java_websocket.WebSocket;

import java.util.List;
import java.util.Queue;

public class Client {
    private final WebSocket webSocket;

    private Queue<Runnable> tasks;

    public Client(WebSocket w) {
        webSocket = w;
    }

    public void send(Request request) {
        webSocket.send(request.toJSONString());
    }

    public void sendCommand(String command) {
        Request request = new RequestBuilder(RequestPurpose.COMMAND_REQUEST)
                .commandBody(command).build();
        send(request);
    }

    public void sendCommandSet(List<String> commands) {

        int index = 0;
        for (String command : commands) {
            if (index % 100 == 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            index++;
            sendCommand(command);
        }
    }


    public void subscribe(String event) {
        Request request = new RequestBuilder(RequestPurpose.SUBSCRIBE)
                .eventBody(event).build();
        send(request);
    }

    public WebSocket getWebSocket() {
        return webSocket;
    }
}
