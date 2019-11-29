package com.hhhxiao.net;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hhhxiao.debug.Logger;
import com.hhhxiao.resp.CommandResponse;
import com.hhhxiao.resp.EventResponse;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class MCWebSocket extends WebSocketServer {
    private ConcurrentHashMap<WebSocket, Client> clients;
    private ArrayList<Listener> listeners;

    public MCWebSocket(String hostname, int port) {
        super(new InetSocketAddress(hostname, port));
        clients = new ConcurrentHashMap<>();
        listeners = new ArrayList<>();
    }


    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {
        Client c = new Client(webSocket);
        clients.put(webSocket, c);
        Logger.i("new Client connected");
        for (Listener listener : listeners)
            listener.onConnected(c);
    }

    public void onClose(WebSocket webSocket, int i, String s, boolean b) {
        Client client = clients.remove(webSocket);
        Logger.i("a Client disconnection");
        for (Listener listener : listeners)
            listener.onDisconnected(client);
    }

    public void onMessage(WebSocket webSocket, String s) {
        JSONObject body = JSON.parseObject(s).getJSONObject("body");
        if (body.containsKey("eventName")) {
            Logger.i("new event response");

            for (Listener i : listeners)
                i.onEventResponse(clients.get(webSocket), new EventResponse(body));
        } else if (body.containsKey("statusCode")) {
            Logger.i("new command response");
            for (Listener i : listeners) {
                i.onCommandResponse(clients.get(webSocket), new CommandResponse(body));
            }
        }

    }

    public void onError(WebSocket webSocket, Exception e) {
        Logger.e("error");
    }

    public void addListener(Listener listener) {
        this.listeners.add(listener);
    }

    public void removeListener(Listener listener) {
        this.listeners.remove(listener);
    }
}
