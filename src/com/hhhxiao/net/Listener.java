package com.hhhxiao.net;

import com.hhhxiao.resp.CommandResponse;
import com.hhhxiao.resp.EventResponse;

/**
 * @author Jocapa3
 */
public interface Listener {
    public void onCommandResponse(Client client, CommandResponse response);
    public void onEventResponse(Client client,EventResponse response);
    public void onConnected(Client client);
    public void onDisconnected(Client client);
}
