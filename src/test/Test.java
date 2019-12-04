package test;

import com.hhhxiao.Request.EventName;
import com.hhhxiao.debug.Logger;
import com.hhhxiao.net.Client;
import com.hhhxiao.net.EmptyListener;
import com.hhhxiao.net.Listener;
import com.hhhxiao.net.MCWebSocket;
import com.hhhxiao.resp.CommandResponse;
import com.hhhxiao.resp.EventResponse;

import java.util.ArrayList;
import java.util.List;

class MyListener extends EmptyListener {
    private boolean flag = true;

    @Override
    public void onConnected(Client client) {
        super.onConnected(client);
        client.subscribe(EventName.PLAYER_MESSAGE);
    }

    @Override
    public void onEventResponse(Client client, EventResponse response) {
        super.onEventResponse(client, response);
        if (response.getEventName().equals(EventName.PLAYER_MESSAGE)) {
            if (response.getMessage().startsWith("test")) {
                String[] str = response.getMessage().split(" ");
                final int x = Integer.parseInt(str[1])/2;
                final int y = Integer.parseInt(str[2])/2;
                List<String> commands = new ArrayList<>();
                for (int i = -x; i < x; i++) {
                    for (int j = -y; j < y; j++) {
                        commands.add("/setblock ~" + i + "~4~" + j + " stone");
                    }
                }
                commands.add("/say placed finished");
                new Thread(() -> client.sendCommandSet(commands)).start();
            }
        }
    }

    @Override
    public void onCommandResponse(Client client, CommandResponse response) {
        super.onCommandResponse(client, response);
        Logger.d(response.getStatusCode()+" : "+response.getStatusMessage());
    }
}

public class Test {
    public static void main(String[] args) {
        MCWebSocket webSocket = new MCWebSocket("127.0.0.1", 1234);
        webSocket.addListener(new MyListener());
        webSocket.run();
    }
}
