package net;

import debug.Logger;
import mesage.EventType;
import mesage.Message;
import mesage.ReqMsgBuilder;
import mesage.ReqMsgPurpose;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class MCWebSocket extends WebSocketServer {
    private ConcurrentHashMap<WebSocket,Client> clients;
    private ArrayList<Listener> listeners;
    public MCWebSocket(String hostname,int port) {
        super(new InetSocketAddress(hostname,port));
        clients = new ConcurrentHashMap<WebSocket, Client>();
        listeners = new ArrayList<Listener>();
    }


    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {
        Client c = new Client(webSocket);
        clients.put(webSocket,c);
        Logger.i("new Client connected");
        for (Listener listener:listeners)
            listener.onConnected(c);
    }

    public void onClose(WebSocket webSocket, int i, String s, boolean b) {
        Client client =  clients.remove(webSocket);
        Logger.i("a Client disconnection");
        for (Listener listener:listeners)
            listener.onDisconnected(client);
    }

    public void onMessage(WebSocket webSocket, String s) {
        Logger.d("new msg: "+s);
        for (Listener listener:listeners){
            try {
                listener.onEvent(clients.get(webSocket),s);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void onError(WebSocket webSocket, Exception e) {
        Logger.e("error");
    }

    public void addListener(Listener listener){
        this.listeners.add(listener);
    }

    public void removeListener(Listener listener){
        this.listeners.remove(listener);
    }
}
