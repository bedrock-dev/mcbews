package com.hhhxiao.net;

import com.hhhxiao.resp.CommandResponse;
import com.hhhxiao.resp.EventResponse;

public class EmptyListener implements Listener {
    @Override
    public void onCommandResponse(Client client, CommandResponse response) {

    }

    @Override
    public void onEventResponse(Client client, EventResponse response) {

    }

    @Override
    public void onConnected(Client client) {

    }

    @Override
    public void onDisconnected(Client client) {

    }
}
