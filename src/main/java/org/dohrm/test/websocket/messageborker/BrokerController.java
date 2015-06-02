package org.dohrm.test.websocket.messageborker;

import org.dohrm.test.websocket.services.TestServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

/**
 * @author MDO
 * @since 02/06/2015.
 */
@Controller
public class BrokerController {

    @Autowired
    private SimpMessagingTemplate template;
    @Autowired
    private TestServices services;

    @MessageMapping("/broker")
    @SendTo("/topic/broker")
    public String handle(String message) {
        return services.counterString(message);
    }
}
