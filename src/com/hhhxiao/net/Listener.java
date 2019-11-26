package net;

import mesage.Message;

import java.io.IOException;

/**
 * @author Jocapa3
 */
public interface Listener {
    public void onResponse(Client client, Message request,Message response);
    public void onEvent(Client client,String s) throws IOException;
    public void onConnected(Client client);
    public void onDisconnected(Client client);

}
