package org.dohrm.test.websocket.single;

import org.dohrm.test.websocket.services.TestServices;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * @author MDO
 * @since 02/06/2015.
 */
public class SingleHandler extends TextWebSocketHandler {


    private final TestServices services;

    public SingleHandler(TestServices services) {
        this.services = services;
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
        session.sendMessage(new TextMessage(services.counterString(message.getPayload())));
    }
}
