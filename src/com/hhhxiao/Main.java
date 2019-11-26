package com.hhhxiao;

import com.hhhxiao.debug.Logger;
import com.hhhxiao.net.Client;
import com.hhhxiao.net.Listener;
import com.hhhxiao.net.MCWebSocket;
import com.hhhxiao.resp.Response;

/**************************TEST**********************************/
public class Main {
    public static void main(String[] args) {
        Logger.setLogLevel(Logger.INFO);
        MCWebSocket webSocket = new MCWebSocket("127.0.0.1", 1234);
        webSocket.addListener(new Listener() {
            @Override
            public void onEvent(Client client, Response response) {
                System.out.println(response.getRawString());
            }

            @Override
            public void onConnected(Client client) {
                if (client != null) {
                    client.sendCommand("/say 123");
                    client.sendCommand("/tp ~2 ~6 ~10");
                }
            }

            @Override
            public void onDisconnected(Client client) {

            }
        });
        webSocket.run();
    }
}
