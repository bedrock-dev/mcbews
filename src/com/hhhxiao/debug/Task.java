package com.hhhxiao.debug;

import com.hhhxiao.Request.EventName;
import com.hhhxiao.net.Client;
import com.hhhxiao.net.Listener;
import com.hhhxiao.net.MCWebSocket;
import com.hhhxiao.resp.CommandResponse;
import com.hhhxiao.resp.EventResponse;

public class Task extends Thread {

    private final int interval;

    public Task(Runnable runnable, int interval) {
        super(runnable);
        this.interval = interval;
    }

    @Override
    public void run() {
        MCWebSocket webSocket = new MCWebSocket("127.0.0.1",1234);
        webSocket.addListener(new Listener() {
            @Override
            public void onCommandResponse(Client client, CommandResponse response) {

            }

            @Override
            public void onEventResponse(Client client, EventResponse response) {
               switch (response.getEventName()){
                   case EventName.BLOCK_BROKEN:
                       //todo 2
                       break;
                   case EventName.PLAYER_MESSAGE:
                       //todo 1
                       break;
                       //...
                   default:
                       break;
               }
            }

            @Override
            public void onConnected(Client client) {

            }

            @Override
            public void onDisconnected(Client client) {

            }
        });
    }
}
