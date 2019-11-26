package com.hhhxiao.net;

import com.hhhxiao.Request.Request;
import com.hhhxiao.resp.EventResponse;
import com.hhhxiao.resp.Response;

import java.io.IOException;

/**
 * @author Jocapa3
 */
public interface Listener {
    public void onEvent(Client client, Response response) throws IOException;
    public void onConnected(Client client);
    public void onDisconnected(Client client);
}
