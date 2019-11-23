package net;

import mesage.Message;

/**
 * @author Jocapa3
 */
public interface Listener {
    public void onResponse(Client client, Message request,Message response);
    public void onEvent(Client client,Message eventMessage);
    public void onConnected(Client client);
    public void onDisconnected(Client client);

}
