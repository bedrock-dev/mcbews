import mesage.Message;
import mesage.ReqMsgBuilder;
import mesage.ReqMsgPurpose;
import net.Client;
import net.MCListener;
import net.MCWebSocket;

import java.net.UnknownHostException;

class MyListener extends MCListener {
    @Override
    public void onConnected(Client client) {
        super.onConnected(client);
        client.sendCommand("/say hello");
        client.subscribe("VehicleExited");
        client.subscribe("WorldExported");
        client.subscribe("WorldGenerated");
    }
}

public class Main {
    public static void main(String[] args) throws UnknownHostException {
        MCWebSocket webSocket = new MCWebSocket("127.0.0.1", 1234);
        webSocket.addListener(new MyListener());
        webSocket.run();
    }
}
