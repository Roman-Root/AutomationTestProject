package web_socket;

import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class Web_Socket_Client extends org.java_websocket.client.WebSocketClient {

    private final SocketContext context;
    public Web_Socket_Client(URI serverUri, SocketContext context) throws URISyntaxException {
        super(new URI(context.getURI()));
        this.context = context;
    }

    public Web_Socket_Client(URI serverUri, Draft protocolDraft, SocketContext context) {
        super(serverUri, protocolDraft);
        this.context = context;
    }

    public Web_Socket_Client(URI serverUri, Map<String, String> httpHeaders, SocketContext context) {
        super(serverUri, httpHeaders);
        this.context = context;
    }

    public Web_Socket_Client(URI serverUri, Draft protocolDraft, Map<String, String> httpHeaders, SocketContext context) {
        super(serverUri, protocolDraft, httpHeaders);
        this.context = context;
    }

    public Web_Socket_Client(URI serverUri, Draft protocolDraft, Map<String, String> httpHeaders, int connectTimeout, SocketContext context) {
        super(serverUri, protocolDraft, httpHeaders, connectTimeout);
        this.context = context;
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        System.out.println("Open connection" + context.getURI());

    }

    @Override
    public void onMessage(String message) {
        System.out.println("Received new message"+ message);
        context.getMessageList().add(message);
        if(message.equals(context.getExpectedMessage())){
            closeConnection(1000, "Received expect message!");
        }

    }

    @Override
    public void onClose(int i, String s, boolean b) {

    }

    @Override
    public void onError(Exception e) {

    }
}
